package com.example.gosia.glucophone;

/**
 * Created by malgosia on 15.04.17.
 */
public class DodajPytanie {

    private int ID;
private String QUESTION;
private String ANSWER;
    private String ANSWER2;

        public DodajPytanie()
        {
            ID=0;
            QUESTION="";
            ANSWER="";
            ANSWER2="";
        }


        public DodajPytanie(String pytanie, String odpowiedz, String odpowiedz2) {

            QUESTION = pytanie;
            ANSWER = odpowiedz;
            ANSWER2 = odpowiedz2;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getQUESTION() {
            return QUESTION;
        }

        public void setQUESTION(String QUESTION) {
            this.QUESTION = QUESTION;
        }



        public String getANSWER() {
            return ANSWER;
        }

        public void setANSWER(String ANSWER) {
            this.ANSWER = ANSWER;
        }

    public String getANSWER2() {
        return ANSWER2;
    }

    public void setANSWER2(String ANSWER2) {
        this.ANSWER2 = ANSWER2;
    }
}