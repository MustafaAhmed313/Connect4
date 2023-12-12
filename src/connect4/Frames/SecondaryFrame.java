package connect4.Frames;

import connect4.Connect4;
import connect4.GameEngine.UserData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondaryFrame extends JFrame implements ActionListener {
    private static UserData user = new UserData();
    private final JRadioButton radio1;
    private final JRadioButton radio2;
    private final JRadioButton radio3;
    private final JLabel label ;
    private final ButtonGroup group1;
    private final JLabel  label2;
    private final JTextField text;
    private final JPanel p;
    private final JButton themButton;

    public SecondaryFrame() {

        setLayout(null);

        label = new JLabel(" Choose Level") ;
        label2 =new JLabel("Enter Username");
        radio1 = new JRadioButton("Easy Level") ;
        radio2 = new JRadioButton("Midium Level") ;
        radio3 = new JRadioButton("Hard Level") ;
        text = new JTextField(" ");

        text.setPreferredSize(new Dimension(150, 30));

        group1 =new ButtonGroup() ;
        group1.add(radio1);
        group1.add(radio2);
        group1.add(radio3);

        label2.setBounds(115,5,160,50);
        add(label2);
        Font l2 = new Font(label2.getFont().getName(), Font.BOLD, 20);
        label2.setFont(l2);
        label2.setBackground(Color.lightGray);
        label2.setOpaque(true);

        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        label2.setBorder(border1);

        p =new JPanel();
        p.setBounds(115,60,160,55);
        add(p);
        p.add(text) ;

        label.setBounds(120,120,150,50);
        add(label);
        Font bigFont = new Font(label.getFont().getName(), Font.BOLD, 20);
        label.setFont(bigFont);

        label.setBackground(Color.lightGray);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        radio1.setBounds(130,180,150,50);
        add(radio1);
        Font r1 = new Font(radio1.getFont().getName(), Font.ITALIC, 20);
        radio1.setFont(r1);

        radio2.setBounds(130,240,150,50);
        add(radio2);
        Font r2 = new Font(radio2.getFont().getName(), Font.ITALIC, 20);
        radio2.setFont(r2);

        radio3.setBounds(130,300,150,50);
        add(radio3);
        Font r3 = new Font(radio3.getFont().getName(), Font.ITALIC, 20);
        radio3.setFont(r3);

        themButton = new JButton("Themes") ;
        add(themButton);
        themButton.setBounds(120,370,150,50);

        Font them = new Font(themButton.getFont().getName(), Font.BOLD, 20);
        themButton.setFont(them);
        themButton.setBackground(Color.red);
        themButton.addActionListener(this);

        radio1.addActionListener(this);
        radio2.addActionListener(this);
        radio3.addActionListener(this);

        setTitle("Single Player");
        setSize(400, 500);
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(radio1)){
            user.setLevel(1);
        }

        else if(e.getSource().equals(radio2)) {
            user.setLevel(2);
        }
        else if(e.getSource().equals(radio3)) {
            user.setLevel(3);
        }
        else if(e.getSource().equals(themButton)){
            if(user.getNumPlayer()==1){
                user.setUsername(text.getText());}

            new ThemesFrame() ;
        }
    }
}
