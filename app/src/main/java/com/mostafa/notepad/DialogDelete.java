package com.mostafa.notepad;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class DialogDelete extends DialogFragment {
    Button btnyes, btnno;
    static String flag=" ";
    Activity activity;

    public DialogDelete(Activity activity){
        this.activity =activity;
    }
 @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.delete_dialog, container, false);

        btnyes = (Button) rootview.findViewById(R.id.btn_yes);
        btnno = (Button) rootview.findViewById(R.id.btn_no);
      sendflag();


        return rootview;
    }



    public void sendflag(){
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag="false";




            }
        });
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag="true";

            }
        });


    }
}

