package ca.cmpt213.fortress;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int rows;
    private int columns;
    private DesignBoard field;
    private int numberOfTanks;
    private int numberOfAliveTanks;
    private int numberOfUnusedCells;
    public boolean ableToMakeBoard;

    public Board (int noOfRows, int noOfColumns, int numberOfTanks) {
        this.rows = noOfRows;
        this.columns = noOfColumns;
        this.numberOfTanks = numberOfTanks;
        this.field = new DesignBoard(noOfRows, noOfColumns);
        this.numberOfAliveTanks = 0;
        this.numberOfUnusedCells = rows * columns;
        this.ableToMakeBoard = true;

        // Creating a list which contains all the cells which have not been assigned to any tank so far.
        List<Cell> unusedCells = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Point point = new Point(i,j);
                unusedCells.add(field.getCell(point));
            }
        }

        char tankName = 'A';
        for (int i = 0; i < numberOfTanks; i++) {
            if (ableToMakeBoard == true) {
                placeTank (unusedCells, tankName);
                tankName++;
            }
            else {
                break;
            }
        }
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {

        return rows;
    }

    public int getNumberOfUnusedCells() {
        return numberOfUnusedCells;
    }

    private void placeTank (List<Cell> unusedCells, char tankName) {
        Tank tank = new Tank (field, tankName);
        if (!(tank.placeItself (unusedCells))) {
            ableToMakeBoard = false;
        }
    }

    // This functions give out the Cell which is sitting at index (i,j) in the grid of the board.
    // The name is set to "get" because in the main function, this is the most obvious function call one can make.
    public Cell get (int rowNum, int colNum) {
        return field.getCell(new Point(rowNum, colNum));
    }
}
