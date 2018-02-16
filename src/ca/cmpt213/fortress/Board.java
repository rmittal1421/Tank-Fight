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

    public Board(int noOfRows, int noOfColumns, int numberOfTanks) {
        this.rows = noOfRows;
        this.columns = noOfColumns;
        this.numberOfTanks = numberOfTanks;
        field = new DesignBoard(rows, columns);
        this.numberOfAliveTanks = 0;
        this.numberOfUnusedCells = rows*columns;

        // Creating a list which contains all the cells which have not been assigned to any tank so far.
        List<Cell> unusedCells = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (field.getCell(i,j).getOccupied() == false) {
                    unusedCells.add(field.getCell(i,j));
                }
            }
        }

        for (int i = 0; i < numberOfTanks; i++) {
            placeTank (unusedCells);
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

    private void placeTank(List<Cell> unusedCells) {
        Tank tank = new Tank (field);
        tank.placeItself (unusedCells);
    }

    // This functions give out the Cell which is sitting at index (i,j) in the grid of the board.
    // The name is set to "get" because in the main function, this is the most obvious function call one can make.
    public Cell get (int rowNum, int colNum) {
        return field.getCell(rowNum, colNum);
    }
}
