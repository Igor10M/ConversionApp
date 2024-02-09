package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TemperatureConverse extends AppCompatActivity implements View.OnClickListener {

    EditText EditTemperatureCelsius,EditNameTemperature,EditTemperatureKelvin, EditTemperatureFahrenheit;

    Button BtnConvert,BtnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura_conversor);
        initialize();
        /*Name();*/
    }

    private void initialize(){
        EditNameTemperature = findViewById(R.id.EditNameTemperature);
        EditTemperatureCelsius = findViewById(R.id.EditTemperatureCelsius);
        EditTemperatureFahrenheit = findViewById(R.id.EditTemperatureFarenheit);
        EditTemperatureKelvin = findViewById(R.id.EditTemperatureKelvin);
        BtnConvert = findViewById(R.id.BtnConvert);
        BtnReturn = findViewById(R.id.BtnReturnToMain);
        BtnConvert.setOnClickListener(this);
        BtnReturn.setOnClickListener(this);
        String Name = getIntent().getStringExtra("name");
        EditNameTemperature.setText(Name);

    }

    /*private void Name(){
        EditNameTemperature.setText(String.valueOf(EditName));
    }
    */

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.BtnConvert)
            calculateConversion();
        else if(id == R.id.BtnReturnToMain){
            finish();
        }

        else
            ExecuteNull();
    }
    private void ExecuteNull(){

    }
    private void calculateConversion() {
        String temperatureString = EditTemperatureCelsius.getText().toString();
        try {
            double celsius = Double.parseDouble(temperatureString);
            double kelvin = celsius + 273.15;
            double fahrenheit = celsius * 9 / 5 + 32;
            EditTemperatureKelvin.setText(String.valueOf(kelvin));
            EditTemperatureFahrenheit.setText(String.valueOf(fahrenheit));
        } catch (NumberFormatException e) {
            // Handle invalid input
            e.printStackTrace();
        }
    }


}