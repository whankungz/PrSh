package com.example.whankung.navigity.services.Disease;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by Whankung on 21/2/2560.
 */

public class DRequest {
    private String diseaseName;
    private String herb;
    private String Symptom;
    private String howtoRelief;

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getHerb() {
        return herb;
    }

    public void setHerb(String herb) {
        this.herb = herb;
    }

    public String getSymptom() {
        return Symptom;
    }

    public void setSymptom(String symptom) {
        Symptom = symptom;
    }

    public String getHowtoRelief() {
        return howtoRelief;
    }

    public void setHowtoRelief(String howtoRelief) {
        this.howtoRelief = howtoRelief;
    }
}
