/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connect4;

import connect4.Frames.MainFrame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.TargetDataLine;
import java.io.File;

/**
 *
 * @author mosta
 */
public class Connect4 {
    public static void main(String[] args) {
        try {
            new MainFrame();
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
