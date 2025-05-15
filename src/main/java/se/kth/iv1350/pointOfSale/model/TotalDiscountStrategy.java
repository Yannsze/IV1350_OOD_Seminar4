package se.kth.iv1350.pointOfSale.model;

import se.kth.iv1350.pointOfSale.integration.DiscountDatabase;

public class TotalDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateDiscount(double totalPrice, int customerID) {
        double rate = DiscountDatabase.getInstance().getTotalDiscount(totalPrice);
        return totalPrice * rate;
    }
}