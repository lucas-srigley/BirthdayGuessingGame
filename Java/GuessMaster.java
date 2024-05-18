/**
 * Name: Lucas Srigley
 * Student Number: 20289448
 */
package Date;

import java.util.Scanner;
import java.util.Random;

public class GuessMaster {
	// instance variables
	private int totalTickets;
	private double difficulty;
	private int numberOfCandidateEntities;
	private Entity[] entities;
	
	// create constructor that initially defines instance variables
	public GuessMaster() {
		this.numberOfCandidateEntities = 0;
		this.entities = new Entity[10];
	}

	// create accessors	
	public int getNumberOfCandidateEntities() {
		return numberOfCandidateEntities;
	}
	public Entity[] getEntities() {
		return entities;
	}
	public double getDifficulty() {
		return difficulty;
	}
	public int getAwardedTicketNumber() {
		return (int)(difficulty * 100);
	}
	public int getTotalTickets() {
		return totalTickets;
	}
	
	// create mutators
	public void setNumberOfCandidateEntities(int numberOfCandidateEntities) {
		this.numberOfCandidateEntities = numberOfCandidateEntities;
	}
	public void setEntities(Entity entities) {
		this.entities = new Entity[10];
	}
	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}

	// create suggested methods

	// create method to add new entity to entities
	public void addEntity(Entity entity) {
		entities[numberOfCandidateEntities] = entity.clone();
		numberOfCandidateEntities++;
	}

	// define welcomeMessage/closingMessage methods
	public String welcomeMessage() {
		return "***************************\nWelcome! Let’s start the game! This entity is a ";
	}
	public String closingMessage() {
		return "Congratulations! The detailed information of the entity you guessed is: \n";
	}
	
	// create method to play game with current entity
	public void playGame(Entity entity) {
		Scanner scan = new Scanner(System.in);
		System.out.println(welcomeMessage() + entity.entityType());
		System.out.println("\nGuess " + entity.getName() + "'s birthday\n(mm/dd/yyyy)");
		while (true) {
			String input = scan.nextLine();

			if (input.equalsIgnoreCase("quit")) {
				System.exit(0);
			}

			boolean precedesDate = entity.getBorn().precedes(new Date(input));

			if (entity.getBorn().equals(new Date(input))) {
				System.out.println("*************Bingo!***************");
				System.out.println("You won " + entity.getAwardedTicketNumber() + " tickets in this round.");
				totalTickets = getTotalTickets() + entity.getAwardedTicketNumber();
				System.out.println("The total number of your tickets is " + totalTickets + ".");
				System.out.println("**********************************");
				System.out.println(closingMessage() + entity.toString());
				playGame();
			} else if (precedesDate)
				System.out.println("Incorrect. Try an earlier date.");
			else
				System.out.println("Incorrect. Try a later date.");
		}
	}

	// create method to play game with next entity
	public void playGame(int entityInd) {
		Entity entity = entities[entityInd];
		entityInd++;
		playGame(entity);
	}

	// create method to play game with random entity index
	public void playGame() {
		int ranInd = genRandomEntityInd();
		playGame(ranInd);
	}

	// create helping method to generate random entity index for playGame() method
	public int genRandomEntityInd() {
		Random ranInd = new Random();
		return ranInd.nextInt(numberOfCandidateEntities);
	}

	// create main method to test game
	public static void main(String[] args) {
		System.out.println("=========================\n");
		System.out.println("     GuessMaster 2.0     \n");
		System.out.println("=========================\n");
		
		Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), "Male", "Liberal", 0.25);
		Singer dion = new Singer("Celine Dion", new Date("March", 30, 1968), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
		Person myCreator = new Person("myCreator", new Date("September", 1, 2000), "Female", 1);
		Country usa = new Country("United States", new Date("July", 4, 1776), "Washington, D.C.", 0.1);
		GuessMaster gm = new GuessMaster();
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(myCreator);
		gm.addEntity(usa);
		gm.playGame();
	}
}