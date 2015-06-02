package com.dogsontherun.pocketpupv2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;


/** ----------------------------NOTES FOR COMPLETION --------------
 * make sure you add a bool method to make sure only one of the radioGroups
 * has a checked button at a time
 */
public class ServiceWalkingRunning extends ActionBarActivity {
    protected Button submitRequest;

    //creates a strings to determine which speed the dog will be walked or run
    //   as well as the duration of the wlk or run
    //   changes the string depending on which radioG was clicked last
    public String speed = "";
    public String duration = "30 minutes";
    public String emailBody = "DOGS ON THE RUN - SERVICE REQUEST: \n";
    public String addToEmail = "Service Details: \n"; // for appending dynamic text to email

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_walking_running);

        //creates a parseobject adapter object
        final ServiceWalkingRunningPO service = new ServiceWalkingRunningPO();
        //pulls data from current user
        final ParseUser current = ParseUser.getCurrentUser();


        //adds listeners to both radio groups
        addListenerToRadioGroupW();
        addListenerToRadioGroupR();

        submitRequest = (Button) findViewById(R.id.service_request_btn);
        submitRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                service.setOwnerEmail(current.getEmail().toString());
                service.setComplete(false);
                service.setDogName("Dog's Name - still to be set");
                service.setSpeed(speed);

                emailBody += ("VIP Name: " + current.getString("name") + "\n");
                emailBody += ("VIP Email: "+ current.getEmail().toString() + "\n");
                emailBody += ("Phone: " + current.getString("phone") +"\n");
                emailBody += addToEmail;

                service.saveEventually(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(ServiceWalkingRunning.this, "Service Requested!", Toast.LENGTH_LONG).show();
                            //sends email to admin
                            sendEmail();

                            //takes you to the confirmation page
                            Intent intent = new Intent(ServiceWalkingRunning.this, ServiceRequestConfirmation.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(ServiceWalkingRunning.this, "Service Failed to Save", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }

    private void addListenerToRadioGroupW() {

        RadioGroup walkTime_rg = (RadioGroup) findViewById(R.id.walk_radioGroup);

        walkTime_rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = (RadioButton) findViewById(checkedId);
                speed = "walk"; // sets speed to walk
                duration = rb.getText().toString();// sets duration of walk

                addToEmail += ("Walk Time: " + rb.getText().toString() + "\n");
                Toast.makeText(ServiceWalkingRunning.this, "Walk Time: " + rb.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void addListenerToRadioGroupR() {

        RadioGroup runTime_rg = (RadioGroup) findViewById(R.id.run_radioGroup);

        runTime_rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = (RadioButton)findViewById(checkedId);
                speed = "run"; // sets speed to run
                duration = rb.getText().toString();// sets duration of run

                addToEmail = ("Run Time: " + rb.getText().toString() + "\n");
                Toast.makeText(ServiceWalkingRunning.this, "Run time: "+rb.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendEmail() {
        String to = "stelzner.ryan@gmail.com";
        String subject = ("DOTR Serivce Request - Walk/Run");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_service_walking_running, menu);
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
