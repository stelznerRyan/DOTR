package com.dogsontherun.pocketpupv2;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by Stelzy on 6/1/2015.
 */
@ParseClassName("service_WalkRun")
public class ServiceWalkingRunningPO extends ParseObject{

    public ServiceWalkingRunningPO() {

    }

    public Boolean getComplete() {
        return getBoolean("complete");
    }
    public void setComplete(Boolean complete) {
        put("complete", complete);
    }

    public String getOwnerEmail() {
        return getString("ownerEmail");
    }
    public void setOwnerEmail(String ownerEmail) {
        put("ownerEmail", ownerEmail);
    }

    public String getDogName() {
        return getString("dog_name");
    }
    public void setDogName(String dogName) {
        put("dog_name", dogName);
    }

    public String getSpeed() {
        return getString("speed");
    }
    public void setSpeed(String speed) {
        put("speed", speed);
    }

    public String getDuration() {
        return getString("duration_minutes");
    }
    public void setDuration(String duration_minutes) {
        put("duration_minutes", duration_minutes);
    }

    public Date getCreatedAt() {
        return getDate("createdAt");
    }
    public void setCreatedAt(Date createdAt) {
        put("createdAt", createdAt);
    }

    public Date getUpdatedAt() {
        return getDate("updatedAt");
    }
    public void setUpdatedAt(Date updatedAt) {
        put("updatedAt", updatedAt);
    }

}
