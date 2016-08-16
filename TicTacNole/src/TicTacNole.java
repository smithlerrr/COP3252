import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TicTacNole
{
    public static Game game;

    public static void main(String [] args)
    {

        JLabel top, bottom;
        BufferedImage fsuImage = null;

        try {
            fsuImage = ImageIO.read(new File("FSU.jpg"));

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        JFrame frame = new JFrame();
        frame.setTitle("TIC-TAC-NOLE");
        frame.setSize(500, 700);
        frame.setLocation(100, 100);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);

        //top
        top = new JLabel(new ImageIcon(fsuImage));
        top.setSize(500, 92);
        top.setLocation(0, 0);
        frame.add(top);

        //Main game
        game = new Game();
        game.setLocation(0, 92);
        game.setSize(500, 500);
        frame.add(game);

        //Bottom
        bottom = new JLabel("Created By: Drew Smith");
        bottom.setSize(500, 50);
        bottom.setLocation(75, 600);
        bottom.setFont(bottom.getFont().deriveFont(32.0f));
        bottom.setForeground(new Color(211, 167, 0));
        frame.add(bottom);
    }
}