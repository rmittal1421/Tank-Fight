package ca.cmpt213.ui;

import ca.cmpt213.fortress.Point;
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
        final int whenColumnbelow10 = 2;
        final int whenColumnIs10 = 3;

        boolean validRow = false;
        boolean validColumn = false;

        int rowNumber = -1;
        int columnNumber = -1;

        System.out.print("Enter your move: ");
        String input = scan.nextLine();

        if (input.equals("quit")) {
            return new Point(rowNumber, columnNumber);
        }

        if (!(input.isEmpty())) {
            input = input.trim();

            if (!(input.isEmpty())) {
                char[] ch = input.toCharArray();

                if (ch.length <= maxInputLength) {
                    if ((ch[0] >= 'a') && (ch[0] <= 'j')) {
                        rowNumber = (int)(ch[0]) - 'a';
                        validRow = true;
                    }
                    else if ((ch[0] >= 'A') && (ch[0] <= 'J')) {
                        rowNumber = (int)(ch[0]) - 'A';
                        validRow = true;
                    }

                    if (ch.length == whenColumnbelow10) {
                        if ((ch[1] >= '1') && (ch[1] <= '9')) {
                            columnNumber = (int)(ch[1]) - '1';
                            validColumn = true;
                        }
                    }
                    else if (ch.length == whenColumnIs10) {
                        if ((ch[1] == '1') && (ch[2] == '0')) {
                            columnNumber = 9;
                            validColumn = true;
                        }
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
}
