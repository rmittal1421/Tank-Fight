package ca.cmpt213.fortress;

/**
 * DesignBoard is the helping class which helps in building the board or given number of rows and columns.
 * It makes a 2-D array of Cells and do nothing with that.
 * This class is simply designed to design the board which is the basic requirement of this game.
 * @author vakansha
 */
public class DesignBoard {
    private int rows;
    private int columns;
    private Cell[][] newBoard;
    private int numberOfAliveTanks;


    public DesignBoard(int rows, int columns, char nameOfEachCell) {
        this.rows = rows;
        this.columns = columns;
        this.numberOfAliveTanks = 0;

        newBoard = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newBoard[i][j] = new Cell(i,j, nameOfEachCell);
            }
        }
    }

    public int getNumberOfAliveTanks() {
        return numberOfAliveTanks;
    }

    public void incrementNoOfAliveTank() {
        this.numberOfAliveTanks++;

    }

    public Cell getCell(Point p) {
        return newBoard[p.getRowNo()][p.getColNo()];
    }

    public boolean locationExists (Point point) {
        boolean toReturn = false;
        int atRow = point.getRowNo();
        int atCol = point.getColNo();
        if ((atRow >= 0) && (atRow < rows) && (atCol >= 0) && (atCol < columns)) {
            toReturn = true;
        }
        return toReturn;
    }
}
