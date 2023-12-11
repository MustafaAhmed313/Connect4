/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connect4;

import connect4.Listeners.*;
import connect4.GameEngine.*;
 
import javax.media.opengl.GLCanvas;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import javax.swing.border.Border;


/**
 *
 * @author mosta
 */
public class Connect4 extends JFrame implements ActionListener{

  
   UserData user = new UserData() ;


    private GLCanvas glCanvas;

    private GameEventlistner listner = new GameEventlistner();
    private final JButton Button1;
    private final JButton Button2;
    private final JButton Button3;
    private final JButton Button4;
    private final JButton Button5;

    private final JPanel jPanel;
    private final JPanel jPanel2;


    public Connect4() {

        setBackground(Color.gray);


        Button1 = new JButton("Single player");
        Button2 = new JButton("Multi player");
        Button3 = new JButton("High Score");
        Button4 = new JButton("Sitings");
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


        setTitle("Our Game");
        setSize(700, 900);
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }


    public static void main(String[] args) {
        new Connect4();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(Button1)) {
    new SecondaryFrame();

        } else if (e.getSource().equals(Button4)) {


        } else if (e.getSource().equals(Button5)) {
            System.exit(0);
        }
    }
    public class SecondaryFrame extends JFrame implements ActionListener{

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
                user.setUsername(text.getText());
                new ThemesJFrame() ;
            }

        }
    }
    public class ThemesJFrame extends JFrame implements ActionListener{

        private final JPanel themepanel1;
        private final JPanel themepanel2;
        private final JPanel themepanel3;
        private final JPanel themepanel4;
        private final JRadioButton them1 ;
        private final JRadioButton them2 ;

        private final ButtonGroup themeGroup ;
        private final JButton play ;



        public ThemesJFrame(){

            SecondaryFrame s=new SecondaryFrame();
            themepanel1 = new JPanel() ;
            themepanel2 =new JPanel() ;
            themepanel3 =new JPanel() ;
            themepanel4 =new JPanel() ;

            setLayout(null);

            themepanel1.setBounds(0,5,800,70);
            add(themepanel1) ;

            them1 = new JRadioButton("Basic Theme") ;
            them1.setBounds(350,10,150,55);
            themepanel1.add(them1);
            Font r = new Font(them1.getFont().getName(), Font.ITALIC, 20);
            them1.setFont(r);


            themepanel2 .setBounds(0,75,800,260);
            add(themepanel2) ;

            themepanel3.setBounds(0,340,800,60);
            add(themepanel3);

            them2 =new JRadioButton("Ice And Fire") ;
            them2.setBounds(350,410,150,55);
            themepanel3.add(them2);

            Font r2 = new Font(them2.getFont().getName(), Font.ITALIC, 20);
            them2.setFont(r2);

            themepanel4.setBounds(0,470,600,260);
            add(themepanel4);


            play = new JButton("Play");
            add(play);
            play.setBounds(350,740,150,40);

            Font pl = new Font(play.getFont().getName(), Font.BOLD, 20);
            play.setFont(pl);
            play.addActionListener(this);


            them1.addActionListener(this);
            them2.addActionListener(this);

            themeGroup = new ButtonGroup() ;
            themeGroup.add(them1);
            themeGroup.add(them2);


            setTitle("Themes");
            setSize(800, 850);
            setLocationRelativeTo(this);
            setVisible(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(play)){
                System.out.println(user.username +"  "+user.level  +" "+user.design);
            }
           if(e.getSource().equals(them1)){
               user.setDesign(1);
           }
           else if(e.getSource().equals(them2)){
               user.setDesign(2);
           }




        }
    }

}
