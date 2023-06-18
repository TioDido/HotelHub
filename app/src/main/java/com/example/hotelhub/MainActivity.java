package com.example.hotelhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome, txtA1, txtA2;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        txtA1 = findViewById(R.id.txtSenha);
        btnCalcular = findViewById(R.id.btn_Next);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = txtNome.getText().toString();
                double a1 = Double.parseDouble(txtA1.getText().toString());
                double a2 = Double.parseDouble(txtA2.getText().toString());

                double media = (a1 + a2) / 2;

                Intent intent = new Intent(MainActivity.this, Resultado.class);
                intent.putExtra("nome", nome);
                intent.putExtra("media", media);
                startActivity(intent);
            }
        });
    }
    /* Testando */
}