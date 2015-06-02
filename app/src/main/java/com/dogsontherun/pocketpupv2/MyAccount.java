package com.dogsontherun.pocketpupv2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class MyAccount extends ActionBarActivity {

    private TextView user_name, user_email, user_phone;
    private ParseObject basic_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
/*
        user_name = (TextView) findViewById(R.id.acc_name);
        user_email = (TextView) findViewById(R.id.acc_email);
        user_phone = (TextView) findViewById(R.id.acc_phone);


        /*------------------------------------------------
        --------------------------------------------------
        ------------MOVE SEGMENT OF CODE WITHIN-----------
        ----------------BLOCK COMMENTS AND----------------
        ----------------CREATE A CLASS W/ MVC-------------

        ParseUser currentUser = ParseUser.getCurrentUser();

        user_name.setText(" : " + currentUser.getString("name"));
        user_email.setText(" : " + currentUser.getEmail());
        user_phone.setText(" : " + currentUser.getString("phone"));

        ParseQuery<ParseObject> query = ParseQuery.getQuery("HomeAddressPO");
        query.whereEqualTo("client", currentUser);

        /*------------------------------------------------
        --------------------------------------------------
        ------------MOVE SEGMENT OF CODE WITHIN-----------
        ----------------BLOCK COMMENTS AND----------------
        ----------------CREATE A CLASS W/ MVC-------------
        */

    

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_my_account, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;

            case R.id.action_home:
                Intent goHome = new Intent(MyAccount.this, Home.class);
                startActivity(goHome);
                return true;

            case R.id.action_my_account:
                Intent goToMyAccount = new Intent(MyAccount.this, MyAccount.class);
                startActivity(goToMyAccount);
                return true;

            case R.id.action_sign_in:
                Intent goSignIn = new Intent(MyAccount.this, Login.class);
                startActivity(goSignIn);
                return true;

            case R.id.action_log_out:
                ParseUser userTemp = new ParseUser();

                if(!user_is_null(userTemp.getCurrentUser())) {
                    ParseUser.logOutInBackground(new LogOutCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {//if e is null then no exceptions were thrown
                                Toast.makeText(MyAccount.this, "You are now logged out.", Toast.LENGTH_LONG).show();
                                Intent goToLanding = new Intent(MyAccount.this, Landing.class);
                                startActivity(goToLanding);
                            } else {
                                Toast.makeText(MyAccount.this, "No User Logged In", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean user_is_null(ParseUser parseUser) throws NullPointerException {
        try {
            ParseUser user = ParseUser.getCurrentUser();
            return false;
        } catch (NullPointerException e) {
            Toast.makeText(MyAccount.this, e.getMessage(), Toast.LENGTH_LONG).show();
            return true;
        }
    }
}
