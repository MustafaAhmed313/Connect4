package connect4.Frames;

import connect4.Connect4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseFrame extends JFrame implements ActionListener {
    private GameFrame gameFrame;
    private final JButton resume ;
    private final JButton endGame ;
    private final JButton setting ;
    public PauseFrame(){
        setLayout(null);

        resume = new JButton("RESUME");
        resume.setBounds(50,50,250,50);
        add(resume);
        Font p1 = new Font(resume.getFont().getName(), Font.BOLD, 20);
        resume.setFont(p1);


        setting = new JButton("SETTINGS");
        setting.setBounds(50,110,250,50);
        add(setting);
        Font p2 = new Font(setting.getFont().getName(), Font.BOLD, 20);
        setting.setFont(p2);


        endGame = new JButton("EXIT");
        endGame.setBounds(50,170,250,50);
        add(endGame);
        Font p3 = new Font(endGame.getFont().getName(), Font.BOLD, 20);
        endGame.setFont(p3);

        endGame.addActionListener(this);
        setting.addActionListener(this);
        resume.addActionListener(this);


        setTitle("Options");
        setSize(350, 350);
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    private static void closeFrame(JFrame frame) {
        frame.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(endGame)){

            new MainFrame();
        }
        else if(e.getSource().equals(resume)){
            GameFrame.animate.start();
            PauseFrame.closeFrame(this);
        }
        else if(e.getSource().equals(setting)){
            new SettingsFrame();
            System.out.println("yyyy");
        }
    }
}
