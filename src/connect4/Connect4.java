/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connect4;


import connect4.Frames.MainFrame;
import connect4.Storage.GameStatus;


/**
 *
 * @author mosta
 */

public class Connect4 {
    public static GameStatus gameStatus = new GameStatus();
    public static void main(String[] args) {
        try {
            new MainFrame();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
