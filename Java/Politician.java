/**
 * Name: Lucas Srigley
 * Student Number: 20289448
 */
package Date;

public class Politician extends Person {
	// create instance variables
	private String party;
	
	// create copy constructors
	public Politician(String name, Date born, String gender, String party, double difficulty) {
		super(name, born, gender, difficulty);
		this.party = party;
	}
	public Politician(Politician otherPolitician) {
		super(otherPolitician);
		this.party = otherPolitician.party;
	}
	public Entity clone() {
		return new Politician(this);
	}
	public String toString() {
		return super.toString() + "\nParty: " + getParty();
	}
	public String entityType() {
		return "politician!";
	}
	
	// create accessors
	public String getParty() {
		return party;
	}
	
	// create mutators
	public void setParty(String party) {
		this.party = party;
	}
}
