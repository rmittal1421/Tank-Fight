package ca.cmpt213.fortress;

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

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public int getColNo() {
        return colNo;
    }

    public void setColNo(int colNo) {
        this.colNo = colNo;
    }
}
