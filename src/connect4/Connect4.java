/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connect4;

import connect4.Frames.MainFrame;
import java.io.File;
import connect4.Frames.MainFrame;
import connect4.Frames.SettingsFrame;
import connect4.GameEngine.UserData;
import java.io.IOException;
import javax.sound.sampled.*;
import connect4.Storage.GameStatus;

/**
 *
 * @author mosta
 */

public class Connect4 {
    public static GameStatus gameStatus = new GameStatus();
    public static Clip clip;
    public static int check = 1;

    public static void main(String[] args) {
        try {
            File file = new File("E:\\Java projects\\Connect4\\src\\connect4\\Assets\\Carefree(chosic.com).wav"); //////////////////////////////
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            new MainFrame();

            UserData user = new UserData();

            while (user.getBackSound() == 1) {
                clip.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
