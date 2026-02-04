package src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Receipt {

    public static void generate(String content) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("receipt.txt", true))) {
            pw.println("====== GROCERY SHOP RECEIPT ======");
            pw.println("Date: " + LocalDateTime.now());
            pw.println(content);
            pw.println("=================================\n");
            System.out.println("\n----- RECEIPT -----");
            System.out.println(content);
            System.out.println("-------------------");
            System.out.println("Receipt saved to receipt.txt");
        } catch (IOException e) {
            System.out.println("Error writing receipt.");
        }
    }
}
