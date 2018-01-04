package com.example.gosia.glucophone;

/**
 * Created by malgosia on 15.04.17.
 */
public class DodajPytanie {

    private int ID;
    private String QUESTION;
    private String ANSWER;
    private String ANSWER2;

    DodajPytanie() {
        ID = 0;
        QUESTION = "";
        ANSWER = "";
        ANSWER2 = "";
    }


    DodajPytanie(String pytanie, String odpowiedz, String odpowiedz2) {

        QUESTION = pytanie;
        ANSWER = odpowiedz;
        ANSWER2 = odpowiedz2;
    }

    public int getID() {
        return ID;
    }

    void setID(int ID) {
        this.ID = ID;
    }

    String getQUESTION() {
        return QUESTION;
    }

    void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }


    String getANSWER() {
        return ANSWER;
    }

    void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }

    String getANSWER2() {
        return ANSWER2;
    }

    void setANSWER2(String ANSWER2) {
        this.ANSWER2 = ANSWER2;
    }
}