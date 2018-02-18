package ca.cmpt213.ui;

import ca.cmpt213.fortress.Board;
import ca.cmpt213.fortress.Player;
import ca.cmpt213.fortress.Point;
import ca.cmpt213.fortress.ShotAnalyzer;

import java.util.Scanner;

class PlayGame {
    private int rows = 10;
    private int columns = 10;
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

       // while (user.getStructuralIntegrity() > 100) {
            target = (new InputFromUser(scan)).getTarget();
            ShotAnalyzer shot = new ShotAnalyzer(board, target);
            if (shot.result()) {
                System.out.println("HIT");
            }
            else {
                System.out.println("MISS");
            }
            //break;
       // }

        System.out.println(target.getRowNo() + "," + target.getColNo());

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

    public void printUserPower() {
        System.out.println("Fortress Structure left: " + user.getStructuralIntegrity());
    }
}

