package ca.cmpt213.ui;

import ca.cmpt213.model.Point;
import java.util.Scanner;

/**
 * InputFromUser class is specially designed to take the inputs from the user which is used to generate the
 * point where the user wants to shoot. It uses a scanner class and has a function called askTarget(Scanner)
 * which returns the point where the user is aiming at.
 * @author vakansha, rmittal
 */
public class InputFromUser {
    private Point target;

    public InputFromUser(Scanner scan) {
        target = askTarget(scan);
    }

    public Point getTarget() {
        return target;
    }

    /**
     * askTarget is asking the user to enter the location where he wants to hit
     * If the user enters an invalid position, this function is dealing with that too.
     * Since, the user enters the location as a string, this function reads the rowNo and colNo
     * and create a Point object and returns it.
     * @param scan
     * @return
     */
    public Point askTarget(Scanner scan) {
        final int maxInputLength = 3;
        final int minimumInputLength = 2;
        final int maximumInputLength = 3;
        final int maximumColumnNo = 9;

        boolean validRow = false;
        boolean validColumn = false;

        int rowNumber = -1;
        int columnNumber = -1;

        System.out.print("Enter your move: ");
        String input = scan.nextLine();

        if (!(input.isEmpty())) {
            input = input.trim();
            input = input.toLowerCase();
        }

        if (!(input.isEmpty())) {
            char[] charsInInput = input.toCharArray();

            if (charsInInput.length <= maxInputLength) {
                if (checkRowNumber(charsInInput[0])) {
                    rowNumber = mapToInt(charsInInput[0], 'a');
                    validRow = true;
                }

                if (charsInInput.length == minimumInputLength) {
                    if (checkColumnNumber (charsInInput[1]) ) {
                        columnNumber = mapToInt(charsInInput[1], '1');
                        validColumn = true;
                    }
                }
                else if (charsInInput.length == maximumInputLength) {
                    if ((charsInInput[1] == '1') && (charsInInput[2] == '0')) {
                        columnNumber = maximumColumnNo;
                        validColumn = true;
                    }
                }
            }
        }

        if (validRow && validColumn) {
            Point target = new Point (rowNumber, columnNumber);
            return target;
        }
        else {
            System.out.println("Invalid target. Please enter a coordinate such as D10.");
            return askTarget(scan);
        }
    }

    public int mapToInt(char charInInput, char lowerBound) {
        return ((int)charInInput - lowerBound);
    }

    public boolean checkRowNumber(char charInInput) {
        return ((charInInput >= 'a') && (charInInput <= 'j'));
    }

    public boolean checkColumnNumber(char charInInput) {
        return ((charInInput >= '1') && (charInInput <= '9'));
    }
}
