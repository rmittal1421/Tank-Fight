package ca.cmpt213.fortress;

import java.util.List;

public class Tank {
    private char nameOfTank;
    private int cellsRemaining;
    private boolean stateOfTank;
    public boolean placed;

    public Tank(DesignBoard field, char tankName, List<Cell> unusedCells) {
        this.nameOfTank = tankName;
        this.placed = true;

        // The state of tank is true if it is alive and is turned to false once it is shot by the user.
        this.stateOfTank = true;

        int tanksAlreadyPlaced = field.getNumberOfAliveTanks();
        new PlaceTank(field, unusedCells, nameOfTank);

        if (tanksAlreadyPlaced == field.getNumberOfAliveTanks()) {
            placed = false;
        }
        else {
            this.cellsRemaining = 4;
        }
    }

    public int getCellsRemaining() {
        return cellsRemaining;
    }

    public void decrementRemainingCells() {
        this.cellsRemaining--;

        if (this.cellsRemaining == 0) {
            this.stateOfTank = false;
        }
    }

    public boolean getStateOfTank() {
        return stateOfTank;
    }

    public void setStateOfTank(boolean stateOfTank) {
        this.stateOfTank = stateOfTank;
    }

    public int damageByTank () {
        final int damgageBy4 = 20;
        final int damgageBy3 = 5;
        final int damgageBy2 = 2;
        final int damgageBy1 = 1;
        final int damgageBy0 = 0;

        int noOfCells = getCellsRemaining();
        if (noOfCells == 4) {
            return damgageBy4;
        }
        else if (noOfCells == 3) {
            return damgageBy3;
        }
        else if (noOfCells == 2) {
            return damgageBy2;
        }
        else if (noOfCells == 1) {
            return damgageBy1;
        }
        else {
            return damgageBy0;
        }
    }
}
