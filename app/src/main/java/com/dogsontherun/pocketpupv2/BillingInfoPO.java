package com.dogsontherun.pocketpupv2;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by Stelzy on 4/28/2015.
 */
@ParseClassName("BillingInfoPO")
public class BillingInfoPO extends ParseObject {

    public BillingInfoPO() {
    }

    public ParseUser getClient() {
        return getParseUser("client");
    }

    public void setClient(ParseUser user) {
        put("client", user);
    }

    public String getAddress() {
        return getString("address");
    }

    public void setAddress(String address) {
        put("address", address);
    }

    public String getCity() {
        return getString("city");
    }

    public void setCity(String city) {
        put("city", city);
    }

    public String getState() {
        return getString("state");
    }

    public void setState(String state) {
        put("state", state);
    }

    public int getZip() {
        return getInt("zip");
    }

    public void setZip(int zip) {
        put("zip", zip);
    }

    public String getCardHolder() {
        return getString("cardHolder");
    }

    public void setCardholder(String cardholder) {
        put("cardHolder", cardholder);
    }

    public String getCardNum() {
        return getString("cardNum");
    }

    public void setCardNum(String cardNum) {
        put("cardNum", cardNum);
    }

    public int getCSV() {
        return getInt("csv");
    }

    public void setCSV(int csv) {
        put("csv", csv);
    }

    public String getExpMonth() {
        return getString("expMonth");
    }

    public void setExpMonth(String expMonth) {
        put("expMonth", expMonth);
    }

    public String getExpYear() {
        return getString("expYear");
    }

    public void setExpYear(String expYear) {
        put("expYear", expYear);
    }
}
