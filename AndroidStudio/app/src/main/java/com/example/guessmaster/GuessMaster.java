/**
 * Name: Lucas Srigley
 * Student Number: 20289448
 */
package com.example.guessmaster;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Random;

import android.content.DialogInterface;

public class GuessMaster extends AppCompatActivity {

    private TextView entityName;
    private TextView ticketsum;
    private Button guessButton;
    private EditText userIn;
    private Button btnclearContent;
    private String user_input;
    private ImageView entityImage;
    String input;

    private int numberOfCandidateEntities;
    private Entity[] entities;
    private Entity currentEntity;
    private int[] tickets;
    private int totalTickets;
    private double difficulty;
    //Stores Entity Name
    String entName;
    int entityInd = 0;
    int currentTicketWon = 0;

    // create constructor that initially defines instance variables
    public GuessMaster() {
        this.numberOfCandidateEntities = 0;
        this.entities = new Entity[10];
    }

    // create suggested methods

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
        return (int) (difficulty * 100);
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

    // create method to add new entity to entities
    public void addEntity(Entity entity) {
        entities[numberOfCandidateEntities] = entity.clone();
        numberOfCandidateEntities++;
    }

    // create method to play game with current entity
    public void playGame(Entity entity) {
        input = userIn.getText().toString();
        input = input.replace("\n", "").replace("\r", "");
        Date date = new Date(input);
        currentEntity = entity;

        if (date.precedes(entity.getBorn())) {
            AlertDialog.Builder alert1 = new AlertDialog.Builder(GuessMaster.this);
            alert1.setIcon(R.drawable.ic_error_outline_black_24dp);
            alert1.setTitle("Incorrect");
            alert1.setMessage("Try a later date");
            alert1.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog dialog = alert1.create();
            dialog.show();
        } else if (entity.getBorn().precedes(date)) {
            AlertDialog.Builder alert2 = new AlertDialog.Builder(GuessMaster.this);
            alert2.setIcon(R.drawable.ic_error_outline_black_24dp);
            alert2.setTitle("Incorrect");
            alert2.setMessage("Try an earlier date");
            alert2.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog dialog = alert2.create();
            dialog.show();
        } else {
            /*tickets[numOfTickets++] = entity.getAwardedTicketNumber();
            for(int i = 0; i < 100; i++){
                totalTickets = totalTickets + tickets[i];
            }*/
            // I haven't been able to get this to work so I calculated the tickets differently
            totalTickets = totalTickets + entity.getAwardedTicketNumber();
            ticketsum.setText("Total Tickets: " + totalTickets);

            AlertDialog.Builder alert3 = new AlertDialog.Builder(GuessMaster.this);
            alert3.setIcon(R.drawable.ic_check_circle_black_24dp);
            alert3.setTitle("You won");
            alert3.setMessage("BINGO! " + entity.closingMessage());
            alert3.setCancelable(false);
            alert3.setNegativeButton("CONTINUE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ContinueGame();
                }
            });
            AlertDialog dialog = alert3.create();
            dialog.show();
        }
    }

    // create method to play game with next entity
    public void playGame(int entityInd) {
        Entity entity = entities[entityInd];
        currentEntity = entity;
        playGame(entity);
    }

    // create method to play game with random entity index
    public void playGame() {
        // int ranInd = genRandomEntityInd();
        // when using ranInd instead of entityInd, it was messing up the entities
        playGame(entityInd);
    }

    // create helping method to generate random entity index for playGame() method
    public int genRandomEntityInd() {
        Random ranInd = new Random();
        return ranInd.nextInt(numberOfCandidateEntities);
    }

    Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), "Male", "Liberal", 0.25);
    Singer dion = new Singer("Celine Dion", new Date("March", 30, 1968), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
    Person myCreator = new Person("myCreator", new Date("September", 1, 2000), "Female", 1);
    Country usa = new Country("United States", new Date("July", 4, 1776), "Washington, D.C.", 0.1);

    // create changeEntity method
    public void changeEntity() {
        userIn.getText().clear();
        entityInd = genRandomEntityInd();
        currentEntity = entities[entityInd];
        entName = currentEntity.getName();
        ImageSetter(currentEntity);
        entityName.setText(entName);
    }

    // create ImageSetter method
    public void ImageSetter(Entity entity) {
        currentEntity = entity;
        if (entity.toString().equals(trudeau.toString())) {
            entityImage.setImageResource(R.drawable.justint);
        } else if (entity.toString().equals(dion.toString())) {
            entityImage.setImageResource(R.drawable.celidion);
        } else if (entity.toString().equals(myCreator.toString())) {
            entityImage.setImageResource(R.drawable.mycreator);
        } else if (entity.toString().equals(usa.toString())) {
            entityImage.setImageResource(R.drawable.usaflag);
        }
    }

    // create method welcomeToGame
    public void welcomeToGame(Entity entity) {
        AlertDialog.Builder welcomealert = new AlertDialog.Builder(GuessMaster.this);
        welcomealert.setTitle("GuessMaster Game v3");
        welcomealert.setMessage(entity.welcomeMessage());
        welcomealert.setCancelable(false);
        welcomealert.setNegativeButton("START GAME", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Game is starting... Enjoy", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = welcomealert.create();
        dialog.show();
    }

    // create method ContinueGame
    public void ContinueGame() {
        entityInd = genRandomEntityInd();
        Entity entity = entities[entityInd];
        entName = entity.getName();
        ImageSetter(entity);
        entityName.setText(entName);
        userIn.getText().clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_master);
        guessButton = (Button) findViewById(R.id.btnGuess);
        userIn = (EditText) findViewById(R.id.guessinput);
        ticketsum = (TextView) findViewById(R.id.ticket);
        entityName = (TextView) findViewById(R.id.entityName);
        entityImage = (ImageView) findViewById(R.id.entityImage);
        btnclearContent = (Button) findViewById(R.id.btnClear);

        final GuessMaster gm = new GuessMaster();
        addEntity(trudeau);
        addEntity(dion);
        addEntity(myCreator);
        addEntity(usa);
        changeEntity();
        welcomeToGame(currentEntity);

        btnclearContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEntity();
            }
        });

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame();
            }
        });
    }
}
