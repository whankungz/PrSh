package com.example.whankung.navigity.services.Hcomment;

/**
 * Created by macbookpro on 5/12/2017 AD.
 */

public class CRequest {
    private String herbComment;
    private String usernameHerbCom;
    private String dateHerbCom;
    private String herbIdCom;
    public String getHerbIdCom() {
        return herbIdCom;
    }

    public String getUsernameHerbCom() {
        return usernameHerbCom;
    }

    public void setUsernameHerbCom(String usernameHerbCom) {
        this.usernameHerbCom = usernameHerbCom;
    }

    public void setHerbIdCom(String herbIdCom) {
        this.herbIdCom = herbIdCom;
    }



    public String getHerbComment() {
        return herbComment;
    }

    public void setHerbComment(String herbComment) {
        this.herbComment = herbComment;
    }




    public String getDateHerbCom() {
        return dateHerbCom;
    }

    public void setDateHerbCom(String dateHerbCom) {
        this.dateHerbCom = dateHerbCom;
    }


}
