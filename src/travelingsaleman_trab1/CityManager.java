/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelingsaleman_trab1;

import java.util.ArrayList;

/**
 *
 * @author Otavio Tarelho | Mariana Bispo | Leonardo de Oliveira
 * 
 */

public class CityManager {
    private static ArrayList cities = new ArrayList<City>();

    public static void add(City c) { cities.add(c); }
    
    public static City get(int i){ return (City) cities.get(i); }
    
    public static int size(){ return cities.size(); }
    
    public static void remove() { cities.removeAll(cities); }
    
    public static boolean isEmpty(){ return cities.isEmpty(); }
}
