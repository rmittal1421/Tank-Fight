package ca.cmpt213.ui;

import ca.cmpt213.fortress.Board;
import ca.cmpt213.fortress.Player;
import ca.cmpt213.fortress.Point;
import ca.cmpt213.fortress.ShotAnalyzer;

import java.util.Scanner;

class PlayGame {
    private int rows = 4;
    private int columns = 4;
    private int numberOfTanks;
    private Board board;
    Player user = new Player(rows, columns);

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
            printUserBoard();
            printUserPower();

            target = (new InputFromUser(scan)).getTarget();
            ShotAnalyzer shot = new ShotAnalyzer(board, target);
            boolean result = shot.result();
            if (result) {
                System.out.println("Hit");
                shot.makeChangesInGame(user, result);
            }
            else {
                System.out.println("Miss");
            }
            shot.makeChangesInUser(user, result);
            //break;
       }

       if (board.getNumberOfAliveTanks() == 0) {
           printUserBoard();
           printUserPower();
           System.out.println("Congratulations! You won!\n");
           printBoard();
           printUserPower();
           System.out.println("(Lower case tank letters are where you shot.)");
       }
       else if (user.getStructuralIntegrity() == 0){
           printUserBoard();
           printUserPower();
           System.out.println("I am sorry, your fortress has been smashed!\n");
           printBoard();
           printUserPower();
           System.out.println("(Lower case tank letters are where you shot.)");
       }
    }



    public void printBoard () {
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
                System.out.print(board.get(i,j).getName() + "\t");
            }
            System.out.println();
        }
    }

    public void printUserBoard () {
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
                System.out.print(user.fortressMap.getCell(p).getName() + "\t");
            }
            System.out.println();
        }
    }

    public void printUserPower() {
        System.out.println("Fortress Structure left: " + user.getStructuralIntegrity());
    }
}

