
import java.util.ArrayList;

	import java.util.Random;
	import java.util.Scanner;
public class testing {

	//Cache Angus
	//Student ID: 20000629
	//Assignment 2 code, I used my own previous code from Assignment 1
	

	

		//private int numberOfCandidateEntities = 5; // indicates how many candidates are in this game, this could also be
		ArrayList<Entity> entities = new ArrayList<Entity>();									// done using an array list
		//private static Entity[] entities;// holds these entities
		int sumTickets = 0;

		public testing() {

			entities.add(null);
			//numberOfCandidateEntities = 0;

		}
		

		public void addEntity(Entity entity) {										
			entities.add(entity);
			
		}

		public void addEntity(Person person) {
			Entity newentity = person.cloner();
			//entities.add(newentity);
			entities.add(person.cloner());
		}

		public void addEntity(Country country) {
			Entity temp = country.cloner();
			//entities.add(newentity);
			entities.add(country.cloner());
		}

		public void addEntity(Singer singer) {
			Entity newentity = singer.cloner();
			//entities.add(newentity);
			entities.add(singer.cloner());
		}

		public void addEntity(Politician politician) {
			Entity newentity = politician.cloner();
			//entities.add(newentity);
			entities.add(politician.cloner());
			
		}

		public void playGame(int entityInd) {
			// Entity guessing = entities.get(entityInd);
			Entity guessing = entities.get(entityInd);
			// System.out.println(guessing);
			playGame(guessing);
		}

		public void playGame(Entity entity) {

			Date birthdate = entity.born;
			String nameof = entity.name;

			entity.welcomeMessage();
			System.out.println("Type in the format of mm/dd/yyyy");

			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("quit")) {

				System.exit(10);
			} else {
				Date guess = new Date(input);

				if ((guess instanceof Date) && (guess != null))// check to see if it is a string and its not empty, should
																// probably check that its of the right format but how i may
																// ask
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

						// keep counter of tickets won, needs to be initialized at zero outside of this
						// game because otherwise it would return to 0 everytime the re-guessed
						sumTickets = entity.getAwardTicketNumber(entity) + sumTickets;
						int tickets = entity.getAwardTicketNumber(entity);
						System.out.println("*************************BINGO!************************\n You won " + tickets
								+ " tickets this round. \n ");
						System.out.println(" You've won " + sumTickets
								+ " tickets this game.\n******************************************************* \n");
						entity.closingMessage();

						playGame();

					}

					else {
						// then say its too late
						System.out.println("Too late, guess again!");
						playGame(entity); // i love recursion
					}

				}

			}
			{
				System.out.println("Invalid Input, guess again!"); // if its not a string like we asked for then we can't
																	// use it
				playGame(entity);// once again recursion is great
			}
		}

		public void playGame() {

			int number = getRandomEntityInd();
			playGame(number); // gets your numba and then puts it into the index version of playGame
		}

		int getRandomEntityInd() {
			Random random = new Random();

			int index = random.nextInt(entities.size() - 1); // after getting the number it makes sure that the index is
																// wihtin bounds

			return index;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub


			Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), "Male", "Liberal", 0.25);
			Singer dion = new Singer("Celine Dion", new Date("March", 30, 1968), "Female", "la voix du bon Dieu",
					new Date("November", 6, 1981), 0.5);
			Person myCreator = new Person("Cache Angus", new Date("December", 5, 1997), "Female", 1);
			Country usa = new Country("United States", new Date("July", 14, 1776), "Washington D.C.", 0.1); //

			testing gm = new testing();
			gm.addEntity(trudeau);
			gm.addEntity(dion);
			gm.addEntity(myCreator);
			gm.addEntity(usa);

			System.out.println("Time to Play Guess Master!");
			gm.playGame();

		}

	

}
