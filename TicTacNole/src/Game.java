import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel
{

    public JButton Buttons[][] = new JButton[3][3];
    public Color Garnet = new Color(125, 14, 11);
    public Color Black = new Color(0, 0, 0);
    public Color Gold = new Color(211, 167, 0);

    public int[][] Board = new int[3][3];

    public boolean xWin = false;
    public boolean oWin = false;
    public boolean gameState = true;

    public int turn = 0;

    public Game()
    {
        UIManager.getDefaults().put("Button.disabledText", Garnet);
        UIManager.getDefaults().put("Button.disabledBackground", Gold);

        GridLayout grid = new GridLayout(3, 3);
        this.setLayout(grid);

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Buttons[i][j] = new JButton("");
                Buttons[i][j].setBackground(Black);
                Buttons[i][j].setName(i + "" + j);
                Buttons[i][j].setFont(new Font("Calibri", Font.BOLD, 100));
                Buttons[i][j].addActionListener(new ActionListener()
                {
                    //@Override
                    public void actionPerformed(ActionEvent e)
                    {
                        onButtonListener(e);
                    }
                });

                add(Buttons[i][j]);
            }
        }
    }

    public void onButtonListener(ActionEvent e)
    {
        turn++;

        if (gameState && !xWin && !oWin)
        {
            int x = Integer.parseInt(String.valueOf(((JButton) e.getSource()).getName().charAt(0)));
            int y = Integer.parseInt(String.valueOf(((JButton) e.getSource()).getName().charAt(1)));

            if (turn % 2 == 0)
            {
                Buttons[x][y].setText("X");
                Board[x][y] = 1;
            }

            else
            {
                Buttons[x][y].setText("O");
                Board[x][y] = -1;
            }

            Buttons[x][y].setEnabled(false);
            CheckState();
        }
    }

    public void CheckState()
    {
        //Rows
        for (int i = 0; i < 3; i++)
        {
            if (Board[i][0] + Board[i][1] + Board[i][2] == 3)
            {
                xWin = true;
                Buttons[i][0].setBackground(Garnet);
                Buttons[i][1].setBackground(Garnet);
                Buttons[i][2].setBackground(Garnet);
            }

            else if (Board[i][0] + Board[i][1] + Board[i][2] == -3)
            {
                oWin = true;
                Buttons[i][0].setBackground(Garnet);
                Buttons[i][1].setBackground(Garnet);
                Buttons[i][2].setBackground(Garnet);
            }
        }

        //Columns
        for (int i = 0; i < 3; i++)
        {
            if (Board[0][i] + Board[1][i] + Board[2][i] == 3)
            {
                xWin = true;
                Buttons[0][i].setBackground(Garnet);
                Buttons[1][i].setBackground(Garnet);
                Buttons[2][i].setBackground(Garnet);
            }

            else if (Board[0][i] + Board[1][i] + Board[2][i] == -3)
            {
                oWin = true;
                Buttons[0][i].setBackground(Garnet);
                Buttons[1][i].setBackground(Garnet);
                Buttons[2][i].setBackground(Garnet);
            }
        }

        //Diagonals
        if (Board[0][0] + Board[1][1] + Board[2][2] == 3)
        {
            xWin = true;
            Buttons[0][0].setBackground(Garnet);
            Buttons[1][1].setBackground(Garnet);
            Buttons[2][2].setBackground(Garnet);
        }

        else if (Board[2][0] + Board[1][1] + Board[0][2] == 3)
        {
            xWin = true;
            Buttons[2][0].setBackground(Garnet);
            Buttons[1][1].setBackground(Garnet);
            Buttons[0][2].setBackground(Garnet);
        }

        else if (Board[0][0] + Board[1][1] + Board[2][2] == -3)
        {
            oWin = true;
            Buttons[0][0].setBackground(Garnet);
            Buttons[1][1].setBackground(Garnet);
            Buttons[2][2].setBackground(Garnet);
        }

        else if (Board[2][0] + Board[1][1] + Board[0][2] == -3)
        {
            oWin = true;
            Buttons[2][0].setBackground(Garnet);
            Buttons[1][1].setBackground(Garnet);
            Buttons[0][2].setBackground(Garnet);
        }

        int replay;
        if (xWin)
        {
            replay = JOptionPane.showConfirmDialog(null,
                    "PLAYER X WINS\n\nPlay again?", "Tic-Tac-Nole", 0);
            if (replay == 0)
                Reset();
        }

        else if (oWin)
        {
            replay = JOptionPane.showConfirmDialog(null,
                    "PLAYER O WINS\n\nPlay again?", "Tic-Tac-Nole", 0);
            if (replay == 0)
                Reset();
        }

        else if (checkMoves() <= 0 && gameState)
        {
            replay = JOptionPane.showConfirmDialog(null, "TIE GAME\n\nPlay again?","Tic-Tac-Nole", 0);
            if (replay == 0)
                Reset();
        }
    }

    public int checkMoves()
    {
        int moves = 9;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (Board[i][j] != 0)
                {
                    moves--;
                }
            }
        }
        return moves;
    }

    void Reset()
    {
        Board = new int[3][3];
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                Buttons[i][j].setBackground(Black);
                Buttons[i][j].setText("");
                Buttons[i][j].setEnabled(true);
            }
        }
        xWin = false;
        oWin = false;
        gameState = true;
    }
}