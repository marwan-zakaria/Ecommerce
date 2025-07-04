/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fawrytask;

import java.util.ArrayList;

public class Customer {

    private String name;
    private double balance;
    private ArrayList<CartItem> cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        cart = new ArrayList<>();
    }

    public void addToCart(Product p, int quantity) {
        cart.add(new CartItem(p, quantity));
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        double subtotal = 0;
        ArrayList<Ship> shipList = new ArrayList<>();
        ArrayList<Integer> shipQuantity = new ArrayList<>();
        StringBuilder receipt = new StringBuilder();

        receipt.append("** Checkout receipt **\n");
        for (CartItem item : this.cart) {
            Product p = item.getProduct();

            if (item.getQuantity() > p.getQuantity()) {
                System.out.println("Product " + p.getName() + " is out of stock");
                return;
            } else if (p.expired()) {
                System.out.println("Product " + p.getName() + " is expired");
                return;
            }
            p.reduceQuantity(item.getQuantity());
            
            subtotal += item.getTotalPrice();

            if (p instanceof Ship) {
                shipList.add((Ship) p);
                shipQuantity.add(item.getQuantity());
            }

            receipt.append(item.getQuantity()).append("x ").append(p.getName()).append("\t").append(item.getTotalPrice()).append("\n");
        }
        double shippingFee = 0;
        if (!shipList.isEmpty()) {
            shippingFee = ShippingService.shipProducts(shipList, shipQuantity) * 10;
        }
        double amount = shippingFee + subtotal;

        if (amount > this.balance) {
            System.out.println("Not enough balance");
            return;
        }
        this.balance -= amount;
        
        //The Customer Receipt
        receipt.append("----------------------\n");
        receipt.append("Subtotal\t").append(subtotal).append("\n");
        receipt.append("Shipping fees\t").append(shippingFee).append("\n");
        receipt.append("Amount\t\t").append(amount).append("\n");
        receipt.append("Remaining Balance\t").append(this.balance).append("\n");
        
        System.out.println(receipt.toString());

    }

}
