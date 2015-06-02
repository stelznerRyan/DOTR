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

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class AddHomeAddress extends ActionBarActivity {

    private EditText mAddress, mCity, mState, mZip;
    private HomeAddressPO homeAddressPO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_home_address);

        //Instantiation of necessary UI items
        Button confirm;
        confirm = (Button) findViewById(R.id.confirm_btn);
        Button skip;
        skip = (Button) findViewById(R.id.skip_btn);
        mAddress = (EditText) findViewById(R.id.home_address_input);
        mCity = (EditText) findViewById(R.id.home_city_input);
        mState = (EditText) findViewById(R.id.home_state_input);
        mZip = (EditText) findViewById(R.id.home_zip_input);

        //Skip Button Listener
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddHomeAddress.this, "Don't worry, you can always your home address later!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddHomeAddress.this, AddEmergencyContact.class);
                startActivity(intent);
            }
        });

        //Confirm Button Listener
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                homeAddressPO = new HomeAddressPO();

                //instantiating string objects to hold the values retrieved from the text fields
                String address = mAddress.getText().toString().trim();
                String city = mCity.getText().toString().trim();
                String state = mState.getText().toString().trim();
                String zipString = mZip.getText().toString().trim();
                int zip = Integer.parseInt(zipString);

                homeAddressPO.setClient(ParseUser.getCurrentUser());
                homeAddressPO.setAddress(address);
                homeAddressPO.setCity(city);
                homeAddressPO.setState(state);
                homeAddressPO.setZip(zip);

                homeAddressPO.saveEventually(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(AddHomeAddress.this, "Home Address Saved", Toast.LENGTH_LONG).show();
                            finish();
                            Intent intent = new Intent(AddHomeAddress.this, AddEmergencyContact.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(AddHomeAddress.this, "Home Address Failed to Save", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_home_adress, menu);
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
