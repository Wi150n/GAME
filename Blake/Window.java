
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
/**
 *
 * @author BlakeAllen
 */
public class Window extends Canvas {

    public Window(int width, int height, String name, Game game) {
        JFrame jf = new JFrame();
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setPreferredSize(new Dimension(width, height));
        jf.setMaximumSize(new Dimension(width, height));
        jf.setMinimumSize(new Dimension(width, height));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.add(game);
        game.start();
    }
}
