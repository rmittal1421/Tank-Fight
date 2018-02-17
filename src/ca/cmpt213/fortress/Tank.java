package ca.cmpt213.fortress;

import java.util.List;

public class Tank {
    private char nameOfTank;
    private int cellsRemaining;
    private boolean stateOfTank;
    public boolean placed;

    public Tank(DesignBoard field, char tankName, List<Cell> unusedCells) {
        this.nameOfTank = tankName;
        this.cellsRemaining = 0;
        this.placed = true;

        // The state of tank is true if it is alive and is turned to false once it is shot by the user.
        this.stateOfTank = true;

        int tanksAlreadyPlaced = field.getNumberOfAliveTanks();
        new PlaceTank(field, unusedCells, nameOfTank);

        if (tanksAlreadyPlaced == field.getNumberOfAliveTanks()) {
            placed = false;
        }
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
}
