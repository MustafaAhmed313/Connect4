
package connect4.Frames;

import connect4.Connect4.*;
import connect4.Listeners.GameBackGroundListener;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import connect4.Listeners.Connect4Listener;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener{

    private final JButton pause ;



    private JPanel ViewBoard = new JPanel();
    private JPanel ViewControl = new JPanel();
    public GameFrame() {
        GLCanvas glCanvas;
        Animator animate; //Animator Object.

        GameBackGroundListener listeners = new GameBackGroundListener(); //Listener Creation

        glCanvas = new GLCanvas(); //Canvas and Listeners Initialization
        glCanvas.addGLEventListener(listeners);
        glCanvas.addKeyListener(listeners);
        glCanvas.addMouseListener(listeners);
        addKeyListener(listeners);
        //addMouseListener(listeners);

        animate = new FPSAnimator(15); //Initialize Animator Object
        animate.add(glCanvas);
        animate.start();

        add(ViewBoard);
        ViewBoard.setSize(800 , 600);
        ViewBoard.setLayout(new GridLayout(1 , 1));
        ViewBoard.add(glCanvas);
        ViewBoard.setBounds(0 , 0,  800 , 600);
        ViewBoard.addMouseListener(listeners);
        add(ViewControl);
        ViewControl.setSize(200 , 600);
        ViewControl.setLayout(null);
        ViewControl.setBounds(800 , 0,  200 , 600);
        ViewControl.setBackground(Color.DARK_GRAY);


        setLayout(null);

        pause = new JButton(" | | ");
        pause.setBounds(850,50,70,50);
        add(pause);
        Font p1 = new Font( pause.getFont().getName(), Font.BOLD, 25);
       pause.setFont(p1);
        pause.setBackground(Color.CYAN);

        pause.addActionListener(this);




        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(1000 , 600);
        setLocationRelativeTo(this);
        setVisible(true);
        setFocusable(true); // Focus on the Key Events
        glCanvas.requestFocus();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(pause)){
            new pausMenue();
            setTitle("Connect4"); //Iniyialize Jframe
            System.out.println("menu");

        }
    }
    public static void main(String[] args) {
        new GameFrame();
    }

    public class pausMenue extends JFrame implements ActionListener {
        private final JButton resume ;
        private final JButton endGame ;
        private final JButton setting ;
        public pausMenue (){
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
                System.exit(0);
            }

            else if(e.getSource().equals(resume)){
            pausMenue.closeFrame(this);

            }
            else if(e.getSource().equals(setting)){
                new SettingsFrame();
                System.out.println("yyyy");
            }
        }
    }
}
