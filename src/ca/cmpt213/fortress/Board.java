package ca.cmpt213.fortress;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int rows;
    private int columns;
    private DesignBoard field;
    private int numberOfTanks;
    private int numberOfAliveTanks;
    private int numberOfUnusedCells;
    public boolean ableToMakeBoard;
    List<Tank> listOfTanks = new ArrayList<>();

    public Board (int noOfRows, int noOfColumns, int numberOfTanks) {
        this.rows = noOfRows;
        this.columns = noOfColumns;
        this.numberOfTanks = numberOfTanks;
        this.field = new DesignBoard(noOfRows, noOfColumns, '.');
        this.numberOfAliveTanks = 0;
        this.numberOfUnusedCells = rows * columns;
        this.ableToMakeBoard = true;

        // Creating a list which contains all the cells which have not been assigned to any tank so far.
        List<Cell> unusedCells = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Point point = new Point(i,j);
                unusedCells.add(field.getCell(point));
            }
        }

        char tankName = 'A';
        for (int i = 0; i < numberOfTanks; i++) {
            if (ableToMakeBoard == true) {
                addTank(unusedCells, tankName);
                tankName++;
            }
            else {
                break;
            }
        }

        this.numberOfAliveTanks = this.field.getNumberOfAliveTanks();
    }

    public int getNumberOfUnusedCells() {
        return numberOfUnusedCells;
    }

    public List<Tank> getListOfTanks() {
        return listOfTanks;
    }

    public void setNumberOfAliveTanks(int numberOfAliveTanks) {
        this.numberOfAliveTanks = numberOfAliveTanks;
    }

    public int getNumberOfAliveTanks() {

        return numberOfAliveTanks;
    }

    private void addTank(List<Cell> unusedCells, char tankName) {
        Tank tank = new Tank (field, tankName, unusedCells);
        if (tank.placed == false) {
            ableToMakeBoard = false;
        }
        else {
            listOfTanks.add(tank);


        }
    }

    // This functions give out the Cell which is sitting at index (i,j) in the grid of the board.
    // The name is set to "get" because in the main function, this is the most obvious function call one can make.
    public Cell get (int rowNum, int colNum) {
        return field.getCell(new Point(rowNum, colNum));
    }

    public Cell get (Point point) {
        return field.getCell(point);
    }

    public DesignBoard getField() {
        return field;
    }

    public int updateAliveTank() {
        int aliveTanks = listOfTanks.size();
        for (Tank tank : listOfTanks) {
            if (tank.getStateOfTank() == false) {
                aliveTanks--;
            }
        }
        return aliveTanks;

    }
}
