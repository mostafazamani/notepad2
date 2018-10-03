package com.mostafa.notepad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class DialogSave extends DialogFragment implements View.OnClickListener {
    Button ok, cancel;
    private static EditText filename;
    Context context;

    Dbhelper dbhelper;

    txt txt;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.save_dialog, container, false);




        ok = (Button) view.findViewById(R.id.btn_ok);
        cancel = (Button) view.findViewById(R.id.btn_cancel);

        filename = (EditText) view.findViewById(R.id.tv_name);

        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.btn_ok :
                dbhelper = new Dbhelper(getContext());

                SQLiteDatabase sd = dbhelper.getWritableDatabase();
              txt = new txt();
                txt.setFilename(getname());
                txt.setText(newtext.gettext());
//                Toast.makeText(getContext(),sd.getPath() , Toast.LENGTH_SHORT).show();
                dbhelper.addtxt(txt);
               dismiss();
                getActivity().finish();
                break;
            case R.id.btn_cancel:

                dismiss();
                break;
            default:
                break;



        }


    }
    private static String getname(){
        Editable name = filename.getText();
        return name.toString();
    }
}