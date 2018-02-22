package ca.cmpt213.model;

/**
 * GameModel class is the backbone of this game.
 * It contains the actual gameModel and the actual designed GameModel which actually contains all the tanks.
 * This class has the responsibility of checking whether or not we were able to place all the tanks on the gameModel
 * It contains the list of the tanks that have been placed on the gameModel.
 * Most of the work has been done in the constructor of this class since we have to put all the tanks on the gameModel
 * as soon as we are asked to start the game.
 * @author rmittal
 */

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private Board field;
    private List<Tank> listOfTanks = new ArrayList<>();

    public boolean ableToMakeBoard;

    public GameModel(int noOfRows, int noOfColumns, int numberOfTanks) {
        this.field = new Board(noOfRows, noOfColumns, '.');
        this.ableToMakeBoard = true;

        // Creating a list which contains all the cells which have not been assigned to any tank so far.
        List<Cell> unusedCells = new ArrayList<>();
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                unusedCells.add(field.getCell(new Point (i,j)));
            }
        }

        char tankName = 'A';
        for (int i = 0; i < numberOfTanks; i++) {
            if (ableToMakeBoard) {
                addTank(unusedCells, tankName);
                tankName++;
            }
            else {
                break;
            }
        }
    }

    public List<Tank> getListOfTanks() {
        return listOfTanks;
    }

    public int getNumberOfAliveTanks() {
        return field.getNumberOfAliveTanks();
    }

    private void addTank(List<Cell> unusedCells, char tankName) {
        Tank tank = new Tank (field, tankName, unusedCells);
        if (!tank.placed) {
            ableToMakeBoard = false;
        }
        else {
            listOfTanks.add(tank);
        }
    }

    // This functions give out the Cell which is sitting at index (i,j) in the grid of the gameModel.
    // The name is set to "get" because in the main function, this is the most obvious function call one can make.
    public Cell get (Point point) {
        return field.getCell(point);
    }

    public Board getField() {
        return field;
    }

    public int updateAliveTank() {
        int aliveTanks = listOfTanks.size();
        for (Tank tank : listOfTanks) {
            if (!tank.getStateOfTank()) {
                aliveTanks--;
            }
        }
        return aliveTanks;
    }
}
