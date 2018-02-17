package ca.cmpt213.fortress;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tank {
    public static final int minimumCellsForTank = 4;
    public static final int completeTank = 4;
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
        int randCellIndex;
        Cell inTank;

        Random rand = new Random();

        do {
            randCellIndex = rand.nextInt(unusedCells.size()-1);
            inTank = unusedCells.get(randCellIndex);
            unusedCells.remove(randCellIndex);
            cellsInTank++;
            inTank.setOccupied(true);
            pointsOfTank.add(inTank.getLocationOfCell());
            fillFreeNeighbours (inTank, freeNeighbours);

            if (freeNeighbours.size() == 0) {
                //I didn't find any neighbour which is free which means I cannot use this particular cell for my tank
                //because it has no neighbour with whom I can connect.
                //Hence I will remove it from the list which contains all the cells which are unused because I cant use it.
                cellsInTank--;
                pointsOfTank.remove(inTank.getLocationOfCell());
                inTank.setOccupied(false);
            }
        } while((cellsInTank == 0) && !(unusedCells.size() < minimumCellsForTank));

//        if ((cellsInTank == 0) && (unusedCells.size() < minimumCellsForTank)) {
//            exitTheProgram();
//        }

        while (cellsInTank != 4 && (freeNeighbours.size() != 0)) {
            randCellIndex = rand.nextInt(freeNeighbours.size());
            inTank = freeNeighbours.get(randCellIndex);
            unusedCells.remove(inTank);
            freeNeighbours.remove(inTank);
            inTank.setOccupied(true);
            cellsInTank++;
            pointsOfTank.add(inTank.getLocationOfCell());
            fillFreeNeighbours(inTank, freeNeighbours);
        }

        if (cellsInTank == completeTank) {
            for (Point point : pointsOfTank) {
                //System.out.println(this.nameOfTank + " " + (point.getRowNo()+1) + "," + (point.getColNo()+1));
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

        if (field.locationExists(leftPoint)) {
            if (field.getCell(leftPoint).isEmpty()) {
                freeNeighbours.add(field.getCell(leftPoint));
            }
        }
        if (field.locationExists(rightPoint)) {
            if (field.getCell(rightPoint).isEmpty()) {
                freeNeighbours.add(field.getCell(rightPoint));
            }
        }
        if (field.locationExists(abovePoint)) {
            if (field.getCell(abovePoint).isEmpty()) {
                freeNeighbours.add(field.getCell(abovePoint));
            }
        }
        if (field.locationExists(belowPoint)) {
            if (field.getCell(belowPoint).isEmpty()) {
                freeNeighbours.add(field.getCell(belowPoint));
            }
        }
    }
}
