package ca.cmpt213.fortress;

public class ShotAnalyzer {
    Cell attackedCell;

    public ShotAnalyzer(Board board, Point target) {
        attackedCell = board.get(target);
    }

    public boolean result() {
        //This function returns true if it is a hit
        //And returns if it is a miss
        return !attackedCell.isEmpty();
    }
}
