package com.dogsontherun.pocketpupv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;



public class AddEmergencyContact extends ActionBarActivity {

    private EditText mName, mEmail, mPhone, mSpare, mInstructions;
    private EmergencyContactPO emergencyContactPO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emergency_contact);

        //Instantiation of necessary UI items
        Button add_btn;
        add_btn = (Button) findViewById(R.id.ec_add_btn);
        Button skip;
        skip = (Button) findViewById(R.id.skip_btn);
        mName = (EditText) findViewById(R.id.ec_name);
        mEmail = (EditText) findViewById(R.id.ec_email);
        mPhone = (EditText) findViewById(R.id.ec_phone);
        mSpare = (EditText) findViewById(R.id.ec_spare);
        mInstructions = (EditText) findViewById(R.id.ec_instructions);

        //DEBUGGING -
        //Toast.makeText(AddHomeAddress.this, user.getEmail(), Toast.LENGTH_LONG).show();

        //Skip Button Listener
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddEmergencyContact.this, "Remember, you can always your emergency contact later!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddEmergencyContact.this, AddPet.class);
                startActivity(intent);
            }
        });

        //Add Emergency Contact Button Listener
        add_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                emergencyContactPO = new EmergencyContactPO();

                //instantiating string objects to hold the values retrieved from the text fields
                String name = mName.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String phone = mPhone.getText().toString().trim();
                String spare = mSpare.getText().toString().trim();
                String instructions = mInstructions.getText().toString().trim();

                emergencyContactPO.setClient(ParseUser.getCurrentUser());
                emergencyContactPO.setName(name);
                emergencyContactPO.setEmail(email);
                emergencyContactPO.setPhone(phone);
                emergencyContactPO.setSpareKey(spare);
                emergencyContactPO.setInstructions(instructions);

                emergencyContactPO.saveEventually(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(AddEmergencyContact.this, "Emergency Contact Saved", Toast.LENGTH_LONG).show();
                            Intent goToBilling = new Intent(AddEmergencyContact.this, AddBillingInfo.class);
                            startActivity(goToBilling);
                        } else {
                            Toast.makeText(AddEmergencyContact.this, "Emergency Contact Failed to Save", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_emergency_contact, menu);
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
