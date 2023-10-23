public class Sudoku {
    private int[][] board;
    public static final int EMPTY = 0; // cellule vide
    public static final int SIZE = 9; // taille de notre grille Sudoku

    public Sudoku(int[][] board) {
        this.board = new int[SIZE][SIZE];       
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    // nous vérifions s'il est possible d'insérer un nombre dans une cellule donnée
    private boolean isPossible(int row, int col, int number) {
        // nous vérifions la ligne
        for (int i = 0; i < SIZE; i++)
            if (board[row][i] == number)
                return false;        
        // nous vérifions la colonne
        for (int i = 0; i < SIZE; i++)
            if (board[i][col] == number)
                return false;
        // nous vérifions la boîte
        int x = (col / 3) * 3;
        int y = (row / 3) * 3;       
        for (int i = y; i < y + 3; i++)
            for (int j = x; j < x + 3; j++)
                if (board[i][j] == number)
                    return false;
        // tout est ok
        return true;
    }

    // fonction de résolution
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // nous cherchons une cellule vide
                if (board[row][col] == EMPTY) {
                    // nous essayons les chiffres possibles
                    for (int number = 1; number <= SIZE; number++) {
                        if (isPossible(row, col, number)) {
                            // le nombre respecte les règles
                            board[row][col] = number;
                            if (solve()) { // nous commençons à nouveau avec cette configuration mise à jour
                                return true;
                            } else { // si ce n'est pas une solution, nous annulons cette case pour les autres solutions possibles
                                board[row][col] = EMPTY;
                            }
                        }
                    }
                    return false; // nous retournons false
                }
            }
        }        
        return true; // le sudoku est résolu
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
