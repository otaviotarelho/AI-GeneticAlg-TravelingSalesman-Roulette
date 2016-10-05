/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelingsaleman_trab1;

/**
 *
 * @author Otavio Tarelho | Mariana Bispo | Leonardo de Oliveira
 * 
 */

public class Population {
    Route[] routes;

    public Population(int populationSize, boolean gen) {
        routes = new Route[populationSize];
        if (gen) {
            for (int i = 0; i < size(); i++) {
                Route newTour = new Route();
                newTour.generate();
                save(i, newTour);
            }
        }
    }
    
    public void save(int i, Route tour) { routes[i] = tour; }
    
    public Route get(int i) { return routes[i]; }
    
    public int size() { return routes.length; }

    public Route getFittest() {
        Route fittest = routes[0];
        for (int i = 1; i < size(); i++) {
            if (fittest.getFitness() <= get(i).getFitness()) {
                fittest = get(i);
            }
        }
        return fittest;
    }
}
