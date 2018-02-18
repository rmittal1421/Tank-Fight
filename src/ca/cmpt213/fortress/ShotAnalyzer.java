package ca.cmpt213.fortress;

public class ShotAnalyzer {
    public static final int differenceInCaps = 32;
    Point shotPoint;
    Cell attackedCell;
    Board board;

    public ShotAnalyzer(Board board, Point target) {
        shotPoint = target;
        attackedCell = board.get(target);
        this.board = board;
    }

    public boolean result() {
        //This function returns true if it is a hit
        //And returns if it is a miss
        return !attackedCell.isEmpty();
    }

    public void displayDamage () {
        int i = 0;
        for (Tank tank : board.getListOfTanks()) {
            if (tank.getStateOfTank()) {
                String output = "Alive tank #" + (i+1) + " of " + board.getListOfTanks().size() +
                        " shot you for "+ tank.damageByTank() + "!";
                System.out.println(output);
                i++;
            }
        }
    }

    public void makeChangesInGame (Player user, boolean result) {
        if (result) {
            //first change the name of the cell which has been shot
            if (!(user.fortressMap.getCell(shotPoint).getName() == 'X')) {
                char currentName = attackedCell.getName();
                int tankIndex = (int)(currentName) - 'A';
                currentName += differenceInCaps;
                attackedCell.setName(currentName);

                int aliveTanks = board.getNumberOfAliveTanks();

                board.getListOfTanks().get(tankIndex).decrementRemainingCells();
                int updatedAliveTanks = board.updateAliveTank();

                if (aliveTanks != updatedAliveTanks) {
                    board.setNumberOfAliveTanks(board.getNumberOfAliveTanks() - 1);
                }
            }
        }
        else {
            attackedCell.setName(' ');
        }
    }

    public void makeChangesInUser(Player user, boolean result) {

        if (result) {
            user.fortressMap.getCell(shotPoint).setName('X');
        }
        else {
            user.fortressMap.getCell(shotPoint).setName(' ');
        }

        int damage = 0;
        for (Tank tank : board.getListOfTanks()) {
            damage += tank.damageByTank();
        }

        user.setStructuralIntegrity(user.getStructuralIntegrity() - damage);
        if (user.getStructuralIntegrity() < 0) {
            user.setStructuralIntegrity(0);
        }
        displayDamage();
    }
}
