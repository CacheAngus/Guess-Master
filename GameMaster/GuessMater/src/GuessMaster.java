//Cache Angus
//Student ID: 20000629
import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class GuessMaster {

	private int numberOfCandidateEntities = 3; // indicates how many candidates are in this gaem
	private static Entity[] entities;// holds these entities
	// ArrayList<Entity> entities;

	public GuessMaster() {

		entities = new Entity[numberOfCandidateEntities];
		numberOfCandidateEntities = 0;
		// ArrayList<Entity> entities = new ArrayList<Entity>();

	}

	public void addEntity(Entity entity) {

		// entities.add(entity);
		entities[numberOfCandidateEntities] = entity;
		numberOfCandidateEntities++;

	}

	public void playGame(int entityInd) {
		// Entity guessing = entities.get(entityInd);
		Entity guessing = entities[entityInd];
		// System.out.println(guessing);
		playGame(guessing);
	}

	public void playGame(Entity entity) {
		Date birthdate = entity.born;
		String nameof = entity.name;

		System.out.println("Guess The Birthday of " +nameof);
		//entity.printString();
		System.out.println("\nType in the format of mm/dd/yyyy");

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		if (input.equalsIgnoreCase("quit")) {
			System.out.println("Thanks for Playing!");
			System.exit(10);
		} else {
			Date guess = new Date(input);

			if ((guess instanceof Date) && (guess != null))// check to see if it is a string and its not empty, should
														// probably check that its of the right format but how i may ask
			{
				// date is now set as a string and then setDate does its work
				// need to add:
				if (guess.precedes(birthdate)) // check this, if the date is too early then try again
				{
					System.out.println("Too early, guess again!");
					playGame(entity);
				} else if (guess.equals(birthdate)) {
					// check to see if their guess is equal to the entity.born
					// if it is then be like yo, you did it!
					String winner = entity.toString();
					System.out
							.println("Congratulations, you've guessed correct!\n " + winner + "\n You've won $10,000!");
					System.out.println("\n Type quit to exit or any other key to play again!");
					// String again = scanner.nextLine(); this next bit could be added so they press
					// enter to get the next person
					
					String start = scanner.nextLine();
					if(start.equalsIgnoreCase("quit")) {
						System.out.println("Thanks for Playing!");
						System.exit(10);
					}
					else {	// goes back and gets a new index and therefore a new person to test it on
						playGame();
					}
				}

				else {
					// then say its too late
					System.out.println("Too late, guess again!");
					playGame(entity); // i love recursion
				}

			}

		} {
			System.out.println("Invalid Input, guess again!"); // if its not a string like we asked for then we can't
																// use it
			playGame(entity);//once again recursion is great
		}

		// need to check that the input is equal to a string and then check that it is
		// equal to the entity already in place

	}
	
	public void playGame() {
		System.out.println("Time to Play Guess Master!"); 
		int number = getRandomEntityInd();
		playGame(number); //gets your numba and then puts it into the index version of playGame
	}

	int getRandomEntityInd() {
		Random random = new Random();
		
		int index = random.nextInt(entities.length - 1); //after getting the number it makes sure that the index is wihtin bounds

		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Scanner scanner = new Scanner(System.in);
		// String try = scanner.nextLine();

		Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
		Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
		Entity usa = new Entity("United States", new Date("July", 14, 1776));

		GuessMaster gm = new GuessMaster();
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(usa);

		// System.out.println(entities.size());

		gm.playGame();

	}

}
