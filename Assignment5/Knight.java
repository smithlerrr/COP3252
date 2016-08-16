import java.util.*;

public class Knight 
{
    private String name;
    private int weapon;
    private int armor;
    private int health;

    private Random rand = new Random();
    private String[] nameList = {"John Snow", "Harry Potter", "Ryan Reynolds", "Michael Scott", "Luke Skywalker"};
    private String[] weapons = {"Long Sword", "Battle Axe", "Spear", "Warhammer"};
    private String[] armors = {"Leather", "Metal"};

    private int weaponDamage[] = {rand.nextInt(20) + 25,
                                  rand.nextInt(25) + 15,  
                                  rand.nextInt(30) + 10,
                                  rand.nextInt(35) + 5};

    private int armorProtection[][] = {{0, 5, 10}, {10, 5, 0}};                            
    
    public Knight() 
    {
        setName(nameList[rand.nextInt(4)]);
        setWeapon(rand.nextInt(3));
        setArmor(rand.nextInt(1));
        setHealth(rand.nextInt(75) + 50);
    }

    public Knight(String n, int w, int a) 
    {
        setName(n);
        setWeapon(w);
        setArmor(a);
        setHealth(rand.nextInt(75) + 75);
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

    public int getWeaponDamage() 
    {
        return weaponDamage[weapon];
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

    public int getVisibleEnemies() 
    {
        return rand.nextInt(3) + 1;
    }

    public void fight(Enemy e) 
    {
        int health, damage = 0;
        
        damage = e.getWeaponDamage() - armorProtection[getIntArmor()][e.getWeaponAsInt()];
        health = getHealth() - damage;

        if(health < 0)
            health = 0;
        
        setHealth(health);
        System.out.printf("The %s attacks %s with %d damage. %s's health is now %d\n"
                            ,e.getName(), getName(), damage, getName(), health);
    }

    public String toString() 
    {
        String temp;
        System.out.println("Here is your glorious Knight!\n");
        temp = "Knight Name:" + getName() 
            + "\nHealth: " + getHealth()
            + "\nWeapon: " + getWeapon()
            + "\nArmor: " + getArmor()
            + "\n";

        return temp;
    }
}
