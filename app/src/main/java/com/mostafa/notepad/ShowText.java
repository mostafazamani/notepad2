package com.mostafa.notepad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowText extends AppCompatActivity {
    ListView lv;
    Dbhelper db;
    List<txt> txtList;
    AdapterList adapterList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text);
        db = new Dbhelper(this);
        lv = (ListView) findViewById(R.id.listview);
        //txtList = db.getAlltext();
        //  Toast.makeText(this, name.toString(), Toast.LENGTH_SHORT).show();
       // refreshDisplay();
    }
    private void refreshDisplay(){
        if(txtList == null) txtList = new ArrayList<>();
        adapterList = new AdapterList(this, txtList);
        lv.setAdapter(adapterList);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("show").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
              txtList = db.getAlltext();
             refreshDisplay();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }








}
