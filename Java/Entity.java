/**
 * Name: Lucas Srigley
 * Student Number: 20289448
 */
package Date;

public abstract class Entity {
	// instance variables
	private double difficulty;
	private String name;
	private Date born;
	
	// create constructor that initially defines instance variables
	public Entity(String name, Date born, double difficulty) {
		this.name = name;
		this.born = born;
		this.difficulty = difficulty;
	}

	// create copy constructor that does not have a privacy leak issue
	public Entity(Entity otherEntity) {
		this(otherEntity.name, new Date(otherEntity.born), otherEntity.difficulty);
	}
	
	// create accessors
	public String getName() {
		return name;
	}
	public Date getBorn() {
		return new Date(born);
	}
	public double getDifficulty() {
		return difficulty;
	}
	
	// create mutators
	public void setName(String name) {
		this.name = name;
	}
	public void setBorn(Date born) {
		this.born = new Date(born);
	}
	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}
	
	// create toString method
	public String toString() {
		return "Name: " + name + "\n" + "Born at: " + born + "\n";
	}
	
	// create equals method
	public boolean equals(Entity entity) {
		if (entity == null)
			return false;
		else
			return (name == entity.getName() && born == entity.getBorn());
	}
	
	// create getAwardedTicketNumber
	public int getAwardedTicketNumber() {
		return (int)(difficulty * 100);
	}
	
	// declare abstract method entityType and clone
	public abstract String entityType();
	public abstract Entity clone();
	
	// define welcomeMessage/closingMessage methods
	public String welcomeMessage() {
		return "Welcome! Let’s start the game! This entity is a " + entityType();
	}
	public String closingMessage() {
		return "Congratulations! The detailed information of the entity you guess is: \n" + toString();
	}
}