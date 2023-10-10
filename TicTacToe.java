import java.util.Scanner;
import java.util.Random;
public class TicTacToe {
    static char[][] board = new char[3][3];
    static char currentPlayer;
    static boolean isGameOver = false;

    public static void main(String[] args) {
        initializeBoard();
        currentPlayer = 'X';
        printBoard();

        while (!isGameOver) {
            if (currentPlayer == 'X') {
                playerMove();
            } else {
                botMove();
            }

            printBoard();
            checkGameOver();
            togglePlayer();
        }
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
            System.out.println("\n-------------");
        }
    }

    static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Masukkan baris (0-2): ");
            row = scanner.nextInt();
            System.out.print("Masukkan kolom (0-2): ");
            col = scanner.nextInt();
        } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');
        board[row][col] = 'X';
    }

    static void botMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board[row][col] != ' ');
        board[row][col] = 'O';
    }

    static void togglePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    static void checkGameOver() {
        if (checkWin('X')) {
            System.out.println("wah lio sangat senang,selamat iya x kamu memenangkan permainan ini!");
            isGameOver = true;
        } else if (checkWin('O')) {
            System.out.println("aduh kamu kalah, tapi jangan bersedih syifa akan tetap menemani kammu sampai kamu menang semangat!");
            isGameOver = true;
        } else if (isBoardFull()) {
            System.out.println("wah pemain yang sama sama hebat, mari kita coba kembali!");
            isGameOver = true;
        }
    }
    static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
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