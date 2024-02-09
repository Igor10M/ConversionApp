package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LengthConverse extends AppCompatActivity implements View.OnClickListener {

    EditText EditMeters,EditFeet,EditInch,EditNameLength;

    Button BtnConvertLength,BtnBacktoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenght_conversor);
        initialize();
    }

    private void initialize() {
        EditNameLength = findViewById(R.id.EditNameLength);
        EditMeters = findViewById(R.id.EditMeters);
        EditFeet = findViewById(R.id.EditFeet);
        EditInch = findViewById(R.id.EditInch);
        BtnBacktoMain = findViewById(R.id.BtnBacktoMain);
        BtnConvertLength = findViewById(R.id.BtnConvertLength);
        BtnConvertLength.setOnClickListener(this);
        BtnBacktoMain.setOnClickListener(this);
        String Name = getIntent().getStringExtra("name");
        EditNameLength.setText(Name);

    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.BtnConvertLength)
            calculateConversion();
        else if (id==R.id.BtnBacktoMain) {
            finish();
        }
        else
            ExecuteNull();

    }
    private void ExecuteNull(){

    }
    private void calculateConversion() {
        String meterString = EditMeters.getText().toString();
        try {
            double celsius = Double.parseDouble(meterString);
            double feet = celsius * 3.28084;
            double Inch = celsius * 39.3701;
            EditFeet.setText(String.valueOf(feet));
            EditInch.setText(String.valueOf(Inch));
        } catch (NumberFormatException e) {
            // Handle invalid input
            e.printStackTrace();
        }
    }

}