package com.example.goweather;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class CuadroDialogoProfile {
    ImageView cancelar;
    TextView edicion,titulogrados,tempminima,tempmaxima,titlelugar;
    public CuadroDialogoProfile(Context context, String latitud, String longitud)
    {
        final Dialog dialogo=new Dialog(context);
        //dialogo sin titulo
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(false);
        dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogo.setContentView(R.layout.cuadrodialogoprofile);


        titulogrados=dialogo.findViewById(R.id.tvTitulocuadrodialogo);

        tempminima=dialogo.findViewById(R.id.mintemperatura);
        tempmaxima=dialogo.findViewById(R.id.maxtemperatura);

        titlelugar=dialogo.findViewById(R.id.titlelugar);

        edicion=dialogo.findViewById(R.id.tvdialogoprofileresponse);
        //edicion.setText(cadena);
        cancelar=dialogo.findViewById(R.id.idCloseVentana);

        Mostrar_detalleClima(latitud,longitud,context);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogo.dismiss();

            }
        });
        dialogo.show();
    }

    public void Mostrar_detalleClima(String lat,String longi,Context context){


        //edicion.setText("lati ; "+lat+"  longitud : "+longi);
        String uri="https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+longi+"&units=metric&appid=08c976e03a014cc66faa5075f10add77&lang=es";
        final JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.GET, uri, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject principalrequest=response;

                    JSONObject coordenadas=principalrequest.getJSONObject("coord");
                    double  longitud=coordenadas.getInt("lon");
                    double  latitud=coordenadas.getInt("lat");


                    JSONArray weather=principalrequest.getJSONArray("weather");
                    JSONObject objectweather=weather.getJSONObject(0);
                    int  idweather=objectweather.getInt("id");
                    String description=objectweather.getString("description");


                    //String base=principalrequest.getString("base");

                    JSONObject main=principalrequest.getJSONObject("main");
                    int temp=main.getInt("temp");
                    int pressure=main.getInt("pressure");
                    int humidity=main.getInt("humidity");
                    int temp_min=main.getInt("temp_min");
                    int temp_max=main.getInt("temp_max");
                    int visibility=principalrequest.getInt("visibility");

                    JSONObject wind=principalrequest.getJSONObject("wind");
                    int speed=wind.getInt("speed");
                    int deg=wind.getInt("deg");
                    JSONObject clouds=principalrequest.getJSONObject("clouds");
                    int all=clouds.getInt("all");
                    String dt=principalrequest.getString("dt");

                    JSONObject sys=principalrequest.getJSONObject("sys");
                    int type=sys.getInt("type");
                    String  country=sys.getString("country");
                    String sunrise=sys.getString("sunrise");
                    String sunset=sys.getString("sunset");


                    String timezone=principalrequest.getString("timezone");
                    String id=principalrequest.getString("id");
                    String name=principalrequest.getString("name");
                    String cod=principalrequest.getString("cod");



                    //Obtencion de datos dentro de un  object

                    titlelugar.setText(country+" Lugar : "+name);
                    titulogrados.setText(temp+"°C");
                    tempminima.setText("Temp min\n"+"\t"+temp_min+"°C");
                    tempmaxima.setText("Temp max\n"+"\t"+temp_max+"°C");

                    edicion.setText
                            ("Coordenadas :  \n" +
                                    "Longitud : "+longitud+"\n"+
                                    "Latitud : "+latitud+"\n"+
                                    "Clima : :  \n" +
                                    "Id Clima : "+idweather+"\n"+
                                    "Nombre de condición climática : "+description+"\n\n"+
                                    "Cuepo : \n"+
                                    "Temperatura : "+temp+"°C\n"+
                                    "Presión atmosférica : "+pressure+"hPa\n"+
                                    "Humedad relativa: "+humidity+"%\n"+
                                    "Temperatura minima : "+temp_min+"°C\n"+
                                    "Temperatura  maxima : "+temp_max+"°C\n\n"+
                                    "Visibilidad \n "+
                                    "Visisbilidad : "+(visibility/10)+" km\n\n"+
                                    "Viento\n"+
                                    "Velocidad del viento : "+speed+"km/h\n"+
                                    "Dirección del viento : "+deg+"°\n\n"+
                                    "Nubes  \n"+
                                    "Abundancia de nubes : "+all+"\n\n"+
                                    "Localidad  : \n"+
                                    "Codigo Pais : "+country+"\n"+
                                    "Hora del amanecer, unix, UTC : "+sunrise+"\n"+
                                    "Hora del atardecer, unix, UTC : "+sunset+"\n\n"+

                                    "Cambio en segundos desde UTC : "+timezone+"\n"+
                                    "ID de la ciudad : "+id+"\n"+
                                    "Nombre de la ciudad : "+name+"\n"+
                                    "Parámetro interno : "+cod+"\n"
                            );

                    //edicion.append(principalrequest.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                edicion.setText(error.getMessage().toString());
            }
        }
        );

        RequestQueue queue= Volley.newRequestQueue(context);
        queue.add(objectRequest);



    }

}
