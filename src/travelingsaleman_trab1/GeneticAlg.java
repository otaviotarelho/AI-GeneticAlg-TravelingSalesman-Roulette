/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelingsaleman_trab1;

import java.util.Random;

/**
 *
 * @author Otavio Tarelho | Mariana Bispo | Leonardo de Oliveira
 * 
 */

public class GeneticAlg {
    private static double mutation;

    public static void setMutation(double m) { GeneticAlg.mutation = m; }
    
    public static Route crossover(Route parent, Route parent_) {
        Route child = new Route();

        int startPos = (int) (Math.random() * parent.size());
        int endPos = (int) (Math.random() * parent.size());

        for (int i = 0; i < child.size(); i++) {
            if (startPos < endPos && i > startPos && i < endPos) {
                child.set(i, parent.get(i));
            } 
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.set(i, parent.get(i));
                }
            }
        }

        for (int i = 0; i < parent_.size(); i++) {
            if (!child.containsCity(parent_.get(i))) {
                for (int ii = 0; ii < child.size(); ii++) {
                    if (child.get(ii) == null) {
                        child.set(ii, parent_.get(i));
                        break;
                    }
                }
            }
        }
        
        return child;
    }

    private static void mutate(Route r) {
        for(int i=0; i < r.size(); i++){
            if(Math.random() < mutation){
                int j = (int) (r.size() * Math.random());

                City city1 = r.get(i);
                City city2 = r.get(j);

                r.set(j, city1);
                r.set(i, city2);
            }
        }
    }
    
    private static Route rouletteSelection(Population pop){
        double sumFittness = 0; // sum of all population fittness
        
        for (int i = 0; i < pop.size(); i++) {
            sumFittness += pop.get(i).getFitness();
        } // end for, got all sum
        
        
        double random = Math.random() * (sumFittness); // random number between 0 and sumfittness
        double partialSum = 0; // partial sum to get elements position in the roulette
        
        
        for (int i = pop.size() - 1; i > 0 ; i--) {
            partialSum += pop.get(i).getFitness();
            
            if(partialSum > random){
                return pop.get(i); 
            }// if partil sum > random, return i element of population
            
        }
      
        return pop.get(0); // if any item > 0 is satisfied, return first element of the population
    } 
    
    public static Population evolve(Population pop) {
        Population newPop = new Population(pop.size(), false);

        for (int i = 0; i < newPop.size(); i++) {
            Route parent1 = rouletteSelection(pop);
            Route parent2 = rouletteSelection(pop);
            Route child = crossover(parent1, parent2);
            newPop.save(i, child);
        }

        for (int i = 0; i < newPop.size(); i++) {
            mutate(newPop.get(i));
        }

        return newPop;
    }
}
