package se.kth.iv1350.pointOfSale.view;

import se.kth.iv1350.pointOfSale.controller.Controller;
import se.kth.iv1350.pointOfSale.model.SoldItem;
import se.kth.iv1350.pointOfSale.model.TotalRevenueObserver;

import java.util.ArrayList;

/**
 * This is placeholder for real view, the user interface of the program. It's not
 * required to design the view for this task. It only contains execution with calls to all system operations
 * in controller.
 */
public class View {
    private Controller contr;

    public View(Controller contr) {
        this.contr = contr;
        // addObservers();
    }

    public void runInitializeSale() {
        contr.initializeSale();
        System.out.println("A new sale has been initialized.");

        try { contr.scanItem(123, 1); }
        catch (Exception e) { System.out.println(e.getMessage()); }

        try { contr.scanItem(123, 1); }
        catch (Exception e) { System.out.println(e.getMessage()); }

        try { contr.scanItem(999, 1); } // throw database exception
        catch (Exception e) { System.out.println(e.getMessage()); }

        try { contr.scanItem(456, 1); }
        catch (Exception e) { System.out.println(e.getMessage()); }

        try { contr.scanItem(987, 1); } // throw item invalid ID
        catch (Exception e) { System.out.println(e.getMessage()); }

        try { contr.scanItem(123, 1); }
        catch (Exception e) { System.out.println(e.getMessage()); }

        ArrayList<SoldItem> soldItems = contr.getSoldItems();
        for (SoldItem soldItem : soldItems) {
            printSoldItemInfo(soldItem);
        }

        contr.applyCombinedDiscounts(12345);
        contr.initializePayment(500);
    }

    /*


    public class View {
        private Controller contr;
        /**
         * Creates a new instance, that uses the controller for all calls to other layers.
         * @param contr The controller to use for all calls to other layers.
         */
        public View(Controller contr) {
            this.contr = contr;
            // addObservers();
        }

        /*
        private void addObservers() {
            TotalRevenueView totalRevenueView = new TotalRevenueView();
            TotalRevenueObserver totalRevenueObserver = new TotalRevenueFileOutput();
        }

         */
    }

    /**
     * A fake user face execution to the user interface that signals a sale has initialized.
     */
    public void runInitializeSale() {
        contr.initializeSale();
        System.out.println("A new sale has been initialized.");

        try { contr.scanItem(123, 1); }
        catch (Exception e) { System.out.println(e.getMessage()); }

        try { contr.scanItem(123, 1); }
        catch (Exception e) { System.out.println(e.getMessage()); }

        try { contr.scanItem(999, 1); } // throw database exception
        catch (Exception e) { System.out.println(e.getMessage()); }

        try { contr.scanItem(456, 1); }
        catch (Exception e) { System.out.println(e.getMessage()); }

        try { contr.scanItem(987, 1); } // throw item invalid ID
        catch (Exception e) { System.out.println(e.getMessage()); }

        try { contr.scanItem(123, 1); }
        catch (Exception e) { System.out.println(e.getMessage()); }

        ArrayList<SoldItem> soldItems = contr.getSoldItems();
        for (SoldItem soldItem : soldItems) {
            printSoldItemInfo(soldItem);
        }

        contr.applyCombinedDiscounts(12345);
        contr.initializePayment(500);
    }

    private void printSoldItemInfo(SoldItem soldItem) {
        System.out.println("Add " + soldItem.getItemQuantity() + " item with item id: " + soldItem.getItem().getItemID());
        System.out.println("ItemID: " + soldItem.getItem().getItemID());
        System.out.println("Item name: " + soldItem.getItem().getName());
        System.out.printf("Item cost: %.2f SEK\n", soldItem.getItem().getItemPrice());
        System.out.println("VAT: " + soldItem.getItem().getVAT()*100 + "%");
        System.out.println("Item description: " + soldItem.getItem().getItemDescription());
        System.out.printf("Total cost (incl VAT): %.2f SEK\n", soldItem.getSubTotal());
        System.out.printf("Total VAT: %.2f SEK\n", soldItem.getVATAmount());
        System.out.println();
    }
}
}
