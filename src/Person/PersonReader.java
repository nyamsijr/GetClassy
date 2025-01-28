package Person;

import javax.swing.JFileChooser;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonReader {
    public static void main(String[] args) {

        ArrayList<Person> personList = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();

        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("File selected: " + selectedFile.getAbsolutePath());


            Scanner in = new Scanner(System.in);
            boolean Continue = SafeInput.getYNConfirm(in, "Do you want to read the file's contents?");


            if (Continue) {
                try (Scanner fileScanner = new Scanner(selectedFile)) {

                    System.out.printf("%-7s %-12s %-12s %-8s %-6s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                    System.out.println("===============================================");


                    while (fileScanner.hasNextLine()) {
                        String token = fileScanner.nextLine();
                        String[] data = token.split(",");
                        if (data.length != 5) {
                            System.out.println("Skipping Invalid line: " + token);
                            continue;
                        }
                        try {
                            String id = data[0];
                            String first = data[1];
                            String last = data[2];
                            String title = data[3];
                            int yob = Integer.parseInt(data[4]);
                            Person person = new Person(id, first, last, title, yob);
                            personList.add(person);
                                System.out.printf("%-7s %-12s %-12s %-8s %-6s%n",
                                person.getIDNum(),
                                person.getFirstName(),
                                person.getLastname(),
                                person.getTitle(),
                                person.getYOB());

                        } catch (NumberFormatException e) {
                            System.out.println("Invalid YOB format for line: " + token);
                        }


                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Error: File not found.");
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                }

            } else {
                System.out.println("File reading cancelled");
            }
            in.close();
        } else {
            System.out.println("No file Selected");

        }
    }

}
