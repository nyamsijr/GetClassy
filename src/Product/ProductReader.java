package Product;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductReader {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        JFileChooser fileChooser = new JFileChooser();
        ArrayList<Product> productList = new ArrayList<>();
        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try (FileReader reader = new FileReader(selectedFile)) {
                boolean read = SafeInput.getYNConfirm(in, "Would you like to read the file?");

                if (read) {
                    try (Scanner fileScanner = new Scanner(selectedFile)) {
                        System.out.printf("%-7s %-12s %-25s %-11s%n", "ID#", "Name", "Description", "Cost");
                        System.out.println("===================================================");

                        while (fileScanner.hasNextLine()) {
                            String token = fileScanner.nextLine();
                            String[] data = token.split(",");

                            if (data.length == 4) {
                                try {
                                    String id = data[0].trim();
                                    String Name = data[1].trim();
                                    String Description = data[2].trim();
                                    double cost = Double.parseDouble(data[3].trim());

                                    Product product = new Product(id, Name, Description, cost);
                                    productList.add(product);
                                    System.out.printf("%-7s %-12s %-35s %-11s%n",
                                            product.getID(),
                                            product.getName(),
                                            product.getDescription(),
                                            product.getCost());

                                } catch (NumberFormatException e) {
                                    System.err.println("Invalid year of birth: " + data[4]);
                                }
                            } else {
                                System.err.println("Invalid data format: " + token);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + selectedFile.getAbsolutePath());
            }
        } else {
            System.out.println("No file was selected.");
            System.exit(0);
        }
    }
}

