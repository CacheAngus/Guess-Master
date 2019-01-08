//Cache Angus
//Student Number: 20000629
public class Politician extends Person {
	protected String party;
	
	public Politician(Person person) {
		super(person);
		party = "";
		
	}
	
	public Politician(String newname, Date newdate, String newgender, String newparty, double d) {
		super(newname, newdate, newgender, d);
		party = newparty;
		
	
	}
	//copy constructor
public Politician(Politician newPolitician) {
		
		
		//check to make sure this won't create a privacy leak if not use format but go back and use the newCountry 
		this(newPolitician.getName(), newPolitician.getBirth(newPolitician.born), newPolitician.getGender(), newPolitician.getParty(), newPolitician.getDifficulty());
	}
	
	
	public String getParty() {
	
	return party;
}

	
	
	
	@Override
	String entityType() {
		return ("This entity is a politician!");
		
	}

	//clone method
	protected Entity cloner() {
		Entity newPolitician = new Politician(this);
		return newPolitician;
	}
	
	public String toString() {
		String og = super.toString();
		//check to make sure printString doesn't need to be returned
		if(party == null)  {
			return ("Not a valid entry!");
		} else {
		return (og +"\n Party:" +party);
		}
	}
}