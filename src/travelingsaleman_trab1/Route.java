/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelingsaleman_trab1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Otavio Tarelho | Mariana Bispo | Leonardo de Oliveira
 * 
 */

public class Route {
    private ArrayList route = new ArrayList<City>();
    private double fitness = 0;
    private int distance = 0;
    
    public Route(){
        for (int i = 0; i < CityManager.size(); i++) {
            route.add(null);
        }
    }
    
    public Route(ArrayList route){
        this.route = route;
    }

    public void generate() {
        for (int i = 0; i < CityManager.size(); i++) {
          set(i, CityManager.get(i));
        }
        Collections.shuffle(route);
    }

    public City get(int pos) {
        return (City)route.get(pos);
    }

    public void set(int pos, City city) {
        route.set(pos, city);
        fitness = 0;
        distance = 0;
    }
    
    public double getFitness() { return (fitness == 0) ? fitness = 1/(double)getDistance(): fitness; }
    
    public int getDistance(){
        if (distance == 0) {
            int rDist = 0;
            for (int i=0; i < this.size(); i++) {
                City from = get(i);
                City dest = (i+1 < this.size()) ? get(i+1) : get(0);
                rDist += from.distance(dest);
                
            }
            return rDist;
        }
        return distance;
    }

    public int size() { return route.size(); }
    
    public boolean containsCity(City city){ return route.contains(city); }
    
    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += get(i) + "\n";
        }
        return geneString;
    }
}
