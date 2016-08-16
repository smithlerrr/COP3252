import javax.swing.JOptionPane;
import java.lang.String;

public class Stars
{
    private int rows;
    private int columns;
    private String star;

    public Stars()
    {
        rows = 1;
        columns = 1;
        star = "*";
    }

    public Stars(int r, int c)
    {
        rows = r;
        columns = c;
    }

    public void setRows(int r)
    {
        this.rows = r;
    }

    public void setColumns(int c)
    {
        this.columns = c;
    }

    public int getRows()
    {
        return rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public void Input()
    {
        setRows(Integer.parseInt(JOptionPane.showInputDialog(
                "How many rows of stars does our valiant knight see?")));

        setColumns(Integer.parseInt(JOptionPane.showInputDialog(
                "How many columns of stars does he see?")));
    }

    public void createSky()
    {
        String sky = null;
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(i%2 == 0)
                {
                    System.out.print("* ");
                }
                else
                    System.out.print(" *");
            }
            System.out.print("\n");
        }
    }
}