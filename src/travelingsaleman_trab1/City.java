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

public class City {
    private int name;
    private double x;
    private double y;
    
    public City(int name, double x, double y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public int getName() { return name; }
    
    public double getX(){ return this.x; }
    
    public double getY(){ return this.y; }
    
    public double distance(City city){
        double xDistance = Math.abs(getX() - city.getX());
        double yDistance = Math.abs(getY() - city.getY());
        return Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
    }
    
    @Override
    public String toString(){
        return "Cidade:" + getName()+ " - Coordenadas: ("
                + getX() + ", " + getY() + ")";
    }
}
