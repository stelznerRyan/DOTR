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
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class Register extends ActionBarActivity {

    //Declaration of necessary UI items
    private Button mRegister;
    private EditText mName, mEmail, mPhone, mPass;
    private String ROLE_CLIENT = "client";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Instanciation of necessary UI items
        mRegister = (Button) findViewById(R.id.register_btn);
        mName = (EditText)findViewById(R.id.name_input);
        mEmail = (EditText)findViewById(R.id.email_input);
        mPhone = (EditText)findViewById(R.id.phone_input);
        mPass = (EditText)findViewById(R.id.password_input);

        //Register Button Listener
        mRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ParseUser.logOut();

                //creation of new string variables based on the text the user entered
                String name = mName.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String phone = mPhone.getText().toString().trim();
                String pass = mPass.getText().toString().trim();

                //Create the new user and login using parse
                ParseUser user = new ParseUser();
                user.setUsername(email);
                user.setPassword(pass);
                user.setEmail(email);
                user.put("name", name);
                user.put("phone", phone);
                user.put("role", ROLE_CLIENT);

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            // Sign up success
                            //Upon click changes activity to register
                            Intent goToAddHome = new Intent(Register.this, AddHomeAddress.class);
                            startActivity(goToAddHome);

                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                            Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
