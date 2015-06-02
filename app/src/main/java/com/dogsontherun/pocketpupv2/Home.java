package com.dogsontherun.pocketpupv2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;


public class Home extends ActionBarActivity {

    final ParseUser previousUser = ParseUser.getCurrentUser();
    private Button requestService;
    private Button walking_service_btn;
    private Button vacation_service_btn;
    private Button fieldtrip_service_btn;
    private Button taxi_service_btn;
    private Button boarding_service_btn;
    private Button daycare_service_btn;
    private TextView service_description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Instantiation of necessary UI items
        requestService = (Button) findViewById(R.id.requestServiceBtn);
        walking_service_btn = (Button) findViewById(R.id.walking_serv_btn);
        vacation_service_btn = (Button) findViewById(R.id.vacation_serv_btn);
        fieldtrip_service_btn = (Button) findViewById(R.id.fieldtrip_serv_btn);
        taxi_service_btn = (Button) findViewById(R.id.taxi_serv_btn);
        boarding_service_btn = (Button) findViewById(R.id.boarding_serv_btn);
        daycare_service_btn = (Button) findViewById(R.id.daycare_serv_btn);
        service_description = (TextView) findViewById(R.id.service_description_textview);

        //for setting alpha upon click



        walking_service_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                walking_service_btn.setAlpha(Float.parseFloat("1.0")); // sets alpha off

                vacation_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                fieldtrip_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                taxi_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                boarding_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                daycare_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more

                service_description.setText("Dog Walking & Running Services: description");
            }
        });
        vacation_service_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vacation_service_btn.setAlpha(Float.parseFloat("1.0")); // sets alpha off

                walking_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                fieldtrip_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                taxi_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                boarding_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                daycare_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more

                service_description.setText("Vacation & Travel Care Services: description");
            }
        });
        fieldtrip_service_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldtrip_service_btn.setAlpha(Float.parseFloat("1.0")); // sets alpha off

                walking_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                vacation_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                taxi_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                boarding_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                daycare_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more

                service_description.setText("Field Trips Service: description");
            }
        });
        taxi_service_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taxi_service_btn.setAlpha(Float.parseFloat("1.0")); // sets alpha off

                walking_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                vacation_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                fieldtrip_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                boarding_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                daycare_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more

                service_description.setText("Pet Taxi Service:  description");
            }
        });
        boarding_service_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boarding_service_btn.setAlpha(Float.parseFloat("1.0")); // sets alpha off

                walking_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                vacation_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                fieldtrip_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                taxi_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                daycare_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more

                service_description.setText("Boarding Service: description");
            }
        });
        daycare_service_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daycare_service_btn.setAlpha(Float.parseFloat("1.0")); // sets alpha off

                walking_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                vacation_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                fieldtrip_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                taxi_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more
                boarding_service_btn.setAlpha(Float.parseFloat(".5")); // sets alpha to 30% more

                service_description.setText("Daycare Service: description");
            }
        });


        //Request Service Button Listener------------------------------------------------------
        //For users that have more than one pet, display the PetSelection page------------------
        requestService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ServiceWalkingRunning.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;

            case R.id.action_home:
                Intent goHome = new Intent(Home.this, Home.class);
                startActivity(goHome);
                return true;

            case R.id.action_my_pets:
                Intent goMyPets = new Intent(Home.this, MyPets.class);
                startActivity(goMyPets);
                return true;

            case R.id.action_my_account:
                Intent goToMyAccount = new Intent(Home.this, MyAccount.class);
                startActivity(goToMyAccount);
                return true;

            case R.id.action_sign_in:
                Intent goSignIn = new Intent(Home.this, Home.class);
                startActivity(goSignIn);
                return true;

            case R.id.action_log_out:
                ParseUser.logOut(); //.logOutInBackground(new LogOutCallback() { if .logOut() doesn't work
                Toast.makeText(Home.this, "You are now logged off.", Toast.LENGTH_LONG).show();
                Intent goToLanding = new Intent(Home.this, Landing.class);
                startActivity(goToLanding);
                //     } else{
                //         Toast.makeText(Home.this, "You are now logged off.", Toast.LENGTH_LONG).show();
                //     }
                // }
                //});
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
