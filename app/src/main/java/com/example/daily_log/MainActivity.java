package com.example.daily_log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
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
    }
}