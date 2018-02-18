package ca.cmpt213.ui;

import ca.cmpt213.fortress.*;

import java.util.Scanner;

class PlayGame {
    private int rows = 4;
    private int columns = 4;
    private int numberOfTanks;
    private Board board;

    Player user = new Player(rows, columns);

    public Board getBoard() {
        return board;
    }

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

