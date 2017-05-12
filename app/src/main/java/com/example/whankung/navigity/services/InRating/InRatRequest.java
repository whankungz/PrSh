package com.example.whankung.navigity.services.InRating;

/**
 * Created by macbookpro on 5/12/2017 AD.
 */

public class InRatRequest {
    private String ratingInfo;
    private String infoID;
    private String usernameInfo;

    public String getRatingInfo() {
        return ratingInfo;
    }

    public void setRatingInfo(String ratingInfo) {
        this.ratingInfo = ratingInfo;
    }

    public String getInfoID() {
        return infoID;
    }

    public void setInfoID(String infoID) {
        this.infoID = infoID;
    }

    public String getUsernameInfo() {
        return usernameInfo;
    }

    public void setUsernameInfo(String usernameInfo) {
        this.usernameInfo = usernameInfo;
    }
}
