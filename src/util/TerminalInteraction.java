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

        Scanner scan = new Scanner(System.in);
        int choice = -1;
        do {
            try {
                System.out.println("Please choose by typing the relevant number:");
                choice = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid choice entered, please try again.");
                scan.next();
            }
        } while (choice < 1 || choice > enumValues.length);

        return enumValues[choice - 1];
    }
}
