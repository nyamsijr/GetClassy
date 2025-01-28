package Product;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Product> Products = new ArrayList<>();


        while (true) {


            String ID = SafeInput.getNonZeroLenString(in, "What is the ID?");
            String Name = SafeInput.getNonZeroLenString(in, "What is the Name?");
            String Description = SafeInput.getNonZeroLenString(in, "What is the description?");
            double Cost = SafeInput.getDouble(in, "What is the cost?");

            Product product = new Product(ID, Name, Description, Cost);
            Products.add(product);


            if (!SafeInput.getYNConfirm(in, "Would you like to add another item?")) {
                break;
            }
        }


        String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name");
        try (
                PrintWriter CSVwriter = new PrintWriter(new FileWriter(fileName + ".txt"));
                PrintWriter XMLwriter = new PrintWriter(new FileWriter(fileName + ".xml"));
                PrintWriter JSONwriter = new PrintWriter(new FileWriter(fileName + ".json"))
        ) {

            for (Product p : Products) {
                CSVwriter.println(p.toCSVDataRecord());
                XMLwriter.println(p.toXML());
                JSONwriter.println(p.toJSON());
            }
            System.out.println("Data Saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}


