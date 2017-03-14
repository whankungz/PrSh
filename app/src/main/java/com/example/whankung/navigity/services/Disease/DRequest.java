package com.example.whankung.navigity.services.Disease;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by Whankung on 21/2/2560.
 */

public class DRequest {
    private String diseaseName;
    private String herb;
    //private String Symptom;
    private String symptom;
    private String howtoRelief;
    private String diseaseID;

    public String getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(String diseaseID) {
        this.diseaseID = diseaseID;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getHerb() {
        return herb;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public void setHerb(String herb) {

        this.herb = herb;
    }


    public String getHowtoRelief() {
        return howtoRelief;
    }

    public void setHowtoRelief(String howtoRelief) {
        this.howtoRelief = howtoRelief;
    }
}
