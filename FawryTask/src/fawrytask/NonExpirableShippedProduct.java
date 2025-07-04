/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fawrytask;

/**
 *
 * @author PC
 */
public class NonExpirableShippedProduct extends Product implements Ship {

    private double weight;

    public NonExpirableShippedProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public boolean expired() {
        return false;
    }

    @Override
    public boolean shipped() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight; 
    }

}
