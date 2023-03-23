package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalInteraction {
    private static <T extends Enum<T>> void printIndexedEnum(T[] enumValues)
            throws IllegalArgumentException {
        if (enumValues.length < 1)
            throw new IllegalArgumentException("Enum should have at least one type.");
        int i = 1;
        for (T value : enumValues) {
            System.out.printf("\t%2d\t-\t%s\n", i, value.name());
            i++;
        }
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
     * Utility function to present a choice of options from an enum to the terminal.
     * @param message    Question to print to terminal.
     * @param enumValues Enum.values() of specified enum.
     * @param <T>        An enum with at least one type.
     * @return Selected enum option.
     * @throws IllegalArgumentException when enum has no types.
     * @implNote TODO: write alternate using reflection so that Enum can be passed instead of Enum.Values()
     */
    public static <T extends Enum<T>> T chooseFromEnum(String message, T[] enumValues) {
        System.out.println(message);
        printIndexedEnum(enumValues);
        int choice = chooseIntInRange(1, enumValues.length);
        return enumValues[choice - 1];
    }
}
