package ca.cmpt213.fortress;

/**
 * Shot Analyzer class analyzes the shot which has been made by the user and make the required changes to the game
 * This class also tells the outcome of the shot and displays HIT if the shot is successful
 * and MISS if the shot is unsuccessful
 * @author rmittal
 */
public class ShotAnalyzer {
    public static final int differenceInCaps = 32;
    Point shotPoint;
    Cell attackedCell;
    Board board;

    public ShotAnalyzer(Board board, Point target) {
        shotPoint = target;
        attackedCell = board.get(target);
        this.board = board;
    }

    public boolean result() {
        //This function returns true if it is a hit
        //And returns if it is a miss
        return !attackedCell.isEmpty();
    }

    /**
     * Takes in the user object and result of the shot and makes required changes in the structure of the game
     * such as changing the amount of damage one tank can make if it hits or if it misses
     * such as changing the name of the cells depending on the shot etc..
     * @param user
     * @param result
     */
    public void makeChangesInGame (Player user, boolean result) {
        if (result) {
            //first change the name of the cell which has been shot
            if (!(user.fortressMap.getCell(shotPoint).getName() == 'X')) {
                char currentName = attackedCell.getName();
                int tankIndex = (int)(currentName) - 'A';
                currentName += differenceInCaps;
                attackedCell.setName(currentName);

                int aliveTanks = board.getNumberOfAliveTanks();

                board.getListOfTanks().get(tankIndex).decrementRemainingCells();
                int updatedAliveTanks = board.updateAliveTank();

                if (aliveTanks != updatedAliveTanks) {
                    board.setNumberOfAliveTanks(board.getNumberOfAliveTanks() - 1);
                }
            }
        }
        else {
            attackedCell.setName(' ');
        }
    }
}
