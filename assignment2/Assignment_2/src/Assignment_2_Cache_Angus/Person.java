//Cache Angus
//Student Number: 20000629
public class Person extends Entity {
	protected String gender;
	
	public Person (Entity entity) {
		super(entity);
		gender = "";
	}
	
	public Person(String newname, Date newdate,  String newgender, double newdifficulty) {
		super(newname, newdate, newdifficulty);
		gender = newgender;
	}
	
	public Person(Person newPerson) {
		
		
		//check to make sure this won't create a privacy leak if not use format but go back and use the newCountry.born thing
		this(newPerson.getName(), newPerson.getBirth(newPerson.born),  newPerson.getGender(), newPerson.getDifficulty());
	}
	
	public String getGender() {
		return gender;
	}
	@Override
	String entityType() {
		return ("This entity is a person!");
		
	}

	
	
	public String toString() {
		String og = super.toString();
		//check to make sure printString doesn't need to be returned
		if(gender == null) {
			return ("Not a Person!");
		} else {
		return (og +"\n Gender:"+gender);
		}
	}

	
	

	@Override
	Entity cloner() {
		Entity newPerson = new Person(this);
		return newPerson;
	}

	
	

}
