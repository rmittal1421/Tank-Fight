package ca.cmpt213.fortress;

import java.util.Optional;

public class Cell {
    private char name;
    private boolean occupied;
    private Point locationOfCell;
    private int rowNumber;
    private int columnNumber;

    //Optional<Tank> inTank = Optional.empty();

    public Cell (int rowNumber, int columnNumber) {
        name = '~';

        // occupied is false if it is free and ready to accommodate a tank
        // occupied is true which means that the cell is occupied by a tank
        occupied = false;

        locationOfCell = new Point(rowNumber, columnNumber);

//        this.rowNumber = rowNumber;
//        this.columnNumber = columnNumber;
    }

    public Point getLocationOfCell() {
        return locationOfCell;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isEmpty() {
        return !occupied;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }
}
