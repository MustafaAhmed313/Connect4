package connect4.Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScoreFrame extends JFrame implements ActionListener {
    private final JLabel score ;
    private final JButton done ;
    private final JLabel result ;
    private final JLabel result1 ;
    public HighScoreFrame(){


        setResizable(false);

        setLayout(null);

        score = new JLabel() ;
        setBounds(60,50,140,60);
        add(score);

        done = new JButton("Done");
        done.setBounds(60,120,80,40);
        add(done);
        done.addActionListener(this);

        result1 = new JLabel("High score");
        result1.setBounds(60,110,100,40);
        add(result1);

        result = new JLabel("100 ms");
        result.setBounds(60,50,100,40);
        add(result);

        setResizable(false);
        setTitle("HightScore");
        setSize(200, 200);
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(done)){
            HighScoreFrame.closeFrame(this);
        }
    }
    private static void closeFrame(HighScoreFrame frame) {
        frame.dispose();
    }
}
