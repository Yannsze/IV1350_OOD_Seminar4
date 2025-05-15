package se.kth.iv1350.pointOfSale.view;

import se.kth.iv1350.pointOfSale.model.TotalRevenueObserver;

/**
 * This is the view that is interested in notification of new total sum of a sale.
 */
public class TotalRevenueView implements TotalRevenueObserver {

    @Override
    public void newTotalPrice(double newTotalPrice) {
        System.out.format("Total income: %.2f SEK\n", newTotalPrice);
    }

}
