package com.example.daily_log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    dbHelper mydb;
    EditText etDate, etSalah,etrakat;
    CheckBox cbJamat,cbTahajud;
    Button btnSubmit, btnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDate=findViewById(R.id.datefld);
        etSalah=findViewById(R.id.salahfld);
        etrakat=findViewById(R.id.rakatfld);
        cbJamat=findViewById(R.id.jamtckbx);
        cbTahajud=findViewById(R.id.tahajudckbx);
        btnSubmit=findViewById(R.id.button);
        btnView=findViewById(R.id.button2);

        mydb=new dbHelper(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = etDate.getText().toString();
                String salah = etSalah.getText().toString();
                boolean isJammat = cbJamat.isChecked();
                String rakat = etrakat.getText().toString();
                boolean isTahajud = cbTahajud.isChecked();
                Student student = new Student(date, salah, isJammat,rakat,isTahajud);
                mydb.insertStudent(student);
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=mydb.getData();
                if(res==null)
                {
                    showMessage("Error","Nothing Found");
                    return;
                }
                else
                {
                    StringBuffer bf=new StringBuffer();
                    while(res.moveToNext())
                    {
                        bf.append("Date :"+res.getString(0)+" ");
                        bf.append("Salah :"+res.getString(1)+" ");
                        bf.append("Jammat :"+res.getString(2)+" ");
                        bf.append("Rakat :"+res.getString(3)+" ");
                        bf.append("Tahajud :"+res.getString(4)+"\n\n");

                    }
                    showMessage("Data",bf.toString());
                }

            }
        });

    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder bd=new AlertDialog.Builder(this);
        bd.setCancelable(true);
        bd.setTitle(title);
        bd.setMessage(message);
        bd.show();
    }
}