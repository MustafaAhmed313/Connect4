package connect4.Frames;

import connect4.GameEngine.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame implements ActionListener {
    private static UserData user = new UserData();
    private final JLabel volumSettings ;
    private final JToggleButton toggle;
    private final JToggleButton toggle1;
    private final JLabel backgroundsound;
    private final JLabel gamesound ;

    public SettingsFrame(){
        setLayout(null);
        volumSettings = new JLabel("Settings of Sound");
        add(volumSettings);
        volumSettings.setBounds(120, 10, 180, 40);
        Font l2 = new Font(volumSettings.getFont().getName(), Font.BOLD, 20);
        volumSettings.setFont(l2);
        volumSettings.setBackground(Color.lightGray);
        volumSettings.setOpaque(true);

        backgroundsound = new JLabel("Background Sound");
        add(backgroundsound);
        backgroundsound.setBounds(5,60,150,40 );
        Font v = new Font( backgroundsound .getFont().getName(), Font.BOLD, 14);
        backgroundsound.setFont( v);

        toggle = new JToggleButton("ON / OF");
        add(toggle);
        toggle.setBounds(200, 70, 80, 30);


        gamesound = new JLabel("Game sound");
        add(gamesound);
        gamesound.setBounds(5,125,150,40 );
        Font g = new Font( gamesound .getFont().getName(), Font.BOLD, 14);
        gamesound.setFont( g);

        toggle1 =new JToggleButton("ON / OF");
        add(toggle1);
        toggle1.setBounds(200,135,80,30);



        setTitle("settings");
        setSize(400, 400);
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(toggle)){
            user.setBackSound(0);
        }
        else if(e.getSource().equals(toggle1)){
            user.setGameSound(0);
        }
    }
}
