package Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonGenerator {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        ArrayList<Person> Persons = new ArrayList<>();

        do {

            String ID = SafeInput.getNonZeroLenString(in, "What is the ID?");
            String FirstName = SafeInput.getNonZeroLenString(in, "What is the First Name?");
            String LastName = SafeInput.getNonZeroLenString(in, "What is the Last Name?");
            String Title = SafeInput.getNonZeroLenString(in, "What is your Title?");

            int yob = 0;
            while (true) {
                yob = SafeInput.getInt(in, "Enter the year of birth (1940-2025)");
                if (yob >= 1940 && yob <= 2025) {
                    break;
                } else {
                    System.out.println("Invalid year of birth. Must be between 1940 and 2025.");
                }
            }
            Person person = new Person(FirstName, LastName, ID, Title, yob);
            Persons.add(person);

            System.out.println("Full Name: " + person.fullName());
            System.out.println("Formal Name: " + person.formalName());
            System.out.println("Current Age: " + person.getAge() + " years");


        } while (SafeInput.getYNConfirm(in, "Would you like to add another person?"));

        String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name");
        try (PrintWriter CSVwriter = new PrintWriter(new FileWriter(fileName + ".txt"));
             PrintWriter XMLwriter = new PrintWriter(new FileWriter(fileName + ".xml"));
             PrintWriter JSONwriter = new PrintWriter(new FileWriter(fileName + ".json"))                                                                              ) {

            for (Person p : Persons) {
                CSVwriter.println(p.toCSVDataRecord());
                XMLwriter.println(p.toXML());
                JSONwriter.println(p.toJSON());
            }

            System.out.println("text saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file " + e.getMessage());
        }


    }
}





