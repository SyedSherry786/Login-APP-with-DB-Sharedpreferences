package com.example.syeds.assignment02task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Syeds on 1/16/2017.
 */

public class Database extends SQLiteOpenHelper {


    public static final String DataBase_NAme = "LoginDBpractice.db";
    public static final String Table = "LoginTbl";

    public static final String Col1 = "Username";
    public static final String Col2 = "Password";
   // SQLiteDatabase db;

    String un="Syed";
    String pass="Sherry";

    public Database(Context context) {
        super(context,DataBase_NAme, null, 1);


    }
    //private static final String TableCreate="Create table LoginTbl(id integer primary key," +" Username text not null,Password text not null";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  "
                + Table+ "(" + Col1
                + " text, " + Col2
                + " text" +")");

    }

     public  void insertData(){
       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put(Col1 , un );
        CV.put(Col2 , pass);
        db.insert(Table , null , CV);
        db.close();
    }
    public String matchAuthentication(String uname){
     SQLiteDatabase   db=this.getReadableDatabase();

        Cursor cur = db.rawQuery("select * from " + Table , null );

        String a,b;
        b="Not Found";

        if (cur.moveToFirst()){
            do {
                a=cur.getString(0);
                if(a.equals(uname)){
                    b=cur.getString(1);
                    break;

                }
            }while (cur.moveToNext());

        }

        return b;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop Table if exists " + Table);
        onCreate(db);

    }
}
