/**
 * Name: Lucas Srigley
 * Student Number: 20289448
 */
package Date;

public class Country extends Entity {
	// instance variables
	private String capital;
	
	// create copy constructors
	public Country(String name, Date born, String capital, double difficulty) {
		super(name, born, difficulty);
		this.capital = capital;
	}
	public Country(Country otherCountry) {
		super(otherCountry);
		this.capital = otherCountry.capital;
	}
	public Entity clone() {
		return new Country(this);
	}
	public String toString() {
		return super.toString() + "Capital: " + getCapital();
	}
	public String entityType() {
		return "country!";
	}
	
	// create accessors
	public String getCapital() {
		return capital;
	}
	
	// create mutators
	public void setCapital(String capital) {
		this.capital = capital;
	}
}
