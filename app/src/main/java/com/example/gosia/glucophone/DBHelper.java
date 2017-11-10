package com.example.gosia.glucophone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malgosia on 15.04.17.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 6;
    // Database Name
    private static final String DATABASE_NAME = "wyniki_pomiaru_cukru";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_ANSWER2 = "answer2"; //correct

    private SQLiteDatabase dbase;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, " + KEY_ANSWER2 +" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }






    private void addQuestions()
    {
        DodajPytanie q1=new DodajPytanie("20160415","1315" ,"98");
        this.addQuestion(q1);

        DodajPytanie q2 = new DodajPytanie("20170113","1012" ,"100");
        this.addQuestion(q2);

        DodajPytanie q3=new DodajPytanie("20170222","2258", "89");
        this.addQuestion(q3);

        DodajPytanie q4 = new DodajPytanie("20170412","1809", "136");
        this.addQuestion(q4);




    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(DodajPytanie quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_ANSWER2, quest.getANSWER2());


        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<DodajPytanie> getAllQuestions() {
        List<DodajPytanie> quesList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) do {
            DodajPytanie quest = new DodajPytanie();
            quest.setID(cursor.getInt(0));
            quest.setQUESTION(cursor.getString(1));
            quest.setANSWER(cursor.getString(2));
            quest.setANSWER2(cursor.getString(3));

            quesList.add(quest);
        } while (cursor.moveToNext());
        // return quest list
        return quesList;
        //test
    }

}
