package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextAmount = findViewById(R.id.editTextAmount);
        Button buttonConvert = findViewById(R.id.buttonConvert);
        TextView textViewResult = findViewById(R.id.textViewResult);


        List<String> data = new ArrayList<>();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);


        Spinner spinner = findViewById(R.id.planets_spinner);

        String[] devises = {"EURO", "USD", "AED", "CAD", "SAUDI RIYAL"};
        SpinnerAdapter spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, devises);

        spinner.setAdapter(spinnerAdapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO a toast if nothing is given ! an alert

//                if(editTextAmount.getText().toString() == null){
//                    //Toast.makeText(MainActivity.this, "Not valid!", Toast.LENGTH_SHORT).show();
//                    textViewResult.setText("What the hell!");
//                }

                double amount = Double.parseDouble(editTextAmount.getText().toString());
                String devise = spinner.getSelectedItem().toString();

                double result = 0;


                if(devise.equals("RUPEE")){
                    result = amount / 10.67;
                    data.add(amount + " EURO = " + String.format("%.2f", result));
                } else if(devise.equals("USD")){
                    result = amount / 80.00;
                    data.add(amount + " USD = " + String.format("%.2f", result));
                } else if(devise.equals("AED")){
                    result = amount / 21.75;
                    data.add(amount + " AED = " + String.format("%.2f", result));
                    //String.format("%.2f", result)
                } else if(devise.equals("CAD")){
                    result = amount / 61.81;
                    data.add(amount + " CAD = " + String.format("%.2f", result));
                } else {
                    result = amount / 21.27;
                    data.add(amount + " SAUDI  RIYAL = " + String.format("%.2f", result));
                }


                textViewResult.setText(String.format("%.2f", result));
                // Notify the listView by the model (Adapter) that there is a change: listView will refresh itself.
                stringArrayAdapter.notifyDataSetChanged(); //informal value
                editTextAmount.setText("");
            }
        });

        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.removeAll(data);
                stringArrayAdapter.notifyDataSetChanged();
            }
        });

    }
}