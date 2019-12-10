package com.example.goweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class Profile extends AppCompatActivity {

    TextView hora;

    Button btnGoConsultarCoordenadas,btnGoConsultarMapsTouchLong,btnGoMapaSaladeJuegos,btnGoMiLocalizacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();




        hora=findViewById(R.id.tvhoraenvivo);


        btnGoConsultarCoordenadas=findViewById(R.id.btnIngresandoCoordenadas);
        btnGoConsultarMapsTouchLong=findViewById(R.id.btnBusquedaenMapa);
        btnGoMapaSaladeJuegos=findViewById(R.id.btnJugarYTemas);
        btnGoMiLocalizacion=findViewById(R.id.btnMiLocalizacion);

        btnGoMiLocalizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this,milocalizacion.class));
            }
        });
        btnGoMapaSaladeJuegos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this,mapasalajuegos.class));
            }
        });

        //Agregando event  handler  estan a la escucha al dar clic click :D
        btnGoConsultarCoordenadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this,ConsultaCoordenadas.class));
            }
        });
        btnGoConsultarMapsTouchLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(Profile.this,mapatouchgo.class));
            }
        });
        //imprimiendo hora :D
        new SacarHora().start();
    }
    //hora en tiempo real
    public  class SacarHora extends  Thread{

        @Override
        public void run() {

            Date fecha=new Date();

            while(true){

                try {


                    hora.setText(""+new Date().toString());
                    Thread.sleep(1000);
                }
                catch(Exception ex){

                }
            }

        }

    }


}
