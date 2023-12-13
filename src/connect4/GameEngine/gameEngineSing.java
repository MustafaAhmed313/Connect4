package connect4.GameEngine;

import java.util.Random;
import java.util.Scanner;

public class gameEngineSing {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private char[][] board;
    char currentPlayer = 'X';
    private Scanner scanner;

    public gameEngineSing() {
        board = new char[ROWS][COLS];
        initializeBoard();
        scanner = new Scanner(System.in);
    }

    private void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        for (int j = 0; j < COLS; j++) {
            System.out.print("----");
        }
        System.out.println();
        for (int j = 0; j < COLS; j++) {
            System.out.print("  " + (j + 1) + " ");
        }
        System.out.println();
    }

    private boolean makeMove(int column, char player) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = player;
                return true;
            }
        }
        return false;
    }

    private boolean isColumnFull(int column) {
        return board[0][column] != ' ';
    }
    private int indexMove(int column) {
        int index = -1;
        for (int i = 0; i < ROWS; i--) {
            if (board[i][column] == ' ') {
                i = index;
                break;
            }
        }
        return index;
    }


    private boolean isBoardFull() {
        for (int i = 0; i < COLS; i++) {
            if (!isColumnFull(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWin() {
        return checkHorizontal() || checkVertical() || checkDiagonal();
    }

    private boolean checkHorizontal() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
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
            for (int col = 0; col < COLS; col++) {
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
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] != ' '
                        && board[row][col] == board[row + 1][col + 1]
                        && board[row][col] == board[row + 2][col + 2]
                        && board[row][col] == board[row + 3][col + 3]) {
                    return true;
                }
            }
        }

        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLS- 3; col++) {
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
    //
    private boolean isValidMove(int column) {
        return column >= 0 && column < COLS && !isColumnFull(column);
    }

    private void undoMove(int column) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][column] != ' ') {
                board[row][column] = ' ';
                break;
            }
        }
    }
//
//    private int minimax(int depth, char player) {
//        if (depth == 0 || isBoardFull()) {
//            return evaluateBoard();
//        }
//        int bestScore = (player == 'O') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//        for (int col = 0; col < COLS; col++) {
//            if (isValidMove(col)) {
//                makeMove(col, player);
//
//                int score = minimax(depth - 1, (player == 'X') ? 'O' : 'X');
//                undoMove(col);
//
//                if ((player == 'O' && score > bestScore) || (player == 'X' && score < bestScore)) {
//                    bestScore = score;
//                }
//            }
//        }
//
//        return bestScore;
//    }
//    private int evaluateBoard() {
//        int score = 0;
//
//        // Evaluate rows
//        for (int row = 0; row < ROWS; row++) {
//            for (int col = 0; col < COLS - 3; col++) {
//                score += evaluateLine(board[row][col], board[row][col + 1], board[row][col + 2], board[row][col + 3]);
//            }
//        }
//
//        // Evaluate columns
//        for (int col = 0; col < COLS; col++) {
//            for (int row = 0; row < ROWS - 3; row++) {
//                score += evaluateLine(board[row][col], board[row + 1][col], board[row + 2][col], board[row + 3][col]);
//            }
//        }
//
//        // Evaluate diagonals
//        for (int row = 0; row < ROWS - 3; row++) {
//            for (int col = 0; col < COLS - 3; col++) {
//                score += evaluateLine(board[row][col], board[row + 1][col + 1], board[row + 2][col + 2], board[row + 3][col + 3]);
//            }
//        }
//
//        for (int row = 3; row < ROWS; row++) {
//            for (int col = 0; col < COLS - 3; col++) {
//                score += evaluateLine(board[row][col], board[row - 1][col + 1], board[row - 2][col + 2], board[row - 3][col + 3]);
//            }
//        }
//
//        return score;
//    }
//    private int evaluateLine(char a, char b, char c, char d) {
//        int score = 0;
//
//        // Evaluate the line based on the number of consecutive pieces
//        int playerCount = 0;
//        int opponentCount = 0;
//
//        // Count consecutive pieces for the AI player ('O') and the opponent ('X')
//        if (a == 'O') playerCount++;
//        else if (a == 'X') opponentCount++;
//
//        if (b == 'O') playerCount++;
//        else if (b == 'X') opponentCount++;
//
//        if (c == 'O') playerCount++;
//        else if (c == 'X') opponentCount++;
//
//        if (d == 'O') playerCount++;
//        else if (d == 'X') opponentCount++;
//
//        // Assign scores based on the number of consecutive pieces
//        if (playerCount == 4) {
//            score += 100; // AI player wins
//        } else if (opponentCount == 4) {
//            score -= 100; // Opponent wins
//        } else if (playerCount == 3 && opponentCount == 0) {
//            score += 5; // AI player has three consecutive pieces
//        } else if (playerCount == 2 && opponentCount == 0) {
//            score += 2; // AI player has two consecutive pieces
//        } else if (opponentCount == 3 && playerCount == 0) {
//            score -= 5; // Opponent has three consecutive pieces
//        } else if (opponentCount == 2 && playerCount == 0) {
//            score -= 2; // Opponent has two consecutive pieces
//        }
//
//        return score;
//    }

    private boolean level1() {
        Random random = new Random();
        int column;
        do {
            column = random.nextInt(COLS);
        } while (isColumnFull(column));
        return makeMove(column, 'O');
    }


//    private boolean level2() {
//        Random random = new 1Random();
//        int column;
//
//        // Check if the bot can win in the next move
//        for (column = 0; column < COLS; column++) {
//            if (isValidMove(column)) {
//                makeMove(column, 'O');
//                if (checkWin()) {
//                    undoMove(column);
//                    return makeMove(column, 'O');
//                }
//                undoMove(column);
//            }
//        }
//
//        // If the player can win in the next move, block the winning move
//        for (column = 0; column < COLS; column++) {
//            if (isValidMove(column)) {
//                makeMove(column, 'X');
//                if (checkWin()) {
//                    undoMove(column);
//                    return makeMove(column, 'O');
//                }
//                undoMove(column);
//            }
//        }
//
//        // If no winning moves are found, choose a random move
//        do {
//            column = random.nextInt(COLS);
//        } while (isColumnFull(column));
//
//        return makeMove(column, 'O');
//    }
//
//    private boolean level3() {
//        int bestMove = -1;
//        int bestScore = Integer.MIN_VALUE;
//
//        for (int col = 0; col < COLS; col++) {
//            if (isValidMove(col)) {
//                makeMove(col, 'O');
//                int score = minimax(3, 'X'); // Adjust the depth as needed
//                undoMove(col);
//
//                if (score > bestScore) {
//                    bestScore = score;
//                    bestMove = col;
//                }
//            }
//        }
//
//        if (bestMove != -1) {
//            return makeMove(bestMove, 'O');
//        }
//
//        // If no valid moves are found, choose a random move
//        Random random = new Random();
//        int column;
//        do {
//            column = random.nextInt(COLS);
//        } while (isColumnFull(column));
//
//        return makeMove(column, 'O');
//    }


    public void playGame(int currentLevel) {


        while (true) {
            printBoard();

            if (currentPlayer == 'X') {
                int column;
                do {
                    System.out.print("Player X, enter your move (1-7): ");
                    column = scanner.nextInt() - 1;
                } while (!isValidMove(column));

                makeMove(column, currentPlayer);

                if (checkWin()) {
                    printBoard();
                    System.out.println("Player X wins!");
                    break;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                }
            } else {
                // Bot's turn
                boolean validMove = false;
                switch (currentLevel) {
                    case 1:
                        validMove = level1();
                        break;
//                    case 2:
//                        validMove = level2();
//                        break;
//                    case 3:
//                        validMove = level3();
//                        break;
                    default:
                        validMove = false;
                        break;
                }

                if (!validMove) {
                    System.out.println("Error: Invalid move for the bot.");
                    break;
                }

                if (checkWin()) {
                    printBoard();
                    System.out.println("Bot wins!");
                    break;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                }
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public static void main(String[] args) {
        gameEngineSing game = new gameEngineSing();
        game.playGame(1); // Set the difficulty level (1, 2, or 3)
    }
}
