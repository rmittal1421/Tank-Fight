package ca.cmpt213.fortress;

public class DesignBoard {
    private int rows;
    private int columns;
    private Cell[][] newBoard;

    public DesignBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        newBoard = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newBoard[i][j] = new Cell(i,j);
            }
        }
    }

    public Cell getCell(int rowNum, int colNum) {
        return newBoard[rowNum][colNum];
    }
}
