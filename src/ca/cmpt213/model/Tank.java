package ca.cmpt213.model;

import java.util.List;

/**
 * Tank class makes an object which is actually a tank which is to be placed on the gameModel
 * This class's constructor assigns the name of the tank and contains a boolean placed which tells that
 * whether or not this tank has been placed.
 * @author vakansha
 */
public class Tank {
    private char nameOfTank;
    private int cellsRemaining;
    private boolean stateOfTank;
    public boolean placed;

    public Tank(Board field, char tankName, List<Cell> unusedCells) {
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

    /**
     * damageByTank function explicitly returns the amount of damage a tank can do when it is alive or dead
     * Since it contains a member variable CellsRemaining,
     * it knows if it is alive or not and does the damage accordingly
     *
     * If the number of cells remamining:   Damage caused by that tank:
     * 0                                :   0
     * 1                                :   1
     * 2                                :   2
     * 3                                :   5
     * 4                                :   20
     * @return
     */
    public int damageByTank () {
        final int damageBy4 = 20;
        final int damageBy3 = 5;
        final int damageBy2 = 2;
        final int damageBy1 = 1;
        final int damageBy0 = 0;

        int noOfCells = getCellsRemaining();
        if (noOfCells == 4) {
            return damageBy4;
        }
        else if (noOfCells == 3) {
            return damageBy3;
        }
        else if (noOfCells == 2) {
            return damageBy2;
        }
        else if (noOfCells == 1) {
            return damageBy1;
        }
        else {
            return damageBy0;
        }
    }
}
