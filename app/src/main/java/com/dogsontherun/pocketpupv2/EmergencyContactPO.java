package com.dogsontherun.pocketpupv2;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;


/**
 * Created by Stelzy on 4/28/2015.
 */
@ParseClassName("EmergencyContactPO")
public class EmergencyContactPO extends ParseObject {

    public EmergencyContactPO() {
    }

    public ParseUser getClient() {
        return getParseUser("client");
    }
    public void setClient(ParseUser user) {
        put("client", user);
    }

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        put("name", name);
    }

    public String getEmail() {
        return getString("email");
    }

    public void setEmail(String email) {
        put("email", email);
    }

    public String getPhone() {
        return getString("phone");
    }

    public void setPhone(String phone) {
        put("phone", phone);
    }

    public String getSpareKey() {
        return getString("spareKey");
    }

    public void setSpareKey(String spareKey) {
        put("spareKey", spareKey);
    }

    public String getInstructions() {
        return getString("instructions");
    }

    public void setInstructions(String instructions) {
        put("instructions", instructions);
    }
}
