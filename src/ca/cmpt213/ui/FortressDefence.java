package ca.cmpt213.ui;

//import ca.cmpt213.fortress.*;

public class FortressDefence {
    public static void main (String[] args) {

        int numberOfTanks;

        if (args.length == 0) {
            numberOfTanks = 5;
        }
        else {
            numberOfTanks  = Integer.parseInt(args[0]);
        }

        PlayGame game = new PlayGame(numberOfTanks);

        if (args.length == 2) {
            game.printBoard();
            game.printUserPower();
        }

        System.out.println("Starting game with " + numberOfTanks + " tanks.\n");
        System.out.println("*****************************************");
        System.out.println(" Welcome to the game of Fortress Defence");
        System.out.println("created by Akansha Vaish and Raghav Mittal");
        System.out.println("*****************************************\n\n");

        game.play();
    }
}
