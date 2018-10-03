package com.mostafa.notepad;


import android.content.ContentValues;
import android.database.Cursor;

public class txt {
    String filename ;
    String text;
    public static final String KEY_NAME="filetextname";
    public static final String KEY_TEXT="word";




    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return filename+"\n"+text;
    }

    public ContentValues getContentValues(){
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, getFilename());
        values.put(KEY_TEXT, getText());

        return values;
    }
    public static txt cursorTotext(Cursor cursor){
        txt mt = new txt();

        mt.setFilename(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
        mt.setText(cursor.getString(cursor.getColumnIndex(KEY_TEXT)));
        return mt;
    }


}
