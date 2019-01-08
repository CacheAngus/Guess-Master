

public class Entity {
	protected String name;
    protected Date born;
	
	public Entity() //nice default constructor
	{
		name = "Cache Angus";
		born = new Date();
		
	}
	
	public Entity(String newname, Date newdate) { //initializes an entity with these features
		name = newname;
		born = newdate;
		}
	
	public String setName(String newName) { //gives it a name
		this.name = newName;
		return name;
	}
	
	public Date setBirth(Date newDate) { //gives it a date without changing the value
		return new Date(newDate);
	}

	public void printString() { //writes the string out
	
		if (born == null) {
			System.out.println("Not Valid");
		}
		
		System.out.println(born);
	}
	public String toString(){ //this returns the content for string
		
		String bornString;
		
		if(born == null) {
			return "Invalid date";
		}
		else {		
		bornString = born.toString();
		
		return (name + ", born on" + bornString);
		}
	
	}
//look into editing these
	public boolean equals(Entity entity) { //checks to see if they are equal dates
		if(entity.born ==  null) {
			return false;
		}
		else {
		return (born.equals(entity.born));
		}
	}

	public boolean precede(Entity entity) { //checks if the date preceded the guessed date
		return (entity.born.precedes(born));
			
	}	
}