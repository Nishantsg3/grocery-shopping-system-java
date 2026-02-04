package src;

public class GroceryStore {

    private Inventory inventory;
    private float totalBill = 0;
    private StringBuilder receipt = new StringBuilder();

    public GroceryStore(Inventory inventory) {
        this.inventory = inventory;
    }

    public void purchaseItem(String name, int quantity) throws ItemNotFoundException {
        Item item = inventory.findItem(name);

        if (item.getStock() < quantity) {
            System.out.println("Insufficient stock for " + item.getName());
            return;
        }

        item.reduceStock(quantity);
        float cost = item.getPrice() * quantity;
        totalBill += cost;

        receipt.append(item.getName())
               .append(" x ")
               .append(quantity)
               .append(" = ₹")
               .append(cost)
               .append("\n");

        System.out.println("Added " + quantity + " x " + item.getName()
                + " | Item total: ₹" + cost);
    }

    public void finalizeBill() {
        receipt.append("\nSubtotal: ₹").append(totalBill).append("\n");

        if (totalBill > 100) {
            float discount = totalBill * 0.10f;
            float finalTotal = totalBill - discount;
            receipt.append("Discount (10%): ₹").append(discount).append("\n");
            receipt.append("Final Total: ₹").append(finalTotal).append("\n");
        } else {
            receipt.append("No discount applied\n");
            receipt.append("Final Total: ₹").append(totalBill).append("\n");
        }

        Receipt.generate(receipt.toString());
    }

    public void printFinalBill() {
        System.out.println("\nOriginal Total: ₹" + totalBill);
        if (totalBill > 100) {
            float discount = totalBill * 0.10f;
            System.out.println("Discount Applied: ₹" + discount);
            System.out.println("Final Total: ₹" + (totalBill - discount));
        } else {
            System.out.println("No discount applied.");
        }
    }
}
