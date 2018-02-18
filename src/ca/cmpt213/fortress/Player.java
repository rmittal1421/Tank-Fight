package ca.cmpt213.fortress;

public class Player {
    private int rows;
    private int columns;
    private int structuralIntegrity;
    private Point nextMove;
    public DesignBoard fortressMap;

    public Player(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        structuralIntegrity = 100;
        fortressMap = new DesignBoard(rows, columns, '~');
    }

    public int getStructuralIntegrity() {
        return structuralIntegrity;
    }
}
