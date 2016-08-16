import java.util.Scanner;

public class Assignment2
{
	public static void main(String [] args)
	{
		String name;
		int health;
		int numBattles;
		int age;
		int gold;
	
		Scanner in = new Scanner(System.in);

		System.out.printf("Enter the name of your glorious Knight!%n");
		name = in.nextLine();

		System.out.printf("How much health does %s have?%n", name);
		health = in.nextInt();

		System.out.printf("How many battles has %s won?%n", name);
		numBattles = in.nextInt();

		System.out.printf("What is the age of %s?%n", name);
		age = in.nextInt();

		System.out.printf("How much gold has %s pillaged?%n", name);
		gold = in.nextInt();

		System.out.println("\nHere is your new knight!\n");

		System.out.printf("Knight Name: %s%n", name); 
		System.out.printf("Knight Health: %d%n", health); 
		System.out.printf("Knight Battles: %d%n", numBattles); 
		System.out.printf("Knight Age: %d%n", age); 
		System.out.printf("Knight Gold: $%d%n", gold);
		System.out.println("\n");
	}
}	