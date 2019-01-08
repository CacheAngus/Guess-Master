//Cache Angus
//Student Number 20000629
public class Country extends Entity {
	protected String capital;
	
	public Country (Entity entity) {
		super(entity);
		capital = "";
	}
	
	public Country (String newname, Date newdate, String newcapital, double newdifficulty) {
		super(newname, newdate, newdifficulty);
		capital = newcapital;
	}
	//copy constructor
	public Country(Country newCountry) {
		//check to make sure this won't create a privacy leak if not use format but go back and use the newCountry.born thing
		this(newCountry.getName(), newCountry.getBirth(newCountry.born),newCountry.getCapital(), newCountry.getDifficulty());
	}
	public String getCapital() {
		return capital;
	}
	
	@Override
	String entityType() {
		return ("This entity is a country!");
		
	}

	
	
	public String toString() {
		String og = super.toString();
		
		return (og + "\n Capital:"+capital);
		
	}

	
	

	@Override
	Entity cloner() {
		Entity newCountry = new Country(this);
		return newCountry;
	}

	
	
	

}
