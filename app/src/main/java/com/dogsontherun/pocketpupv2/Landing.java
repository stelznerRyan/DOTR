package com.dogsontherun.pocketpupv2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Landing extends ActionBarActivity {

    //Declaration of necessary UI items
    private Button mLogin;
    private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        //Instanciation of necessary UI items
        mLogin = (Button) findViewById(R.id.login_btn);
        mRegister= (Button) findViewById(R.id.register_btn);

        //Login Button Listener
        mLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Upon click, changes activity to login
                Intent goToLogin = new Intent(Landing.this, Login.class);
                startActivity(goToLogin);
            }
        });

        //Register Button Listener
        mRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Upon click changes activity to register
                Intent goToRegister = new Intent(Landing.this, Register.class);
                startActivity(goToRegister);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_landing, menu);
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