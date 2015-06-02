package com.dogsontherun.pocketpupv2;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by Stelzy on 4/28/2015.
 */
@ParseClassName("HomeAddressPO")
public class HomeAddressPO extends ParseObject {

    public HomeAddressPO() {
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
}
