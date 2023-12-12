/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connect4;

<<<<<<< HEAD
import javax.sound.sampled.*;

import connect4.Frames.GameFrame;
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
import java.io.File;
import java.io.IOException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;

=======
import connect4.Frames.MainFrame;
>>>>>>> 7cd52cbc7d4a0e8b5d87748a1ff5f6554e86c6d1

/**
 *
 * @author mosta
 */
<<<<<<< HEAD
public class Connect4 extends JFrame implements ActionListener {

  
   static UserData user = new UserData() ;


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
    setResizable(false);
        

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


        setTitle("Our Game");
        setSize(700, 900);
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }


    public static void main(String[] args)  {





//        File file1 = new File("Heart-Of-The-Ocean(chosic.com).wav");
//        AudioInputStream audioStream1 =AudioSystem.getAudioInputStream(file1);
//        Clip clip1 =AudioSystem.getClip();
//        clip1.open(audioStream);






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(Button1)) {
           user.setNumPlayer(1);
    new SecondaryFrame();

        } else if (e.getSource().equals(Button2)) {
            user.setNumPlayer(2);
     new MultiPlayerFrame();

        }
        else if(e.getSource().equals(Button4)){
        new settings();
        }
        
        else if (e.getSource().equals(Button5)) {
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

            setResizable(false);
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
        
        private final GLCanvas gLCanvas2 ;
        private final GLCanvas gLCanvas3;
        private final GameEventListner2 listner2 = new GameEventListner2();
        private final GameEventListner3 listner3 =new GameEventListner3();

        private final ButtonGroup themeGroup ;
        private final JButton play ;



        public ThemesJFrame(){

            setResizable(false);
             
            SecondaryFrame s=new SecondaryFrame();
            themepanel1 = new JPanel() ;
            themepanel2 =new JPanel() ;
            themepanel3 =new JPanel() ;
            themepanel4 =new JPanel() ;

           
             
            gLCanvas2 = new GLCanvas();
            gLCanvas3  =new GLCanvas();
            
            gLCanvas2.addGLEventListener(listner2);
            gLCanvas3.addGLEventListener(listner3);
          
            setLayout(null);
            
            themepanel1.setBounds(0,5,800,70);
             add(themepanel1) ;

            them1 = new JRadioButton("Basic Theme") ;
            them1.setBounds(350,10,150,55);
            themepanel1.add(them1);
            Font r = new Font(them1.getFont().getName(), Font.ITALIC, 20);
            them1.setFont(r);


            themepanel2 .setBounds(0,70,800,275);
             add(themepanel2) ;
            themepanel2.setLayout(new GridLayout(1,1));
            themepanel2.add(gLCanvas2);      //

            themepanel3.setBounds(0,360,800,60);
            add(themepanel3);

            them2 =new JRadioButton("Ice And Fire") ;
            them2.setBounds(350,410,150,55);
            themepanel3.add(them2);

            Font r2 = new Font(them2.getFont().getName(), Font.ITALIC, 20);
            them2.setFont(r2);

            themepanel4.setBounds(0,430,800,280);
             add(themepanel4);
            themepanel4.setLayout(new GridLayout(1,1));
            themepanel4.add(gLCanvas3);
            


            play = new JButton("Play");
            add(play);
            play.setBounds(330,740,150,40);

            Font pl = new Font(play.getFont().getName(), Font.BOLD, 20);
            play.setFont(pl);
            play.addActionListener(this);
            play.setBackground(Color.CYAN);


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
                if(user.getNumPlayer()==1){
                System.out.println(user.getNumPlayer()+" "+user.getUsername() +"  "+user.getLevel()  +" "+user.getDesign());
            }
               
              else if(user.getNumPlayer()==2){
                  user.setLevel(0);
                System.out.println(user.getNumPlayer()+" "+user.getName1()+" "+user.getName2() + " "+user.getDesign());
            }
            
            }
           if(e.getSource().equals(them1)){
               user.setDesign(1);
           }
           else if(e.getSource().equals(them2)){
               user.setDesign(2);
           }
           else if(e.getSource().equals(play)){

               new GameFrame();
           }




        }
    }
    

     public class MultiPlayerFrame extends JFrame implements ActionListener{
     
         private final JButton themButton;
         private final JLabel  label1;
         private final JLabel  label2;
         private final JTextField text1;
         private final JTextField text2;
         
         
         public MultiPlayerFrame(){
             
             setLayout(null);
             setResizable(false);
             
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
            new  ThemesJFrame();
            }
        }
    }
     public static class settings extends JFrame implements ActionListener{


         private final JLabel volumSettings ;
         private final JToggleButton toggle;
          private final JToggleButton toggle1;
         private final JLabel backgroundsound;
         private final JLabel gamesound ;
         private final JButton apply ;
         
         public settings(){
             setResizable(false);
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
             

             apply = new JButton("Apply");
             apply.setBounds(150,300,100,50);
             add(apply);




             
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
        else if(e.getSource().equals(apply)){
            if(user.getBackSound()==0)
                user.setFlag(false);

        }
        }
        
     
     }
=======
public class Connect4 {
    public static void main(String[] args) {
        new MainFrame();
    }
>>>>>>> 7cd52cbc7d4a0e8b5d87748a1ff5f6554e86c6d1
}
