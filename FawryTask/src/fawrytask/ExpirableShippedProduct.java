/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fawrytask;

import java.util.Date;


public class ExpirableShippedProduct extends Product implements Ship{
    private Date expireDate;
    private double weight;
    public ExpirableShippedProduct(String name, double price, int quantity, Date expireDate, double weight) {
        super(name, price, quantity);
        this.expireDate = expireDate;
        this.weight = weight;
    }

    

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public boolean expired() {
        return new Date().after(this.expireDate);
    }

    @Override
    public boolean shipped() {
        return true;
    }
    
}
