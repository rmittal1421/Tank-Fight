package ca.cmpt213.model;

/**
 * Point is as simple as it's name. It is created to store vertices of a cell on a gameModel
 * Every cell is addressed with the help of this class.
 * @author rmittal
 */
public class Point {
    private int rowNo;
    private int colNo;

    public Point(int rowNo, int colNo) {
        this.rowNo = rowNo;
        this.colNo = colNo;
    }

    public int getRowNo() {
        return rowNo;
    }

    public int getColNo() {
        return colNo;
    }
}
