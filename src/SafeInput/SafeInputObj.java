package SafeInput;

import java.util.Scanner;

public class SafeInputObj {

    private Scanner pipe;

    /**
     * Default constructor. Initializes the Scanner to read from System.in.
     */

    public SafeInputObj() {
            this.pipe = new Scanner(System.in);
    }

    /**
     * Parameterized constructor. Uses the provided Scanner instance.
     *
     * @param scanner a Scanner instance for user input
     */

    public SafeInputObj(Scanner scanner) {
            this.pipe = scanner;
    }

    /**
     * Prompts the user to input a non-empty string.
     *
     * @param prompt the message to display to the user
     * @return a string entered by the user that is not empty
     */

    public String getNonZeroLenString(String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0); // until we have some characters

        return retString;

    }

    /**
     * Prompts the user to input an integer within a specified range.
     *
     * @param prompt the message to display to the user
     * @param low the minimum acceptable value (inclusive)
     * @param high the maximum acceptable value (inclusive)
     * @return an integer entered by the user within the range
     */

    public int getRangedInt(String prompt, int low, int high)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        }while(!done);

        return retVal;
    }

    /**
     * Prompts the user to input any integer.
     *
     * @param prompt the message to display to the user
     * @return an integer entered by the user
     */

    public int getInt(String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        }while(!done);

        return retVal;
    }

    /**
     * Prompts the user to input a double value within a specified range.
     *
     * @param prompt the message to display to the user
     * @param low the minimum acceptable value (inclusive)
     * @param high the maximum acceptable value (inclusive)
     * @return a double value entered by the user within the range
     */

    public double getRangedDouble(String prompt, int low, int high)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        }while(!done);

        return retVal;
    }

    /**
     * Prompts the user to input any double value.
     *
     * @param prompt the message to display to the user
     * @return a double value entered by the user
     */

    public double getDouble(String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        }while(!done);

        return retVal;
    }

    /**
     * Prompts the user for a yes or no confirmation.
     *
     * @param prompt the message to display to the user
     * @return true if the user enters "Y" (case-insensitive), false if "N"
     */

    public boolean getYNConfirm(String prompt)
    {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                gotAVal = true;
                retVal = true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                gotAVal = true;
                retVal = false;
            }
            else
            {
                System.out.println("You must answer [Y/N]! " + response );
            }

        }while(!gotAVal);

        return retVal;
    }

    /**
     * Prompts the user for a string that matches a specified regular expression.
     *
     * @param prompt the message to display to the user
     * @param regExPattern the regular expression pattern the input must match
     * @return a string that matches the specified regular expression
     */

    public String getRegExString(String prompt, String regExPattern)
    {
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if(response.matches(regExPattern))
            {
                gotAVal = true;
            }
            else
            {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);
                System.out.println("Try again!");
            }

        }while(!gotAVal);

        return response;
    }



}
