//assignment 2

public abstract class Entity {
	protected String name;
	protected Date born;
	protected double difficulty;

	public Entity() // nice default constructor
	{
		name = "Cache Angus";
		born = new Date();
		difficulty = 0.0;

	}

	public Entity(String newname, Date newdate, double newdifficulty) { // initializes an entity with these features
		name = newname;
		born = newdate;
		difficulty = newdifficulty;
	}

	public Entity(Entity entity) { // we are a copy constructor community
		this.name = entity.getName();
		this.born = entity.getBirth(entity.born);
		this.difficulty = entity.getDifficulty();
	}

	abstract String entityType();
	// will return a string, returns a short description about the type of class

	abstract Entity cloner();// abstract Entity cloner() to be used in the other classes to copy them into the entity array
	//its called cloner so it returns entity and not object class							

	public void welcomeMessage() {
		String type = entityType();
		System.out.println("Welcome! Let's Start the Game! " + type + "\n");
	}

	public void closingMessage() { // potentially make (entity) so that getAwardTicketNumber can be used, fix get
									// award ticket number
		String guessed = toString();
		System.out.println("Congratulations! The detailed information of the entity you guessed is:" + guessed
				+ "\n************************************\n");

	}

	public int getAwardTicketNumber(Entity entity) {
		return (int)(entity.getDifficulty()*100);
		
	}

	public String getName() { // gives it a name
		return name;
	}

	public Date getBirth(Date newDate) { // gives it a date without changing the value
		return new Date(newDate);
	}

	public double getDifficulty() {
		return difficulty;
	}

	

	public String toString() { // this returns the content for string

		String bornString;

		if ((born == null) || (difficulty < 0) || (difficulty > 1)) {
			return "Invalid entry";
		} else {
			bornString = born.toString();

			return ("\n Name:" + name + "\n Born on:" + bornString);
		}

	}

	// look into editing these
	public boolean equals(Entity entity) { // checks to see if they are equal dates
		if (entity.born == null) {
			return false;
		} else {
			return (born.equals(entity.born));
		}
	}

	public boolean precede(Entity entity) { // checks if the date preceded the guessed date
		return (entity.born.precedes(born));

	}
}