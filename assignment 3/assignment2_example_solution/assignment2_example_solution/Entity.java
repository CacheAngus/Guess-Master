package assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//Import the Button widget
//import android.view.View;
// android.widget.Button;
//import android.widget.TextView;
//import android.widget.EditText;

inport androi.content.Intent

public abstract class Entity extends AppCompatActivity {

	private String name;
	private Date born;
	private double difficulty;////

	public Entity(String name, Date birthDate) {
		this.name = name;
		this.born = new Date(birthDate); // no privacy leak
	}
	
	public Entity(String name, 
			Date birthDate, 
			double difficulty) {
		this(name, birthDate);
		this.difficulty = difficulty;
	}

	public Entity(Entity entity) {
		this.name = entity.name;
		this.born = new Date(entity.born); //no privacy leak
		this.difficulty = entity.difficulty;
	}

	public String getName() {
		return name;
	}

	public Date getBorn() {
		return new Date(born);
	}
	
	public Date getBornRange() {
		return new Date(born);
	}

//	public compBirthDate(String name, Date birthDate) {
//		this.name = name;
//		this.birthDate = new Date(birthDate); //no privacy leak
//	}
//	
//	public compBirthDate(String name, Date birthDate) {
//		this.name = name;
//		this.birthDay = new Date(birthDay); //no privacy leak
//	}
	
//	public abstract String welcomeMessage();

	public String welcomeMessage() {
		return "Welcome! Let�s start the game! "+entityType();
		
	}
	
	public String closingMessage() {
		return "Congratudations! The detailed information of "
				+ "the entity you guessed is:\n"+toString();
	}
	
	public abstract String entityType();

	public abstract Entity clone();

	public String toString() {
		return "Name: "+name+"\n"+"Born at: "+born.toString()+"\n";
	}

	public int getAwardedTicketNumber() {
		return (int)Math.round(difficulty*100);
	}
	
	
}
