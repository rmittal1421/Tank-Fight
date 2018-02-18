package ca.cmpt213.ui;

import ca.cmpt213.fortress.*;
import java.util.Scanner;

/**
 * PlayGame is the class where the actual game is played.
 * It's object is instantiated in FortressDefence class and the rest is done inside this class.
 * It makes use of InputFromUser class and ca.cmpt213.fortress package which basically has the
 * design of the game.
 * @author rmittal, vakansha
 */
class PlayGame {
    private int rows = 10;
    private int columns = 10;
    private int numberOfTanks;
    private Board board;

    Player user = new Player(rows, columns);

    public Board getBoard() {
        return board;
    }

    /**
     * This is the constructor of this class which takes an argument which is the number of tanks to be placed on the
     * board.
     * This creates a new board, adds the possible number of tanks.
     * Continues the game if all the tanks are placed.
     * And exists the system if it is unable to put all the tanks.
     * @param numberOfTanks
     */
    public PlayGame(int numberOfTanks) {
        this.numberOfTanks = numberOfTanks;
        board = new Board(rows, columns, numberOfTanks);

        if (!board.ableToMakeBoard) {
            System.out.println("Unable to place " + numberOfTanks + " tanks on the board");
            System.out.println("Try running game again with fewer tanks");
            System.out.println();
            System.exit(-1);
        }
    }

    /**
     * play is a member function of this class which starts the game if all the tanks are placed.
     * This function make use of an object of InputFromUser class.
     * It prints out everything to be dispayed while the game goes on.
     * This function interacs with the game interface.
     */
    public void play () {
        Scanner scan = new Scanner(System.in);
        Point target;

       while (user.getStructuralIntegrity() > 0 && board.getNumberOfAliveTanks() > 0) {
           printGameBoard(user.fortressMap);
            printUserPower();

            target = (new InputFromUser(scan)).getTarget();
            user.play (board, target);

            if (user.outcomeOfShot) {
                System.out.println("Hit");
            }
            else {
                System.out.println("Miss");
            }
            displayDamage(board);
       }

        printGameBoard(user.fortressMap);
        printUserPower();

       if (board.getNumberOfAliveTanks() == 0) {
           System.out.println("Congratulations! You won!\n");
       }
       else if (user.getStructuralIntegrity() == 0){
           System.out.println("I am sorry, your fortress has been smashed!\n");
       }

        printGameBoard(board.getField());
        printUserPower();
        System.out.println("(Lower case tank letters are where you shot.)");
    }

    public void displayDamage (Board board) {
        int i = 0;
        for (Tank tank : board.getListOfTanks()) {
            if (tank.getStateOfTank()) {
                String output = "Alive tank #" + (i+1) + " of " + board.getListOfTanks().size() +
                        " shot you for "+ tank.damageByTank() + "!";
                System.out.println(output);
                i++;
            }
        }
    }

    public void printGameBoard (DesignBoard field) {
        System.out.println("Game Board:");
        System.out.print("\t");
        for (int i = 1; i <= columns; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        char row = 'A';
        for (int i = 0; i < rows; i++) {
            System.out.print(row + "\t");
            row++;
            for (int j = 0; j < columns; j++) {
                Point p = new Point(i,j);
                System.out.print(field.getCell(p).getName() + "\t");
            }
            System.out.println();
        }
    }

    public void printUserPower() {
        System.out.println("Fortress Structure left: " + user.getStructuralIntegrity());
    }
}

