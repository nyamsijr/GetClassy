package SafeInput;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SafeInputObjTest {

    @Test
    void getNonZeroLenString() {
        String input = "Dojo\n";
        Scanner scanner = new Scanner(input);
        SafeInputObj inputObj = new SafeInputObj(scanner);
        String actual = inputObj.getNonZeroLenString("Enter a String");
        String expected = "Dojo";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getRangedInt() {
        String input = "69\n";
        Scanner scanner = new Scanner(input);
        SafeInputObj inputObj = new SafeInputObj(scanner);
        int actual = inputObj.getRangedInt("Enter a number", 1, 100);
        int expected = 69;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getInt() {
        String input = "420\n";
        Scanner scanner = new Scanner(input);
        SafeInputObj inputObj = new SafeInputObj(scanner);
        int actual = inputObj.getInt("Enter a number");
        int expected = 420;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getRangedDouble() {
        String input = "69.42\n";
        Scanner scanner = new Scanner(input);
        SafeInputObj inputObj = new SafeInputObj(scanner);
        double actual = inputObj.getRangedDouble("Enter a double", 1, 100);
        double expected = 69.42;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDouble() {
        String input = "420.69\n";
        Scanner scanner = new Scanner(input);
        SafeInputObj inputObj = new SafeInputObj(scanner);
        double actual = inputObj.getDouble("Enter a double");
        double expected = 420.69;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getYNConfirm() {
        String input = "Y";
        Scanner scanner = new Scanner(input);
        SafeInputObj inputObj = new SafeInputObj(scanner);
        boolean actual = inputObj.getYNConfirm("Do you like coding?");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getRegExString() {
        String input = "user@email.com";
        Scanner scanner = new Scanner(input);
        SafeInputObj inputObj = new SafeInputObj(scanner);
        String actual = inputObj.getRegExString("Enter your email", "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9+_.-]+$");
        String expected = "user@email.com";
        Assertions.assertEquals(expected, actual);
    }
}