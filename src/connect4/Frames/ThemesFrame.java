package connect4.Frames;

import connect4.Connect4;
import connect4.GameEngine.UserData;
import connect4.Listeners.GameEventListener2;
import connect4.Listeners.GameEventListener3;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemesFrame extends JFrame implements ActionListener {
    private static UserData user = new UserData();
    private final JPanel themepanel1;
    private final JPanel themepanel2;
    private final JPanel themepanel3;
    private final JPanel themepanel4;
    private final JRadioButton them1 ;
    private final JRadioButton them2 ;
    private final GLCanvas gLCanvas2 ;
    private final GLCanvas gLCanvas3;
    private final GameEventListener2 listner2 = new GameEventListener2();
    private final GameEventListener3 listner3 =new GameEventListener3();

    private final ButtonGroup themeGroup ;
    private final JButton play ;

    public ThemesFrame(){

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
        themepanel2.add(gLCanvas2);

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
            Connect4.gameStatus.setTheme(1);
            user.setDesign(1);
        }
        else if(e.getSource().equals(them2)){
            Connect4.gameStatus.setTheme(2);
            user.setDesign(2);
        }
    }
    public static void main(String[] args) {
        new ThemesFrame();
    }
}
