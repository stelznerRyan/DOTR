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

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class Login extends ActionBarActivity {

    //Declaration of necessary UI items
    private Button mLogin;
    private Button mRegister;
    private EditText mUsername;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Instanciation of necessary UI items
        mLogin = (Button) findViewById(R.id.login_btn);
        mRegister= (Button) findViewById(R.id.register_btn);
        mUsername = (EditText) findViewById(R.id.login_user);
        mPassword = (EditText) findViewById(R.id.login_pass);

        //Login Button Listener
        mLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String attempted_username = mUsername.getText().toString().trim();
                String attempted_pass = mPassword.getText().toString().trim();

                ParseUser.logInInBackground(attempted_username, attempted_pass, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            // Hooray! The user is logged in.
                            //Upon click, changes activity to login
                            Intent goToLogin = new Intent(Login.this, Home.class);
                            startActivity(goToLogin);
                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                            Toast.makeText(Login.this, "Login Failed - Wrong Credentials", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        //Register Button Listener
        mRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Upon click changes activity to register
                Intent goToRegister = new Intent(Login.this, Register.class);
                startActivity(goToRegister);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
