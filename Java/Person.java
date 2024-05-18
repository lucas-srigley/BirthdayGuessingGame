/**
 * Name: Lucas Srigley
 * Student Number: 20289448
 */
package Date;

public class Person extends Entity {
	// instance variables
	private String gender;
	
	// create copy constructors
	public Person(String name, Date born, String gender, double difficulty) {
		super(name, born, difficulty);
		this.gender = gender;
	}
	public Person(Person otherPerson) {
		super(otherPerson);
		this.gender = otherPerson.gender;
	}
	public Entity clone() {
		return new Person(this);
	}
	public String toString() {
		return super.toString() + "Gender: " + getGender();
	}
	public String entityType() {
		return "person!";
	}
	
	// create accessors
	public String getGender() {
		return gender;
	}
	
	// create mutators
	public void setGender(String gender) {
		this.gender = gender;
	}
}
