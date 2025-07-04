/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fawrytask;

import java.util.Date;


public class ExpirableNonShippedProduct extends Product {

    private Date expireDate;

    public ExpirableNonShippedProduct(String name, double price, int quantity, Date expireDate) {
        super(name, price, quantity);
        this.expireDate = expireDate;
    }

    @Override
    public boolean expired() {
        return new Date().after(this.expireDate);
    }

    @Override
    public boolean shipped() {
        return false;
    }

}
