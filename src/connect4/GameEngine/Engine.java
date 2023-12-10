/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect4.GameEngine;

/**
 *
 * @author mosta
 */
public class Engine {
    static final int LEVEL1 = 1  , LEVEL2 = 2 , LEVEL3 = 3;
    int player , size , level;
    boolean player1win , player2win , noGameLoop;
    int[][] board;

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

    public void playTurn(int columnPosition) {
        int i = 5;
        while (board[i][columnPosition] != 0 && i >= 0) i--;
        if (i != -1) {
            board[i][columnPosition] = this.player;
            this.player = (this.player == 1) ? 2 : 1;
            size++;
        }
    }

    public boolean isFull() {
        return this.size == 7 * 6;
    }

    public void displayCurrentState() {
        System.out.print("[");
        for (int i = 0 ; i < 6 ; i++) {
            System.out.print("[");
            for (int j = 0 ; j < 7 ; j++) {
                System.out.print(board[i][j]);
                if (j < 6) System.out.print(" , ");
            }
            System.out.print("]");
            if (i < 5) System.out.print(",");
            System.out.println();
        }
        System.out.print("]");
        System.out.println();
    }

    public void clearCurrentState() {
        board = new int[6][7];
        this.player = 1;
        this.player1win = false;
        this.player2win = false;
        this.noGameLoop = false;
    }
}
