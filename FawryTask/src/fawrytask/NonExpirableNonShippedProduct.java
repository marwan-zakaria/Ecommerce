/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fawrytask;


public class NonExpirableNonShippedProduct extends Product{

    public NonExpirableNonShippedProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean expired() {
        return false;
    }

    @Override
    public boolean shipped() {
        return false;
    }
    
}
