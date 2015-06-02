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
import com.parse.SaveCallback;


public class AddBillingInfo extends ActionBarActivity {

    //Declaration of necessary UI items
    private Button mConfirmBilling;
    private EditText mAddress, mCity, mState, mZip, mCardHolder, mCardNum, mCSV, mExpMonth, mExpYear;
    private BillingInfoPO billingInfoPO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_billing_info);

        //Instantiation of necessary UI items
        Button skip;
        skip = (Button) findViewById(R.id.skip_btn);
        mConfirmBilling = (Button) findViewById(R.id.billing_btn);
        mAddress = (EditText) findViewById(R.id.bill_address_input);
        mCity = (EditText) findViewById(R.id.bill_city_input);
        mState = (EditText) findViewById(R.id.bill_state_input);
        mZip = (EditText) findViewById(R.id.bill_zip_input);
        mCardHolder = (EditText) findViewById(R.id.bill_name_input);
        mCardNum = (EditText) findViewById(R.id.bill_card_input);
        mCSV = (EditText) findViewById(R.id.bill_csv_input);
        mExpMonth = (EditText) findViewById(R.id.bill_exp_month_input);
        mExpYear = (EditText) findViewById(R.id.bill_exp_year_input);


        //Skip Button Listener
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddBillingInfo.this, "Go ahead and check out the app! You can always your billing info when you request your first service!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddBillingInfo.this, AddPet.class);
                startActivity(intent);
            }
        });

        //Confirm Billing Button Listener
        mConfirmBilling.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                billingInfoPO = new BillingInfoPO();

                //instantiating string objects to hold the values retrieved from the text fields
                String address = mAddress.getText().toString().trim();
                String city = mCity.getText().toString().trim();
                String state = mState.getText().toString().trim();
                int zip = Integer.parseInt(mZip.getText().toString().trim());
                String cardHolder = mCardHolder.getText().toString().trim();
                String cardNum = mCardNum.getText().toString().trim();
                int csv = Integer.parseInt(mCSV.getText().toString().trim());
                String expMonth = mExpMonth.getText().toString().trim();
                String expYear = mExpYear.getText().toString().trim();

                billingInfoPO.setClient(ParseUser.getCurrentUser());
                billingInfoPO.setAddress(address);
                billingInfoPO.setCity(city);
                billingInfoPO.setState(state);
                billingInfoPO.setZip(zip);
                billingInfoPO.setCardholder(cardHolder);
                billingInfoPO.setCardNum(cardNum);
                billingInfoPO.setCSV(csv);
                billingInfoPO.setExpMonth(expMonth);
                billingInfoPO.setExpYear(expYear);

                billingInfoPO.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(AddBillingInfo.this, "Billing Info Saved", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(AddBillingInfo.this, AddPet.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(AddBillingInfo.this, "Billing Info Failed to Save", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_billing_info, menu);
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
