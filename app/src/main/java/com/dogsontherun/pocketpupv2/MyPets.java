package com.dogsontherun.pocketpupv2;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class MyPets extends ListActivity {

    protected List<ParseObject> mPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pets);

        ParseUser currentUser = ParseUser.getCurrentUser();

        //show the list of the current user's pets
        ParseQuery<ParseObject> query = ParseQuery.getQuery("PetPO");
        query.whereEqualTo("ownerEmail", currentUser.getEmail());
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> petList, ParseException e) {
                if (e == null) {
                    //success

                    mPets = petList;
                    MyPetAdapter adapter = new MyPetAdapter(getListView().getContext(), mPets);
                    setListAdapter(adapter);

                    Log.d("score", "Retrieved " + petList.size() + " scores");
                } else {
                    //there was a problem, alert user
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_pets, menu);
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
