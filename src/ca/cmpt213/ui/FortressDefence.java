package ca.cmpt213.ui;

/**
 * Fortress Defence class contains the main class which takes the arguments from the user and
 * designs and play the game accordingly.
 * @param array of strings
 * @author vakansha
 */
public class FortressDefence {
    public static void main (String[] args) {

        int numberOfTanks = 0;

        if (args.length == 0) {
            numberOfTanks = 5;
        }
        else if (args.length >= 3) {
            System.out.println("Too many arguments. Please enter 0, 1 or 2 arguments.");
            System.exit(-1);
        }
        else {
            numberOfTanks = Integer.parseInt(args[0]);
            if (numberOfTanks < 0) {
                System.out.println("Unable to place -ve number of tanks.");
                System.out.println("Replay with +ve number of tanks.");
                System.exit(-1);
            }
        }

        PlayGame game = new PlayGame(numberOfTanks);

        if (args.length == 2) {
            System.out.println();
            game.printGameBoard(game.getBoard().getField());
            game.printUserPower();
        }

        System.out.println("\n");
        System.out.println("Starting game with " + numberOfTanks + " tanks.\n");
        System.out.println("*****************************************");
        System.out.println(" Welcome to the game of Fortress Defence");
        System.out.println("created by Akansha Vaish and Raghav Mittal");
        System.out.println("*****************************************\n\n");

        game.play();
    }
}
