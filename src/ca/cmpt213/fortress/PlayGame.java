package ca.cmpt213.fortress;

class PlayGame {
    public static void main (String[] args) {
        System.out.println("Welcome to the game of Fortress Defending by Akansha Vaish and Raghav Mittal");

        int tanks = 4;
        int rows = 4;
        int columns = 4;
        Board board = new Board (rows, columns, tanks);

        System.out.print("\t");
        for (int i = 1; i <= columns; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        char row = 'A';
        for (int i = 0; i < rows; i++) {
            System.out.print(row + "\t");
            row++;
            for (int j = 0; j < columns; j++) {
                System.out.print(board.get(i,j).getName() + "\t");
            }
            System.out.println();
        }
    }
}
