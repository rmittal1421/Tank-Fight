package ca.cmpt213.fortress;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tank {
    private char nameOfTank;
    private int cellsRemaining;
    private boolean stateOfTank;
    private DesignBoard field;

    public Tank(DesignBoard field) {
        this.cellsRemaining = 0;

        // The state of tank is true if it is alive and is turned to false once it is shot by the user.
        this.stateOfTank = true;
        this.field = field;
    }

    public int getCellsRemaining() {
        return cellsRemaining;
    }

    public void setCellsRemaining(int cellsRemaining) {
        this.cellsRemaining = cellsRemaining;
    }

    public boolean getStateOfTank() {
        return stateOfTank;
    }

    public void setStateOfTank(boolean stateOfTank) {
        this.stateOfTank = stateOfTank;
    }

    public void placeItself(List<Cell> unusedCells) {
        List<Cell> freeNeighbours = new ArrayList<>();

        Random rand = new Random();
        int randCell = rand.nextInt(unusedCells.size());

        //while placing first cell.
        Cell inTank = unusedCells.get(randCell);
        fillFreeNeighbours (inTank, freeNeighbours);
        inTank.setOccupied(true);
    }

    private void fillFreeNeighbours(Cell inTank, List<Cell> freeNeighbours) {
        freeNeighbours.add(field.getCell(inTank.getRowNumber()-1, inTank.getColumnNumber());
    }
}
