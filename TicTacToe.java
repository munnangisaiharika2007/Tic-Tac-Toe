import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char player = 'X';
        boolean gameOver = false;

        initializeBoard();

        while (!gameOver) {

            printBoard();

            System.out.println("Player " + player + " enter row and column (0-2):");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position! Try again.");
                continue;
            }

            if (board[row][col] == ' ') {

                board[row][col] = player;

                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + player + " Wins!");
                    gameOver = true;
                }

                else if (isBoardFull()) {
                    printBoard();
                    System.out.println("Game is Draw!");
                    gameOver = true;
                }

                else {
                    player = (player == 'X') ? 'O' : 'X';
                }

            } else {
                System.out.println("Cell already occupied. Try again.");
            }
        }

        sc.close();
    }

    static void initializeBoard() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void printBoard() {

        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {

            System.out.print("| ");

            for (int j = 0; j < 3; j++) {

                System.out.print(board[i][j] + " | ");

            }

            System.out.println();
            System.out.println("-------------");
        }
    }

    static boolean checkWin() {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] &&
                board[i][1] == board[i][2] &&
                board[i][0] != ' ') {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] &&
                board[1][i] == board[2][i] &&
                board[0][i] != ' ') {
                return true;
            }
        }

        if (board[0][0] == board[1][1] &&
            board[1][1] == board[2][2] &&
            board[0][0] != ' ') {
            return true;
        }

        if (board[0][2] == board[1][1] &&
            board[1][1] == board[2][0] &&
            board[0][2] != ' ') {
            return true;
        }

        return false;
    }

    static boolean isBoardFull() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}