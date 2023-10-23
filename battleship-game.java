import java.util.Scanner;

public class BattleshipGame {
    private char[][] board;
    private boolean gameEnded;

    public BattleshipGame() {
        board = new char[10][10];
        gameEnded = false;
        // Initialize the board with empty spaces
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = ' ';
            }
        }
        // Place the ships
        board[1][1] = 'A'; // Aircraft carrier
        board[0][3] = 'C'; // Cruiser
        board[2][4] = 'D'; // Destroyer
        board[7][4] = 'S'; // Submarine
        board[4][8] = 'T'; // Torpedo boat
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameEnded) {
            System.out.println("Enter coordinates to fire:");
            String input = scanner.nextLine();
            int row = input.charAt(1) - '0';
            int col = input.charAt(0) - 'A';
            if (board[row][col] != ' ') {
                System.out.println("Hit!");
                board[row][col] = ' ';
                // Check if all ships are sunk
                if (allShipsSunk()) {
                    gameEnded = true;
                    System.out.println("You won!");
                }
            } else {
                System.out.println("Miss!");
            }
        }
        scanner.close();
    }

    private boolean allShipsSunk() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
