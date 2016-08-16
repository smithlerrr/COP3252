//Drew Smith
//COP3252
//Assingment 4
//Feb. 28th, 2016

import java.util.*;

public class KnightDriver 
{  
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);

        Random rand = new Random();
        Knight myKnight = new Knight();
        Knight opponentKnight = new Knight();
        boolean gameState = true;

        while (gameState) 
        {
            System.out.println("\n\nWelcome to KnightFight!");

            myKnight = createKnight();

            System.out.print("\nWould you like to randomly generate an opponent? (Y/N): ");
            String playerChoice = in.nextLine();
            playerChoice = playerChoice.toUpperCase();

            if (playerChoice.compareTo("Y") == 0) 
            {
                System.out.println("\nGenerating a Random Opponent!\n");
                               
                try 
                {
                    Thread.sleep(5000);
                } 
                
                catch(InterruptedException ex) 
                {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Matchup:");
                opponentKnight = new Knight();
            } 

            else
            {  
                opponentKnight = createKnight();
            }

            System.out.println(myKnight.getName() + " VS. " + opponentKnight.getName());
        
            System.out.println("\n"+myKnight.toString()+"\n");
            System.out.println(opponentKnight.toString());
            
            System.out.print("Are you ready for FightKnight? (Y/N): ");
            String begin = in.nextLine();
            begin = begin.toUpperCase();

            if (begin.compareTo("Y") == 0) 
            {
                int round = 0;
                int damage = 0;
                System.out.println("\nRules:\nNo touching of the hair or face...\nAnd that's it!");
                while (myKnight.getHealth() >= 0 && opponentKnight.getHealth() >= 0) 
                {
                    try //used for delaying times between attacks
                    {
                        Thread.sleep(10000);
                    } 
                
                    catch(InterruptedException ex) 
                    {
                        Thread.currentThread().interrupt();
                    }

                    round++;
                    if (round % 2 == 0) 
                    {   
                        System.out.println("\nRound "+(round));
                        System.out.println(opponentKnight.getName()+" attacks!");
                        damage = Fight(opponentKnight, myKnight);
                        
                        System.out.println(opponentKnight.getName() + " dealt " +damage+ " damage!");
                        myKnight.setHealth(myKnight.getHealth() - damage);

                        if(myKnight.getHealth() < 0)
                            DeclareWinner(opponentKnight);

                        else
                        {
                            System.out.println(myKnight.getName()+" now has " +
                            myKnight.getHealth()+" health!");
                        }                   
                    } 

                    else 
                    {
                        System.out.println("\nRound "+(round));
                        System.out.println(myKnight.getName()+" attacks!");
                        damage = Fight(myKnight, opponentKnight);                       
                        
                        System.out.println(myKnight.getName() + " dealt " +damage+ " damage!");
                        opponentKnight.setHealth(opponentKnight.getHealth() - damage);

                        if(opponentKnight.getHealth() < 0)
                            DeclareWinner(myKnight);

                        else
                        {
                            System.out.println(opponentKnight.getName()+" now has " +
                            opponentKnight.getHealth()+" health!");
                        }                    
                    }

                }

                System.out.print("Would you like to play again? (Y/N): ");
                String reset = in.nextLine();
                reset = reset.toUpperCase();

                if (reset.compareTo("Y") == 0)
                {
                    gameState = true;
                    myKnight = new Knight();
                    opponentKnight = new Knight(); 
                }
                
                else
                {
                    System.out.println("\n\nCoward...");
                    gameState = false;
                }    
            } 
            
            else 
                System.out.println("\nCoward........Good bye.\n");
        }

    }

    public static Knight createKnight()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("What is the name of your glorious Knight?: ");
        String name = in.nextLine();

        System.out.printf("What weapon will "+name+" be using? (Choose a number)");
        System.out.println("\n0: Long Sword");
        System.out.println("1: Battle Axe");
        System.out.println("2: Spear");
        System.out.println("3: Warhammer");   
        System.out.println("Your choice my liege? ");
        int weapon = in.nextInt();

        return new Knight(name, weapon);
    }

    public static int Fight(Knight attacker, Knight defender) 
    {
        Random rand = new Random();
        int w = attacker.getIntWeapon();
        int a = defender.getIntArmor();
        int damage = 0;
        
        switch (w) 
        {
            //Long Sword
            case 0:
            {
                if(a == 0)//Leather
                    damage = rand.nextInt(20) + 10;     
                else if(a == 1)//Metal
                    damage = rand.nextInt(20) + 5;
                break;
            }
            //Battle Axe
            case 1:
            {
                if(a == 0)
                    damage = rand.nextInt(20) + 10;
                else if(a == 1)
                    damage = rand.nextInt(20) + 10;
                break;
            }

            //Spear
            case 2:
            {
                if(a == 0)
                    damage = rand.nextInt(20) + 10;
                else if(a == 1)
                    damage = rand.nextInt(20) + 5;
                break;
            }
            //War Hammar
            case 3:
            {
                if(a == 0)
                    damage = rand.nextInt(10) + 10;
                else if(a == 1)
                    damage = rand.nextInt(20) + 15;
                break;
            }       
        }
        return damage;
    }

    public static void DeclareWinner(Knight winner)
    {
        System.out.println("\n"+winner.getName()+" is the winner!!!");
    }

}
