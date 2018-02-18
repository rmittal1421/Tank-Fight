package ca.cmpt213.fortress;

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
