package com.mostafa.notepad;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class newtext extends AppCompatActivity {

    private static EditText editText;
    ImageView bold , italic  ;
    boolean state_bold = true;
    boolean state_italic = true;
    txt txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_text);

        bold = (ImageView) findViewById(R.id.btn_1);
        italic = (ImageView) findViewById(R.id.btn_2);

        editText = (EditText) findViewById(R.id.tv);



        bold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state_bold){
                    if (!state_italic){
                        editText.setTypeface(null, Typeface.BOLD_ITALIC);
                        bold.setImageResource(R.drawable.bold2);
                        state_bold = false;
                    }else {
                        editText.setTypeface(null, Typeface.BOLD);
                        bold.setImageResource(R.drawable.bold2);
                        state_bold = false;
                    }
                }else if (!state_bold){
                    if (!state_italic){
                        editText.setTypeface(null, Typeface.ITALIC);
                        bold.setImageResource(R.drawable.bold1);
                        state_bold = true;
                    }else {
                        editText.setTypeface(null, Typeface.NORMAL);
                        bold.setImageResource(R.drawable.bold1);
                        state_bold = true;
                    }
                }

            }
        });
        italic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state_italic){
                    if (!state_bold){
                        editText.setTypeface(null, Typeface.BOLD_ITALIC);
                        italic.setImageResource(R.drawable.italic1);
                        state_italic = false;
                    }else {
                        editText.setTypeface(null, Typeface.ITALIC);
                        italic.setImageResource(R.drawable.italic1);
                        state_italic = false;
                    }
                }else if (!state_italic){
                    if (!state_bold){
                        editText.setTypeface(null, Typeface.BOLD);
                        italic.setImageResource(R.drawable.italic2);
                        state_italic = true;
                    }else {
                        editText.setTypeface(null, Typeface.NORMAL);
                        italic.setImageResource(R.drawable.italic2);
                        state_italic = true;
                    }
                }


            }
        });


    }

    public static String gettext(){
        Editable text = editText.getText();

        return text.toString();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Save").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(newtext.this, editText.getText(), Toast.LENGTH_SHORT).show();
                DialogSave dialogSave = new DialogSave();
                dialogSave.show(getSupportFragmentManager() , "save");

                return false;
            }
        }).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }
}
