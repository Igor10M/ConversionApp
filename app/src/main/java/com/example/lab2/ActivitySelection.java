package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class ActivitySelection extends AppCompatActivity implements View.OnClickListener {

    EditText EditGuestNum, EditNameActivity;

    RadioButton RbQuit,RbLength,RbTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        initialize();
    }

    private void initialize() {
        EditNameActivity = findViewById(R.id.EditNameActivity);
        EditGuestNum = findViewById(R.id.EditGuestNum);
        RbLength = findViewById(R.id.RbLength);
        RbLength.setOnClickListener(this);
        RbQuit = findViewById(R.id.RbQuit);
        RbQuit.setOnClickListener(this);
        RbTemperature = findViewById(R.id.RbTemperature);
        RbTemperature.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.RbTemperature) {
            ExecuteTemperatureConversor();
        } else if (id == R.id.RbLength) {
            ExecuteLengthConversor();
        } else {
            finish();
        }
    }

    private void ExecuteTemperatureConversor(){

        String Name = EditNameActivity.getText().toString();

        Intent intent = new Intent(this,TemperatureConverse.class);

        intent.putExtra("name",Name);
        startActivity(intent);
    }
    private void ExecuteLengthConversor(){
        String Name = EditNameActivity.getText().toString();

        Intent intent = new Intent(this, LengthConverse.class);

        intent.putExtra("name",Name);
        startActivity(intent);
    }
}