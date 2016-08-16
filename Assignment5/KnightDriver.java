//Drew Smith
//COP3252
//Assingment 5
//March 2016

import java.util.*;

public class KnightDriver 
{
  private static Scanner in = new Scanner(System.in);
  private static Random rand = new Random();
  private static boolean gameState = true;
  private static boolean enterForest = false;
  private static String choice;

  //Main method
  public static void main(String[] args) 
  {
    while (gameState) 
    {
      System.out.printf("Welcome to Knight Walk!\n");
      Knight myKnight = createKnight();

      while(!enterForest) 
      {
        System.out.printf("\nAre you ready to travel through the JavaBean forest? (Y|N): ");
        choice = in.nextLine();
        choice = choice.toUpperCase();

        if(choice.compareTo("Y") == 0)
        {
            System.out.println(myKnight.getName()+ " has began to walk through the JavaBean forest...\n");
            enterForest = true;
        }

        else
        {
            System.out.println("Go prepare yourself for the challenge....\n\n");
            myKnight = createKnight();
        }
      }

      System.out.println(myKnight.toString());

      int numEnemies = 0;
      numEnemies = myKnight.getVisibleEnemies();
      Enemy enemies[] = new Enemy[numEnemies];

      if(numEnemies > 0) 
      {
        System.out.println(myKnight.getName()+ " has encountered " +numEnemies+ " enemies!\n");
        for(int i = 0; i < numEnemies; i++) 
          enemies[i] = Enemy.getRandomEnemy();

        for(int i = 0; i < numEnemies; i++) 
          enemies[i].toString();
        

        for(int i = 0; i < numEnemies; i++) 
        {
          System.out.printf("%s starts fighting %s.\n", myKnight.getName(), enemies[i].toString());
          int victor = knightFight(myKnight, enemies[i]);

          if(victor == 1) 
          {
              System.out.printf("Your knight has been defeated by %s...", enemies[i].getName());
              gameState = false;
              enterForest = false;
              break;
          }
          
          else
            System.out.printf("Your knight has defeated the %s!\n", enemies[i].getName());
        }
      }
        
      else 
      {
        System.out.printf("%s did not encounter any creatures while traveling through the forest!\n", myKnight.getName());
        enterForest = false;
        gameState = false;
      }

      System.out.println("Your knight has successfully made it through the forest!\n");
      System.out.printf("Would you like to travel through the JavaBean Forest again? (Y|N)");
      choice = in.nextLine();
      choice = choice.toUpperCase();

      if(choice.compareTo("Y") == 0)
        gameState = true;

      else
      {
        System.out.println("Thanks for playing Knight Walk!\n");
        gameState = false;
      }

    }
  }    

    public static int knightFight(Knight myKnight, Enemy e) 
    {
      int victor;
      boolean turn = true;
    
      while(myKnight.getHealth() > 0 && e.getHealth() > 0) 
      {
        if(turn) 
        {
          e.fight(myKnight);
          turn = false;
        }
        else 
        {
          myKnight.fight(e);
          turn = true;
        }
      }
    
      if (myKnight.getHealth() <= 0)
        victor = 1;
      else
        victor = 2;
    
      return victor;
    }

    public static Knight createKnight()
    {
      Scanner in = new Scanner(System.in);
      System.out.print("What is the name of your glorious Knight?: ");
      String name = in.nextLine();

      System.out.println("\nWhat weapon will "+name+" be using? (Choose a number)");
      System.out.println("0: Long Sword");
      System.out.println("1: Battle Axe");
      System.out.println("2: Spear");
      System.out.println("3: Warhammer");   
      System.out.print("Your choice my liege? ");
      int weapon = in.nextInt();

      System.out.println("\nWhat armor will "+name+" be using? (Choose a number)");
      System.out.println("0: Leather");
      System.out.println("1: Metal");
      System.out.print("Your choice my liege? ");
      int armor = in.nextInt();

      return new Knight(name, weapon, armor);
    }
}