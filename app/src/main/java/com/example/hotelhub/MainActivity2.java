package com.example.hotelhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private float precoQuarto = 8;

    private float padrao = 0;

    private float precoCafe = 2;

    private float precoAlmoco = 3;

    private float precoJanta = 3;

    private float precoQuartoDeluxe = 10;

    private float precoQuartoPresidencial = 12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public float getAmountToPurchise (View view){
        float cashAmount;
        try {
            EditText inputValue = findViewById(R.id.valorID);
            cashAmount = Float.parseFloat(inputValue.getText().toString());
        } catch (Exception error) {
            cashAmount = 0;
        }
        return cashAmount;
    }




    public float getRoomPrice(View view){
        RadioButton quartoSimples = findViewById(R.id.quartoSimplesID);
        RadioButton quartoDeluxe = findViewById(R.id.quartoDeluxeID);
        RadioButton quartoPresidencial = findViewById(R.id.presicencialID);

        try {
            if (quartoSimples.isChecked()){
                return precoQuarto;
            } else if (quartoDeluxe.isChecked()) {
                return precoQuartoDeluxe;
            } else if (quartoPresidencial.isChecked()) {
                return precoQuartoPresidencial;
            }  else {
                return padrao;
            }
        } catch (Exception error) {
            return 0;
        }
    }


    public float getServicePrice (View view){
        float total = 0;

        CheckBox cafe = findViewById(R.id.cafeID);
        CheckBox almoco = findViewById(R.id.almocoID);
        CheckBox janta = findViewById(R.id.jantaID);

        try {
            if (cafe.isChecked()) {
                total += precoCafe;
            }
            if (almoco.isChecked()) {
                total += precoAlmoco;
            }
            if (janta.isChecked()) {
                total += precoJanta;
            }
            return total;
        } catch (Exception error) {
            return 0;
        }
    }

    public float getRoomChoices(float cashAmount, float roomPrice ) {return cashAmount / roomPrice;}

    public void calculate(View view){
        TextView roomAmountTxt = findViewById(R.id.roomsValueID);
        TextView serviceValueTxt = findViewById(R.id.valueServicesID);
        TextView valueFinalTxt = findViewById(R.id.valorFinalID);

        float amountToPurshiseRoom = getAmountToPurchise(view);
        float roomPrice = getRoomPrice(view);
        float servicePrice = getServicePrice(view);
        float choices = getRoomChoices(amountToPurshiseRoom, roomPrice);


        roomAmountTxt.setText(String.valueOf(choices));
        serviceValueTxt.setText(String.valueOf(servicePrice));
        valueFinalTxt.setText(String.valueOf(amountToPurshiseRoom + servicePrice));
    }
}