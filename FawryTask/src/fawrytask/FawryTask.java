/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fawrytask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FawryTask {

    
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date expiry1 = sdf.parse("2025-3-31");
        Date expiry2 = sdf.parse("2025-7-10");
        Date expiry3 = sdf.parse("2025-8-15");
        
        Product cheese = new ExpirableShippedProduct("Cheese", 40, 20, expiry1, 20);
        Product biscuit = new ExpirableNonShippedProduct("Biscuits", 60, 60, expiry2);
        Product tomato = new ExpirableShippedProduct("Tomato", 40, 20, expiry3, 20);
        Product tv = new NonExpirableShippedProduct("TV", 40, 20, 100);
        Product mobileCard = new NonExpirableNonShippedProduct("Card", 40, 20);
        
        Customer c = new Customer("Ahmed", 3000);
        Customer c2 = new Customer("Mohamed", 2000);
        Customer c3 = new Customer("Khalid", 200);
        Customer c4 = new Customer("Hassan", 500);
        
        //First Check
        c.addToCart(tv, 2);
        c.addToCart(tomato, 20);
        c.addToCart(mobileCard, 15);
        
        c.checkout();
        System.out.println("");
        //Check expire
        c2.addToCart(cheese, 10);
        c2.checkout();
        
        //Check amount
        c.addToCart(tv, 20);
        c.checkout();
        
        //Check balance
        c3.addToCart(biscuit, 30);
        c3.checkout();
        
        //Check Cart
        c4.checkout();
    }
    
}
