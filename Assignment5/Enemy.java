import java.util.*;

public abstract class Enemy 
{
  private String weapons[] = {"Spiked Bat", "Magical Wand", "Wizard Staff"};
  private int weaponDamage[] = {new Random().nextInt(20) + 10, 
                                new Random().nextInt(30) + 10, 
                                new Random().nextInt(40) + 10,};

  private String name;
  private int health;
  private int weapon;

  public void takeDamage(int d) throws InvalidDamageException 
  {
    int newHealth = getHealth() - d;
    
    if (newHealth < 0)
      throw new InvalidDamageException();    
    
    else
      setHealth(newHealth);
  }

  public static Enemy getRandomEnemy() 
  {
    int numEnemies = new Random().nextInt(3);
    Enemy enemies[] = {new Ogre(), new Sorcerer(), new Wizard()};

    return enemies[numEnemies];
  }

  public void setName(String n) 
  {
    name = n;
  }

  public String getName() 
  {
    return name;
  }

  public void setHealth(int h) 
  {
    health = h;
  }

  public int getHealth() 
  {
    return health;
  }

  public void setWeapon(int w) 
  {
    weapon = w;
  }

  public String getWeapon() 
  {
    return weapons[weapon];
  }

  public int getWeaponAsInt() 
  {
    return weapon;
  }

  public int getWeaponDamage() 
  {
    return weaponDamage[weapon];
  }

  abstract public void fight(Knight k);
}


///////////////   Class Ogre    ///////////////////
class Ogre extends Enemy 
{
  public Ogre() 
  {
    setName("Ogre");
    setHealth(80);
    setWeapon(0); //Wooden Club
  }
  
  @Override public void fight(Knight opp) 
  {
    int damage = opp.getWeaponDamage();

    try 
    {
      takeDamage(damage);
    }
    catch(InvalidDamageException e) 
    {
      setHealth(0);
    }

    System.out.printf("%s attacks the %s with %d damage. The %s's health is now %d\n", opp.getName(), getName(), damage, getName(), getHealth());
  }

  @Override public String toString() 
  {
    String temp;
    temp = "an Oracle " +getName()+ " equipped with a "+getWeapon()+"! It has "+getHealth()+" health.\n";
    return temp;
  }
}

///////////////   Class Sorcerer    /////////////////
class Sorcerer extends Enemy 
{
  public Sorcerer() 
  {
    setName("Sorcerer");
    setHealth(60);
    setWeapon(1); //Magic Wand
  }
  
  @Override public void fight(Knight opp) 
  {
    int damage = opp.getWeaponDamage();

    try 
    {
      takeDamage(damage);
    }
    catch(InvalidDamageException e) 
    {
      setHealth(0);
    }

    System.out.printf("%s attacks the %s with %d damage. The %s's health is now %d\n", opp.getName(), getName(), damage, getName(), getHealth());
  }

  @Override public String toString() 
  {
    String temp;
    temp = "a mystical " +getName()+ " equipped with a "+getWeapon()+". It has "+getHealth()+" health.\n";
    return temp;
  }
}

///////////////   Class Wizard   /////////////////
class Wizard extends Enemy 
{
  public Wizard() 
  {
    setName("Wizard");
    setHealth(30);
    setWeapon(2);
  }

  @Override public void fight(Knight k) 
  {
    int damage = k.getWeaponDamage();

    try 
    {
      takeDamage(damage);
    }
    catch(InvalidDamageException e) 
    {
      setHealth(0);
    }

    System.out.printf("%s attacks the %s with %d damage. The %s's health is now %d\n", k.getName(), getName(), damage, getName(), getHealth());
  }

  @Override public String toString() 
  {
    String temp;
    temp = "a powerful " +getName()+ " equipped with a "+getWeapon()+". It has "+getHealth()+" health.\n";
    return temp;
  }
}