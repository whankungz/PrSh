package com.example.whankung.navigity.services.Herb;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Whankung on 13/3/2560.
 */

public class HRequest {

    private String herbName;
    private String herbOtherName;
    private String howto;
    private String warning;
    private String properties;
    private String herbIdRe;
    private String researchName;
    private String creditRe;
    private String researchID;

    public String getResearchID() {
        return researchID;
    }

    public void setResearchID(String researchID) {
        this.researchID = researchID;
    }

    public String getHerbName() {
        return herbName;
    }

    public void setHerbName(String herbName) {
        this.herbName = herbName;
    }

    public String getHerbOtherName() {
        return herbOtherName;
    }

    public void setHerbOtherName(String herbOtherName) {
        this.herbOtherName = herbOtherName;
    }

    public String getHowto() {
        return howto;
    }

    public void setHowto(String howto) {
        this.howto = howto;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getHerbIdRe() {
        return herbIdRe;
    }

    public void setHerbIdRe(String herbIdRe) {
        this.herbIdRe = herbIdRe;
    }

    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    public String getCreditRe() {
        return creditRe;
    }

    public void setCreditRe(String creditRe) {
        this.creditRe = creditRe;
    }




}
