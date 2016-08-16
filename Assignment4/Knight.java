//Drew Smith
//COP3252
//Assingment 4
//Feb. 28th, 2016

import java.util.*;

public class Knight 
{
    public String name;
    public int weapon;
    public int armor;
    public int health;

    public Random rand = new Random();
    public String[] nameList = {"John Snow", "Harry Potter", "Ryan Reynolds", "Michael Scott", "Luke Skywalker"};
    public String[] weapons = {"Long Sword", "Battle Axe", "Spear", "Warhammer"};
    public String[] armors = {"Leather", "Metal"};
    
    public Knight() 
    {
        setName(nameList[rand.nextInt(5)]);
        setWeapon(rand.nextInt(4));
        setArmor(rand.nextInt(2));
        setHealth(rand.nextInt(50) + 50);
    }

    public Knight(String n, int w) 
    {
        setName(n);
        setWeapon(w);
        setArmor(rand.nextInt(2));
        setHealth(rand.nextInt(50) + 50);
    }

    //mutator functions
    public void setName(String n) 
    {
        name = n;
    }

    public void setWeapon(int w)
    {
        weapon = w;
    }

    public void setArmor(int a) 
    {
        armor = a;
    }

    public void setHealth(int h) 
    {
        health = h;
    }

    //accessor functions
    public String getName() 
    {
        return name;
    }

    public int getIntWeapon() 
    {
        return weapon;
    }

    public String getWeapon()
    {
        return weapons[weapon];
    }

    public int getIntArmor() 
    {
        return armor;
    }

    public String getArmor() 
    {
        return armors[armor];
    }

    public int getHealth() 
    {
        return health;
    }

    public String toString() 
    {
        String temp;
        temp = "Knight Name:" + getName() 
            + "\nHealth: " + getHealth()
            + "\nWeapon: " + getWeapon()
            + "\nArmor: " + getArmor()
            + "\n";

        return temp;
    }
}
