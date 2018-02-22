package ca.cmpt213.model;

/**
 * Player class is the user who is defending his model from the enemy attack.
 * This class takes the cell to be hit on the baord from PlayGame class and
 * updates the game accordingly
 * It also stores all the information which a user should have like his own model map,
 * his structural integrity etc..
 * @author vakansha
 */
public class Player {
    public static final int minimumStructuralIntegrity = 0;
    private int structuralIntegrity;
    public boolean outcomeOfShot;
    public Board fortressMap;

    public int getStructuralIntegrity() {
        return structuralIntegrity;
    }

    public Player(int rows, int columns) {
        structuralIntegrity = 1500;
        fortressMap = new Board(rows, columns, '~');
    }


    public void play (GameModel gameModel, Point target) {
        ShotAnalyzer shot = new ShotAnalyzer(gameModel, target);
        this.outcomeOfShot = shot.result();

        shot.makeChangesInGame(this, outcomeOfShot);
        updateUser (gameModel, target);
    }

    //This function updates the required fields in a user whenever a shot has been made by the user.
    private void updateUser(GameModel gameModel, Point target) {
        if (outcomeOfShot) {
            fortressMap.getCell(target).setName('X');
        } else {
            fortressMap.getCell(target).setName(' ');
        }

        int damage = 0;
        for (Tank tank : gameModel.getListOfTanks()) {
            damage += tank.damageByTank();
        }

        this.structuralIntegrity -= damage;
        if (structuralIntegrity < minimumStructuralIntegrity) {
            structuralIntegrity = minimumStructuralIntegrity;
        }
    }
}
