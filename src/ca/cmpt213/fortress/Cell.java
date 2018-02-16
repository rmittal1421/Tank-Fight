package ca.cmpt213.fortress;

public class Cell {
    private char name;
    private boolean occupied;
    private int rowNumber;
    private int columnNumber;

    public Cell (int rowNumber, int columnNumber) {
        name = '~';

        // occupied is false if it is free and ready to accommodate a tank
        // occupied is true which means that the cell is occupied by a tank
        occupied = false;

        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

//    public Cell(char name, boolean occupied) {
//        this.name = name;
//        this.occupied = occupied;
//    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public boolean getOccupied() {
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
