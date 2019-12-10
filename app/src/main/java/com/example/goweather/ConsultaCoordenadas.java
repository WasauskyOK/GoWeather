package com.example.goweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConsultaCoordenadas extends AppCompatActivity {


    EditText latitud,longitud;
    Button consultarCoordenadas,RegresoProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_coordenadas);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().hide();

        latitud=findViewById(R.id.tvlatitudprofile);
        longitud=findViewById(R.id.tvlongitudprofile);
        RegresoProfile=findViewById(R.id.btnCoordendasRegresarProfile);
        RegresoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConsultaCoordenadas.this,Profile.class));
            }
        });
        consultarCoordenadas=findViewById(R.id.btnConsultarxcoordenadasprofile);

        consultarCoordenadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EnviarCoordenadas();
            }
        });
    }
    public void EnviarCoordenadas(){

        new CuadroDialogoProfile(ConsultaCoordenadas.this,latitud.getText().toString(),longitud.getText().toString());
    }

}
