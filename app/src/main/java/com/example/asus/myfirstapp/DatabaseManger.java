package com.example.asus.myfirstapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Asus on 26/04/2017.
 */

public class DatabaseManger extends SQLiteOpenHelper {
    public DatabaseManger(Context context)
    {
      super(context,"task.db",null , 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    String query = "create table Person ( ID  INTEGER PRIMARY KEY AUTOINCREMENT ," +
            " username text ," +
            " password text ," +
            " fname text , " +
            "lname text ," +
            " course1 text , " +
            "course2 text , " +
            "course3 text ," +
            " course4 text )" ;

    db.execSQL(query) ;



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + "Person");
        onCreate(db);
    }

    public ArrayList<Person> getPersons ()
    {
        ArrayList<Person> persons  = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Person " ;
        Cursor cursor = db.rawQuery(query , null) ;
        if(cursor.moveToFirst())
        {
            do{
                Person per = new Person() ;
                per.id =cursor.getInt(0);
                per.username = cursor.getString(1);
                per.password = cursor.getString(2);
                per.firstname = cursor.getString(3);
                per.lastname = cursor.getString(4) ;
                per.corse1 = cursor.getString(5);
                per.corse2 = cursor.getString(6);
                per.corse3 = cursor.getString(7);
                per.corse4 = cursor.getString(8);
                persons.add(per);

            }while (cursor.moveToNext());

        }



        return  persons ;
    }

    // to insert indormation of person first time "register"
    public void insert (Person person)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " INSERT INTO Person (username , password ,fname , lname , course1 , course2  , course3 , course4) " +
                       " VALUES('" +person.username + "' ,' " + person.password + " ' , ' " +person.firstname+ " ' , ' " + person.lastname +
                       " '  , ' Java ' ,' C++ ' , ' PL1 ' ,  ' cs ' ) " ;
        db.execSQL(query);
        db.close();
    }



    public void update (Person person )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UDATE Person set" +
                        "username = '"+ person.username +" ' " +
                        "password = ' " + person.password + " '" +
                        " course1 = ' " + person.corse1+ "'" +
                       "course2 = ' " + person.corse2+ "'" +
                        "course3 = ' " + person.corse3+ "'" +
                        "course4 = ' " + person.corse4+ "'" +
                        " where ID = " +person.id + ";" ;
        db.execSQL(query);
        db.close();


    }
}
