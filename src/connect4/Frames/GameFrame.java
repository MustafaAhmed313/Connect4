package connect4.Frames;

import connect4.Connect4;
import connect4.Connect4.*;
import connect4.GameEngine.UserData;
import connect4.Listeners.GameBackGroundListener;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import connect4.Listeners.Connect4Listener;
import connect4.Listeners.*;
import connect4.Listeners.GameEventListener2;
import connect4.Listeners.GameEventlistner;

import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    private final JButton pause;
    private JPanel ViewBoard = new JPanel();
    private JPanel ViewControl = new JPanel();
    private static JLabel user1 , user2;


    private static GLCanvas glCanvas;
    public static Animator animate; // Animator Object.
    public GameFrame() {

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
        ViewBoard.setSize(800, 600);
        ViewBoard.setLayout(new GridLayout(1, 1));
        ViewBoard.add(glCanvas);
        ViewBoard.setBounds(0, 0, 800, 600);
        ViewBoard.addMouseListener(listeners);
        ViewBoard.addMouseMotionListener(listeners);
        add(ViewControl);
        ViewControl.setSize(200, 600);
        ViewControl.setLayout(null);
        ViewControl.setBounds(800, 0, 200, 600);
        ViewControl.setBackground(Color.DARK_GRAY);
        ViewControl.setFocusable(true);

        pause = new JButton(" | | ");
        pause.setBounds(860,500,70,50);
        ViewControl.add(pause);
        Font p1 = new Font( pause.getFont().getName(), Font.BOLD, 25);
        pause.setFont(p1);
        pause.setBackground(Color.CYAN);
        pause.addActionListener(this);
        add(pause);

        if (Connect4.gameStatus.getMode() == 1) {
            user1 = new JLabel(SecondaryFrame.user.getUsername());
            ViewControl.add(user1);
            add(user1);
            user1.setBounds(860,50,70,50);
        }else {
            user1 = new JLabel(SecondaryFrame.user.getName1());
            user2 = new JLabel(SecondaryFrame.user.getName2());
            ViewControl.add(user1);
            ViewControl.add(user2);
            add(user1);
            add(user2);
        }

        setLayout(null);

        setTitle("Connect4"); // Iniyialize Jframe
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setResizable(false);
        setLocationRelativeTo(this);
        setVisible(true);

        setFocusable(true); // Focus on the Key Events
        glCanvas.requestFocus();
    }

    public static void main(String[] args) {
        new GameFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pause)) {
            new PauseFrame();
            animate.stop();
            setTitle("Connect4"); //Iniyialize Jframe
            System.out.println("menu");
        }
    }
}