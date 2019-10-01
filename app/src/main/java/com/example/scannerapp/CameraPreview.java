package com.example.scannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CameraPreview extends AppCompatActivity {

    final Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog date;
    EditText dateField;
    EditText idField;
    int x,y,z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_preview);

        //setup all the fields
        Spinner typeSpinner = findViewById(R.id.typeSpinner);
        idField = findViewById(R.id.idField);
        dateField = findViewById(R.id.dateField);
        Button calendarBtn = findViewById(R.id.calendarBtn);
        Spinner supplierSpinner = findViewById(R.id.supplierSpinner);
        Button submitBtn = findViewById(R.id.submitBtn);

        x = myCalendar.get(Calendar.YEAR);
        y = myCalendar.get(Calendar.MONTH);
        z = myCalendar.get(Calendar.DAY_OF_MONTH);
        String[] types = {"Invoice","Receipt"};
        String[] supplier = {"Company A","Company B","Company C"};

        //setup spinner values
//        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                //to do when selected
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                //to do when nothing is selected
//            }
//        });
        ArrayAdapter typeAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,types);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        ArrayAdapter supplierAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,supplier);
        supplierAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        supplierSpinner.setAdapter(supplierAdapter);

        //setup OnClickListener for Buttons
        calendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date = new DatePickerDialog(CameraPreview.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        dateField.setText(day+"/"+month+"/"+year);
                    }
                },x,y,z);
                date.show();
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
