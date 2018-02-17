package ca.cmpt213.fortress;

class PlayGame {
    public static void main (String[] args) {
        System.out.println("Welcome to the game of Fortress Defending by Akansha Vaish and Raghav Mittal");

        int tanks = 10;
        int rows = 10;
        int columns = 10;
        Board board = new Board (rows, columns, tanks);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board.get(i,j).getName() + "\t");
            }
            System.out.println();
        }
    }
}
