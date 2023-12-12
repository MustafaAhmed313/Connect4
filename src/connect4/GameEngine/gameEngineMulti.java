package connect4.GameEngine;

import java.util.Arrays;
import java.util.Scanner;

public class gameEngineMulti {
    int index = 6;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        gameEngineMulti connect4 = new gameEngineMulti();
        connect4.printBoard();

        while (true) {
            int column = input.nextInt();
            if (connect4.dropToken(column)) {
                connect4.switchPlayer();
                connect4.printBoard();
                System.out.println(connect4.indexMove(column));
                if (connect4.checkWin()) {
                    if (connect4.getCurrentPlayer() == 'X')
                        System.out.println("Player O wins!");
                    else
                        System.out.println("Player X wins!");
                    break;
                }
            } else {
                System.out.println("Column is full. Try again.");
            }
        }
    }

    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private char[][] board;
    private int arr[] = { 6, 6, 6, 6, 6, 6, 6 };
    private char currentPlayer;

    public gameEngineMulti() {
        board = new char[ROWS][COLUMNS];
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
        currentPlayer = 'X';
    }

    public void printBoard() {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public boolean dropToken(int column) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][column] == ' ') {
                board[row][column] = currentPlayer;
                return true;
            }
        }
        return false; // Column is full
    }

    public boolean checkWin() {
        return checkHorizontal() || checkVertical() || checkDiagonal();
    }

    private boolean checkHorizontal() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] != ' '
                        && board[row][col] == board[row][col + 1]
                        && board[row][col] == board[row][col + 2]
                        && board[row][col] == board[row][col + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVertical() {
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (board[row][col] != ' '
                        && board[row][col] == board[row + 1][col]
                        && board[row][col] == board[row + 2][col]
                        && board[row][col] == board[row + 3][col]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal() {
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] != ' '
                        && board[row][col] == board[row + 1][col + 1]
                        && board[row][col] == board[row + 2][col + 2]
                        && board[row][col] == board[row + 3][col + 3]) {
                    return true;
                }
            }
        }

        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] != ' '
                        && board[row][col] == board[row - 1][col + 1]
                        && board[row][col] == board[row - 2][col + 2]
                        && board[row][col] == board[row - 3][col + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public int indexMove(int column) {
        for (int i = (ROWS - 1); i >= 0; i--) {
            if (board[i][column] != ' ') {
                arr[column]--;
                if (arr[column] == -1) {
                    arr[column] = 5;
                }
                break;
            }
            if (i == 0) {
                arr[column] = 0;
            }
        }
        return arr[column];
    }

}