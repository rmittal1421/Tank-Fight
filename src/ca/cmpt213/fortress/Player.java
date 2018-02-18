package ca.cmpt213.fortress;

public class Player {
    public static final int minimumStructuralIntegrity = 0;
    private int rows;
    private int columns;
    private int structuralIntegrity;
    public boolean outcomeOfShot;
    public DesignBoard fortressMap;

    public void setStructuralIntegrity(int structuralIntegrity) {
        this.structuralIntegrity = structuralIntegrity;
    }

    public Player(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        structuralIntegrity = 100;
        fortressMap = new DesignBoard(rows, columns, '~');
    }

    public int getStructuralIntegrity() {
        return structuralIntegrity;
    }

    public void play (Board board, Point target) {
        ShotAnalyzer shot = new ShotAnalyzer(board, target);
        this.outcomeOfShot = shot.result();

        shot.makeChangesInGame(this, outcomeOfShot);
        updateUser (board, target);
    }

    private void updateUser(Board board, Point target) {
        if (outcomeOfShot) {
            fortressMap.getCell(target).setName('X');
        } else {
            fortressMap.getCell(target).setName(' ');
        }

        int damage = 0;
        for (Tank tank : board.getListOfTanks()) {
            damage += tank.damageByTank();
        }

        this.setStructuralIntegrity(this.getStructuralIntegrity() - damage);
        if (this.getStructuralIntegrity() < minimumStructuralIntegrity) {
            this.setStructuralIntegrity(minimumStructuralIntegrity);
        }
    }
}
