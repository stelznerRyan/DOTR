package com.dogsontherun.pocketpupv2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class AddPet extends ActionBarActivity {

    private Button mAddAnotherPet;
    private Button mDoneAddingPets;
    private PetPO petPO;
    private EditText mName, mBreed, mPersonality, mMedication, mFeedingInstructions, mLeashLocation, mSpecialNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        //Instanciation of necessary UI items
        mAddAnotherPet = (Button) findViewById(R.id.add_another_pet_btn);
        mDoneAddingPets = (Button) findViewById(R.id.done_adding_pets_btn);
        mName = (EditText) findViewById(R.id.pet_name_input);
        mBreed = (EditText) findViewById(R.id.pet_breed_input);
        mPersonality = (EditText) findViewById(R.id.pet_personality_input);
        mMedication = (EditText) findViewById(R.id.pet_medication_input);
        mFeedingInstructions = (EditText) findViewById(R.id.pet_feeding_input);
        mLeashLocation = (EditText) findViewById(R.id.pet_leash_input);
        mSpecialNotes = (EditText) findViewById(R.id.pet_notes_input);


        //Add Another Pet Button Listener
        mAddAnotherPet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //instantiating string objects to hold the values retrieved from the text fields
                String name = mName.getText().toString().trim();
                String breed = mBreed.getText().toString().trim();
                String personality = mPersonality.getText().toString().trim();
                String medication = mMedication.getText().toString().trim();
                String feeding = mFeedingInstructions.getText().toString().trim();
                String leash = mLeashLocation.getText().toString().trim();
                String notes = mSpecialNotes.getText().toString().trim();

                //instantiates object of type custom ParseObject, PetPO
                petPO = new PetPO();

                //use ParseObject methods to populate petPO
                ParseUser current = ParseUser.getCurrentUser();
                petPO.setOwnerEmail(current.getEmail());
                petPO.setName(name);
                petPO.setBreed(breed);
                petPO.setPersonality(personality);
                petPO.setMedication(medication);
                petPO.setFeedingInstructions(feeding);
                petPO.setLeashLocation(leash);
                petPO.setSpecialNotes(notes);

                petPO.saveEventually(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(AddPet.this, "Pet Saved and Ready for Another!", Toast.LENGTH_LONG).show();
                            //Upon click (if saved correctly and add another pet is clicked), refreshes activity data
                            Intent goToAddPet = new Intent(AddPet.this, AddPet.class);
                            startActivity(goToAddPet);
                        } else {
                            Toast.makeText(AddPet.this, "Pet Failed to Save", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        //Done Adding Pets Button Listener
        mDoneAddingPets.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                //instantiating string objects to hold the values retrieved from the text fields
                String ownerEmail = ParseUser.getCurrentUser().getEmail();
                String name = mName.getText().toString().trim();
                String breed = mBreed.getText().toString().trim();
                String personality = mPersonality.getText().toString().trim();
                String medication = mMedication.getText().toString().trim();
                String feeding = mFeedingInstructions.getText().toString().trim();
                String leash = mLeashLocation.getText().toString().trim();
                String notes = mSpecialNotes.getText().toString().trim();

                petPO = new PetPO();

                //use ParseObject methods to populate petPO
                petPO.setOwnerEmail(ownerEmail);
                petPO.setName(name);
                petPO.setBreed(breed);
                petPO.setPersonality(personality);
                petPO.setMedication(medication);
                petPO.setFeedingInstructions(feeding);
                petPO.setLeashLocation(leash);
                petPO.setSpecialNotes(notes);

                petPO.saveEventually(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(AddPet.this, "Pet Saved", Toast.LENGTH_LONG).show();
                            //Upon click (if saved correctly and done is clicked), changes activity to home page
                            Intent goToHome = new Intent(AddPet.this, Home.class);
                            startActivity(goToHome);
                        } else {
                            Toast.makeText(AddPet.this, "Pet Failed to Save", Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_pet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}




