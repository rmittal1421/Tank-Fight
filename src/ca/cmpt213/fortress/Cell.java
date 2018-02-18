package ca.cmpt213.fortress;

/**
 * Cell class is the type defination of the what the board is made up of.
 * Every index of board has a cell which basically contains the name of the cell which tells that what is in that cell
 * If there is a tank there, it stores the name of that tank
 * If it is fog there, it stores the sign of fog
 * If it has been hit, it contains a sign of X which means there was a tank here and it has been hit
 * If there is nothing there, then it contains an empty space as it's name.
 * This class also knows whether or not this cell has been occupied by a tank or not.
 * @author rmittal
 */
public class Cell {
    private char name;
    private boolean occupied;
    private Point locationOfCell;

    public Cell (int rowNumber, int columnNumber, char nameOfCell) {
        this.name = nameOfCell;

        // occupied is false if it is free and ready to accommodate a tank
        // occupied is true which means that the cell is occupied by a tank
        occupied = false;

        locationOfCell = new Point(rowNumber, columnNumber);
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
}
