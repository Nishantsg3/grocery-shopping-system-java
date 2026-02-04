package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Load inventory from file
        Inventory inventory = Inventory.loadFromFile("inventory.txt");
        GroceryStore store = new GroceryStore(inventory);

        // Purchase loop
        while (true) {
            System.out.print("\nEnter item name (type Finish to checkout): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("Finish")) {
                break;
            }

            try {
                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(sc.nextLine());

                store.purchaseItem(input, quantity);

            } catch (ItemNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a number.");
            }
        }

        // Print final bill
        store.finalizeBill();

        // Additional features output
        System.out.println("\nAverage Item Price: ₹" + inventory.calculateAveragePrice());
        inventory.showItemsBelowPrice(50);

        // Save updated inventory back to file
        inventory.saveToFile("inventory.txt");

        sc.close();
    }
}
