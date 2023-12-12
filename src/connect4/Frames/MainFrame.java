/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect4.Frames;

import connect4.Frames.*;

/**
 *
 * @author mosta
 */

import connect4.Connect4;
import connect4.GameEngine.UserData;
import connect4.Listeners.GameEventlistner;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    UserData user = new UserData();

    private GLCanvas glCanvas;

    private GameEventlistner listner = new GameEventlistner();
    private final JButton Button1;
    private final JButton Button2;
    private final JButton Button3;
    private final JButton Button4;
    private final JButton Button5;
    private final JPanel jPanel;
    private final JPanel jPanel2;

    public MainFrame() {

        setBackground(Color.gray);

        Button1 = new JButton("Single player");
        Button2 = new JButton("Multi player");
        Button3 = new JButton("High Score");
        Button4 = new JButton("Settings");
        Button5 = new JButton("Exit");
        jPanel = new JPanel();
        jPanel2 = new JPanel();

        setLayout(new BorderLayout());

        jPanel.setLayout(null);

        jPanel.add(Button1);
        jPanel.add(Button2);
        jPanel.add(Button3);
        jPanel.add(Button4);
        jPanel.add(Button5);

        add(jPanel2);

        jPanel2.setBackground(Color.gray);
        jPanel2.setLayout(null);
        jPanel2.setBounds(0, 20, 700, 300);

        add(jPanel);

        jPanel.setLayout(null);

        Button1.setBounds(190, 350, 300, 70);
        Button2.setBounds(190, 440, 300, 70);
        Button3.setBounds(190, 530, 300, 70);
        Button4.setBounds(190, 620, 300, 70);
        Button5.setBounds(190, 710, 300, 70);

        Font p1 = new Font(Button1.getFont().getName(), Font.BOLD, 20);
        Button1.setFont(p1);

        Font p2 = new Font(Button2.getFont().getName(), Font.BOLD, 20);
        Button2.setFont(p2);

        Font p3 = new Font(Button3.getFont().getName(), Font.BOLD, 20);
        Button3.setFont(p3);

        Font p4 = new Font(Button4.getFont().getName(), Font.BOLD, 20);
        Button4.setFont(p4);

        Font p5 = new Font(Button5.getFont().getName(), Font.BOLD, 20);
        Button5.setFont(p5);


        Button1.setBackground(Color.CYAN);
        Button2.setBackground(Color.CYAN);
        Button3.setBackground(Color.CYAN);
        Button4.setBackground(Color.CYAN);
        Button5.setBackground(Color.CYAN);

        jPanel.setBackground(Color.darkGray);


        glCanvas = new GLCanvas();
        glCanvas.addGLEventListener(listner);

        jPanel2.setLayout(new GridLayout(1, 1));
        jPanel2.add(glCanvas);

        Button1.addActionListener(this);
        Button2.addActionListener(this);
        Button3.addActionListener(this);
        Button4.addActionListener(this);
        Button5.addActionListener(this);


        //action when we clicked on easy

        setTitle("Connect 4");
        setSize(700, 900);
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    public void actionPerformed (ActionEvent e){
        if (e.getSource().equals(Button1)) {
            user.setNumPlayer(1);
            Connect4.gameStatus.setMode(1);
            new SecondaryFrame();
        } else if (e.getSource().equals(Button2)) {
            user.setNumPlayer(2);
            Connect4.gameStatus.setMode(2);
            new MultiPlayerFrame();
        } else if (e.getSource().equals(Button4)) {
            new SettingsFrame();
        } else if (e.getSource().equals(Button5)) {
            System.exit(0);
        }
    }
}
