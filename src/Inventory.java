package src;

import java.io.*;

public class Inventory {
    private Item[] items;

    public Inventory(Item[] items) {
        this.items = items;
    }

    // Load inventory from file
    public static Inventory loadFromFile(String filePath) {
        Item[] items = new Item[20];
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                float price = Float.parseFloat(data[1]);
                int stock = Integer.parseInt(data[2]);

                items[index++] = new Item(name, price, stock);
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory file.");
        }

        return new Inventory(items);
    }

    // Save inventory back to file
    public void saveToFile(String filePath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Item item : items) {
                pw.println(item.getName() + "," + item.getPrice() + "," + item.getStock());
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory file.");
        }
    }

    public Item findItem(String itemName) throws ItemNotFoundException {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        throw new ItemNotFoundException("Item '" + itemName + "' not found.");
    }

    public float calculateAveragePrice() {
        float sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum / items.length;
    }

    public void showItemsBelowPrice(float threshold) {
        System.out.println("\nItems below price ₹" + threshold + ":");
        for (Item item : items) {
            if (item.getPrice() < threshold) {
                System.out.println(item.getName() + " - ₹" + item.getPrice());
            }
        }
    }
}
