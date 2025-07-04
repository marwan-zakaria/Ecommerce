/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fawrytask;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ShippingService {
    public static double shipProducts(ArrayList<Ship> products, ArrayList<Integer> quantity) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (int i = 0; i < products.size(); i++) {
            double weight = quantity.get(i) * products.get(i).getWeight();
            System.out.println(quantity.get(i) + "x " + products.get(i).getName() + "\t " + weight + "g");
            totalWeight += weight;
        }
        totalWeight /= 1000;
        System.out.println("Total Package weight " + totalWeight + "kg");
        System.out.println();
        return totalWeight;
    }
    
}
