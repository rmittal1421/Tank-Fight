package ca.cmpt213.fortress;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tank {
    public static final int minimumCellsForTank = 4;
    private char nameOfTank;
    private int cellsRemaining;
    private boolean stateOfTank;
    private DesignBoard field;
    private List<Point> pointsOfTank = new ArrayList<>();

    public Tank(DesignBoard field, char tankName) {
        this.nameOfTank = tankName;
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
        int cellsInTank = 0;
        int randCell;
        Cell inTank;

        Random rand = new Random();

        do {
            randCell = rand.nextInt(unusedCells.size()-1);
            inTank = unusedCells.get(randCell);
            cellsInTank++;
            inTank.setOccupied(true);
            pointsOfTank.add(inTank.getLocationOfCell());
            fillFreeNeighbours (inTank, freeNeighbours);

            if (freeNeighbours.size() == 0) {
                //I didn't find any neighbour which is free which means I cannot use this particular cell for my tank
                //because it has no neighbour with whom I can connect.
                //Hence I will remove it from the list which contains all the cells which are unused because I cant use it.
                cellsInTank--;
                inTank.setOccupied(false);
            }
            unusedCells.remove(randCell);

        } while((cellsInTank == 0) && !(unusedCells.size() < minimumCellsForTank));

        while (cellsInTank != 4) {
            randCell = rand.nextInt(freeNeighbours.size()-1);
            inTank = freeNeighbours.get(randCell);
            unusedCells.remove(inTank);
            freeNeighbours.remove(inTank);
            inTank.setOccupied(true);
            cellsInTank++;
            pointsOfTank.add(inTank.getLocationOfCell());
            fillFreeNeighbours(inTank, freeNeighbours);
        }

        if (cellsInTank == 4) {
            for (Point point : pointsOfTank) {
                System.out.println(this.nameOfTank + " " + point.getRowNo() + "," + point.getColNo());
                field.getCell(point).setName(this.nameOfTank);
            }
        }

//        inTank.setOccupied(true);
//        inTank.setName(tankName);
    }

    private void fillFreeNeighbours(Cell inTank, List<Cell> freeNeighbours) {
        Point currentPoint = inTank.getLocationOfCell();
        Point leftPoint = new Point(currentPoint.getRowNo(), currentPoint.getColNo()-1);
        Point rightPoint = new Point(currentPoint.getRowNo(), currentPoint.getColNo()+1);
        Point abovePoint = new Point(currentPoint.getRowNo()-1, currentPoint.getColNo());
        Point belowPoint = new Point(currentPoint.getRowNo()+1, currentPoint.getColNo());

        //Cases: I have to deal with all the cases where atRow or atColumn are going out of bound of the board,
        //Case1: where the left cell is going out-of-bound
        //Case2: where the right cell is going out-of-bound
        //Case3: where the above cell is going out-of-bound
        //Case4: where the below cell is going out-of-bound

        int lastIndex = freeNeighbours.size();

        if (field.locationExists(leftPoint)) {
            freeNeighbours.add(field.getCell(leftPoint));
        }
        if (field.locationExists(rightPoint)) {
            freeNeighbours.add(field.getCell(rightPoint));
        }
        if (field.locationExists(abovePoint)) {
            freeNeighbours.add(field.getCell(abovePoint));
        }
        if (field.locationExists(belowPoint)) {
            freeNeighbours.add(field.getCell(belowPoint));
        }

        for (int i = lastIndex; i < freeNeighbours.size(); i++) {
            if (freeNeighbours.get(i).isOccupied()) {
                freeNeighbours.remove(i);
            }
        }
    }
}
