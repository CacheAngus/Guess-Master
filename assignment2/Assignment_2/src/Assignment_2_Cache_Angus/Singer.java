//Cache Angus
//Student Number 20000629
public class Singer extends Person {
	protected String debutAlbum;
	protected Date debutAlbumReleaseDate;
	
	public Singer(Person person) {
		super(person);
		debutAlbum = "";
		debutAlbumReleaseDate = new Date();
	}
	
	public Singer(String newname, Date newdate, String newgender, String newdebut, Date newdebutdate, double d) {
		super(newname, newdate, newgender, d);
		debutAlbum = newdebut;
		debutAlbumReleaseDate = newdebutdate;
	
	}
	//copy constructor
public Singer(Singer newSinger) {
		
		
		//check to make sure this won't create a privacy leak if not use format but go back and use the newCountry.born thing
		this(newSinger.getName(), newSinger.getBirth(newSinger.born), newSinger.getGender(), newSinger.getDebutAlbum(), newSinger.getDebutAlbumRelease(newSinger.debutAlbumReleaseDate), newSinger.getDifficulty());
	}
	
	public Date getDebutAlbumRelease(Date newDate) {
	return new Date(newDate);
}

	public String getDebutAlbum() {
	
	return debutAlbum;
}

	
	@Override
	String entityType() {
		return ("This entity is a singer!");
		
	}

	//clone method
	protected Entity cloner() {
		Entity newSinger = new Singer(this);
		return newSinger;
	}
	
	public String toString() {
		String og = super.toString();
		//check to make sure printString doesn't need to be returned
		if((debutAlbum == null) || (debutAlbumReleaseDate == null)) {
			return ("Not a valid entry!");
		} else {
		return (og +"\n Debut Album:" +debutAlbum +"\n Debut Album Release Date:" +debutAlbumReleaseDate);
		}
	}
}