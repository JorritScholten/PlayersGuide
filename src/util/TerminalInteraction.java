package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalInteraction {
    /**
     * Print numbered list of Enum.Values() to console.
     * @param enumValues Enum.values() of specified enum.
     * @param <T>        An enum with at least one type.
     * @throws IllegalArgumentException when enum has no types.
     */
    private static <T extends Enum<T>> void printIndexedEnum(T[] enumValues) throws IllegalArgumentException {
        if (enumValues.length < 1) throw new IllegalArgumentException("Enum should have at least one type.");
        int i = 1;
        for (T value : enumValues) {
            System.out.printf("\t%2d\t-\t%s\n", i, value.name());
            i++;
        }
    }

    /**
     * Utility function to ask for a character in the terminal.
     * @param prompt Question to print to terminal.
     * @return char value.
     */
    public static char askForChar(String prompt) {
        char choice;
        String scan_out;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                System.out.print(prompt);
                scan_out = scan.next();
                if (scan_out.length() > 1) {
                    System.out.println("Enter only one character please.");
                    continue;
                }
                choice = scan_out.charAt(0);
            } catch (InputMismatchException ex) {
                System.out.println("Invalid choice entered, please try again.");
                scan.next();
                continue;
            }
            return choice;
        } while (true);
    }

    /**
     * Utility function to ask for a string in the terminal.
     * @param prompt Question to print to terminal.
     * @return String value.
     */
    public static String askForString(String prompt) {
        String choice;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                System.out.print(prompt);
                choice = scan.nextLine();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid choice entered, please try again.");
                scan.next();
                continue;
            }
            return choice;
        } while (true);
    }

    /**
     * Utility function to ask for an int in the terminal.
     * @param prompt Question to print to terminal.
     * @return Chosen int value.
     */
    public static int askForInt(String prompt) {
        int choice = Integer.MIN_VALUE;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                System.out.print(prompt);
                choice = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid choice entered, please try again.");
                scan.next();
                continue;
            }
            return choice;
        } while (true);
    }

    /**
     * Utility function to ask for an int in range min to max in the terminal.
     * @param min Minimum value of returned int.
     * @param max Maximum value of returned int.
     * @return Chosen int value which is in range.
     */
    public static int chooseIntInRange(int min, int max) {
        int choice = Integer.MIN_VALUE;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                System.out.printf("Please choose by typing the relevant number (%d to %d):", min, max);
                choice = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid choice entered, please try again.");
                scan.next();
            }
        } while (choice < min || choice > max);
        return choice;
    }

    /**
     * Utility function to present a choice of options from a String array to the terminal.
     * @param prompt  Question to print to terminal.
     * @param options Array of strings describing the options.
     * @return index value of selected option.
     * @throws IllegalArgumentException when options array or prompt is empty.
     */
    public static int chooseFromArray(String prompt, String[] options) throws IllegalArgumentException {
        if (options.length == 0) throw new IllegalArgumentException("List of options shouldn't be empty.");
        if (prompt.isEmpty()) throw new IllegalArgumentException("message shouldn't be empty.");
        System.out.println(prompt);
        int i = 1;
        for (String option : options) {
            System.out.printf("\t%2d\t-\t%s\n", i, option);
            i++;
        }
        return chooseIntInRange(1, options.length) - 1;
    }

    /**
     * Utility function to present a choice of options from an enum to the terminal.
     * @param prompt     Question to print to terminal.
     * @param enumValues Enum.values() of specified enum.
     * @param <T>        An enum with at least one type.
     * @return Selected enum option.
     * @throws IllegalArgumentException when enum has no types or prompt is empty.
     * @implNote TODO: write alternate using reflection so that Enum can be passed instead of Enum.Values()
     */
    public static <T extends Enum<T>> T chooseFromEnum(String prompt, T[] enumValues) {
        if (prompt.isEmpty()) throw new IllegalArgumentException("message shouldn't be empty.");
        System.out.println(prompt);
        printIndexedEnum(enumValues);
        int choice = chooseIntInRange(1, enumValues.length);
        return enumValues[choice - 1];
    }
}
