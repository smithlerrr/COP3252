import javax.swing.JOptionPane;

public class Knight
{
    private String name;
    private int health;
    private int numBattles;
    private int age;
    private int gold;

    public Knight()
    {
        name = "Sir Drink-a-lot";
        health = 100;
        numBattles = 1;
        age = 21;
        gold = 1000;
    }

    public Knight(String n, int h, int b, int a, int g)
    {
        name = n;
        health = h;
        numBattles = b;
        age = a;
        gold = g;
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public void setHealth(int h)
    {
        this.health = h;
    }

    public void setNumBattles(int b)
    {
        this.numBattles = b;
    }

    public void setAge(int a)
    {
        this.age = a;
    }

    public void setGold(int g)
    {
        this.gold = g;
    }

    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public int getNumBattles()
    {
        return numBattles;
    }

    public int getAge()
    {
        return age;
    }

    public int getGold()
    {
        return gold;
    }

    public void Input()
    {
        setName(JOptionPane.showInputDialog(
                "Enter your Knight's name!"));

        setHealth(Integer.parseInt(JOptionPane.showInputDialog(
                "How much health does " + name + " have?")));

        setNumBattles(Integer.parseInt(JOptionPane.showInputDialog(
                "How many battles has " + name + " won?")));

        setAge(Integer.parseInt(JOptionPane.showInputDialog(
                "What is the age of " + name + "?")));

        setGold(Integer.parseInt(JOptionPane.showInputDialog(
                "How much gold has " + name + " pillaged?")));
    }

    public void Output()
    {
        System.out.println("Knight Name: " + name);
        System.out.println("Knight Health: " + health);
        System.out.println("Knight Battles: " + numBattles);
        System.out.println("Knight Age: " + age);
        System.out.println("Knight Gold: $" + gold);
    }
}