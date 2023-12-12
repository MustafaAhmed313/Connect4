package connect4.Frames;

import connect4.GameEngine.UserData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiPlayerFrame extends JFrame implements ActionListener {
    private static UserData user = new UserData();
    private final JButton themButton;
    private final JLabel  label1;
    private final JLabel  label2;
    private final JTextField text1;
    private final JTextField text2;


    public MultiPlayerFrame(){

        setLayout(null);

        themButton = new JButton("Themes") ;
        add(themButton);
        themButton.setBounds(110,300,150,50);

        Font them = new Font(themButton.getFont().getName(), Font.BOLD, 20);
        themButton.setFont(them);
        themButton.setBackground(Color.CYAN);
        themButton.addActionListener(this);

        label1 = new JLabel("UserName1");
        label1.setBounds(120,5,120,50);
        add(label1);
        Font l2 = new Font(label1.getFont().getName(), Font.BOLD, 20);
        label1.setFont(l2);
        label1.setBackground(Color.lightGray);
        label1.setOpaque(true);

        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        label1.setBorder(border1);

        text1 = new JTextField();
        text1.setPreferredSize(new Dimension(150, 30));
        text1.setBounds(110,  70,  150,  30);
        add(text1);




        label2 = new JLabel("UserName2 ");
        label2.setBounds(120,120,120,50);
        add(label2);
        Font l = new Font(label2.getFont().getName(), Font.BOLD, 20);
        label2.setFont(l);
        label2.setBackground(Color.lightGray);
        label2.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label2.setBorder(border);

        text2 = new JTextField();
        text2.setPreferredSize(new Dimension(150, 30));
        text2.setBounds(110,  185,  150,  30);
        add(text2);




        setResizable(false);
        setTitle(" MultiPlayer");
        setSize(400, 400);
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(themButton)){
            if(user.getNumPlayer() == 2){
                user.setName1(text1.getText());
                user.setName2(text2.getText());
            }

            new ThemesFrame();
        }
    }
}
