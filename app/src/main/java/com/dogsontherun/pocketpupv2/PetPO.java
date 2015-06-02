package com.dogsontherun.pocketpupv2;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("PetPO")
public class PetPO extends ParseObject{

    public PetPO() {
    }

    public String getOwnerEmail() {
        return getString("ownerEmail");
    }
    public void setOwnerEmail(String ownerEmail) {
        put("ownerEmail", ownerEmail);
    }

    public String getName() {
        return getString("name");
    }
    public void setName(String name) {
        put("name", name);
    }

    public String getBreed() {
        return getString("breed");
    }
    public void setBreed(String breed) {
        put("breed", breed);
    }

    public String getPersonality() {
        return getString("personality");
    }
    public void setPersonality(String personality) {
       put("personality", personality);
    }

    public String getMedication() {
        return getString("medication");
    }
    public void setMedication(String medication) {
        put("medication", medication);
    }

    public String getFeedingInstructions() {
        return getString("feedingInstructions");
    }
    public void setFeedingInstructions(String feedingInstructions) {
        put("feedingInstructions", feedingInstructions);
    }
    public String getType() {
        return getString("type");
    }
    public void setType(String type){
        put("type", type);
    }
    public String getLeashLocation() {
        return getString("leashLocation");
    }
    public void setLeashLocation(String leashLocation) {
        put("leashLocation", leashLocation);
    }

    public String getSpecialNotes() {
        return getString("specialNotes");
    }
    public void setSpecialNotes(String specialNotes) {
        put("specialNotes", specialNotes);
    }
}


