package com.mostafa.notepad;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Dbhelper extends SQLiteOpenHelper {
    DialogSave ds;
    newtext nt;
    txt op;

    Context context;

    private static final String DBname = "notepade";
    private static final String TB_NAME = "tb_note";

    private static final String CMD = "CREATE TABLE " + TB_NAME + " ("
            + txt.KEY_NAME + " TEXT, "
            + txt.KEY_TEXT + " TEXT" +
            ");";





    public Dbhelper(Context context){
        super(context, DBname, null, 1);
        this.context=context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CMD);
        Toast.makeText(context, "created", Toast.LENGTH_SHORT).show();
        Log.i("ff", "created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF NOT EXISTS "+TB_NAME);
        onCreate(db);

    }
    public void addtxt(txt text){
        SQLiteDatabase sd = this.getWritableDatabase();
        long insertId = sd.insert(this.TB_NAME, null, text.getContentValues());

        if (insertId==-1) {
            Log.i("ff", "data insertion failed. (item : " + text.toString() + ")");
            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();

        } else{
            Log.i("ff", "data inserted with id : " + insertId);
            Toast.makeText(context, "added:"+text.toString(), Toast.LENGTH_SHORT).show();

        }

        if(sd.isOpen())sd.close();
    }


    public List<txt> getAlltext(){
        SQLiteDatabase db = getReadableDatabase();
        List<txt> txtList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TB_NAME , null);


        if(cursor.moveToFirst()){
            do{
                // process for each row
                txt mt = new txt();

                mt.setFilename(cursor.getString(cursor.getColumnIndex(txt.KEY_NAME)));
                mt.setText(cursor.getString(cursor.getColumnIndex(txt.KEY_TEXT)));
                txtList.add(mt);
            }while(cursor.moveToNext());
        }
        cursor.close();
        if(db.isOpen()) db.close();
        return txtList;
    }


}

