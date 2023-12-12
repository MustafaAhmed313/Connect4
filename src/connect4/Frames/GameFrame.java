
package connect4.Frames;

import connect4.Listeners.GameBackGroundListener;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
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
        Animator animate; // Animator Object.

        GameBackGroundListener listeners = new GameBackGroundListener(); // Listener Creation

        glCanvas = new GLCanvas(); // Canvas and Listeners Initialization
        glCanvas.addGLEventListener(listeners);
        glCanvas.addKeyListener(listeners);
        glCanvas.addMouseListener(listeners);
        glCanvas.addMouseMotionListener(listeners);
        addKeyListener(listeners);

        animate = new FPSAnimator(60); // Initialize Animator Object
        animate.add(glCanvas);
        animate.start();

        add(ViewBoard);
        ViewBoard.setSize(800 , 600);
        ViewBoard.setLayout(new GridLayout(1 , 1));
        ViewBoard.add(glCanvas);
        ViewBoard.setBounds(0 , 0,  800 , 600);
        ViewBoard.addMouseListener(listeners);
        ViewBoard.addMouseMotionListener(listeners);
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

        setTitle("Connect4"); // Iniyialize Jframe
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
}
