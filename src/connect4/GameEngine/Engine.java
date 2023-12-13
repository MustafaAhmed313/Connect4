/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect4.GameEngine;

import java.util.Arrays;

/**
 *
 * @author mosta
 */
public class Engine {
    static final int LEVEL1 = 1  , LEVEL2 = 2 , LEVEL3 = 3;
    int player , size , level;
    boolean player1win , player2win , noGameLoop;
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private char[][] board;
    private char currentPlayer;

    public Engine() {
        this.player = 1;
        this.player1win = false;
        this.player2win = false;
        this.noGameLoop = false;
        this.size = 0;
    }

    public void setLevel(int level) {
        this.level = (level == 1) ? LEVEL1 : (level == 2) ? LEVEL2 : LEVEL3;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
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

    public void clearCurrentState() {
        board = new char[6][7];
        this.player = 1;
        this.player1win = false;
        this.player2win = false;
        this.noGameLoop = false;
    }
}