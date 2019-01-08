package assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//Import the Button widget
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import org.w3c.dom.Text;

public class Country extends Entity{

	private TextView country_dob;
	private String capital;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(android.R.layout.activity_country);

		country_dob = (TextView) findViewById(R.id.condob);

		//accessing the data passed through intent
		String condob = getIntent().getStringExtra("USER_IN_DOB");

		//set content of the text view
		country_dob.setText(condob);

	public Country(String name, Date birthDate) {
		super(name, birthDate);
	}
	
	public Country(String name, 
			Date birthDate, 
			String capital, 
			double difficulty) {
		super(name, birthDate, difficulty);
		this.capital = capital;
	}
	
	public Country(Country country) {
		super(country);
		this.capital = country.capital;
	}
	
	public String entityType() {
		return "This entity is a country!";
	}
	
	public String toString() {
		return super.toString() + "Capital:" + capital +"\n";
	}
	
//	public String welcomeMessage() {
//		return "Welcome! Let�s start the game! "+entityType();
//	}

//	public String toString() {
//		return aaa;
//	}
	
	public Country clone() {
		return new Country(this);
	}

}
