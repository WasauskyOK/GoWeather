package com.example.goweather;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapasalajuegos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private RadioGroup botongrupo;
    private ImageView btnreturn;

    //private RadioButton botonstandar,botonSilver,botonRetro,botonDark,botonNight,botonAurbergine;
    private Button botonHibrido,botonNormal,botonNone,botonSatelital,botonTerreno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapasalajuegos);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        new CuadroDialogoMensajeMarcodes(mapasalajuegos.this);

        botongrupo=findViewById(R.id.radioGroupEstilo);

        botonNormal=findViewById(R.id.btnNormal);
        botonHibrido=findViewById(R.id.btnHibrido);
        botonNone=findViewById(R.id.btnNinguno);
        botonSatelital=findViewById(R.id.btnSatelital);
        botonTerreno=findViewById(R.id.btnTerreno);
        /*
        mMap.setMapType(googleMap.MAP_TYPE_HYBRID);
        mMap.setMapType(googleMap.MAP_TYPE_NONE);
        mMap.setMapType(googleMap.MAP_TYPE_NORMAL);
        mMap.setMapType(googleMap.MAP_TYPE_SATELLITE);
        mMap.setMapType(googleMap.MAP_TYPE_TERRAIN);
        */
        botonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(mMap.MAP_TYPE_NORMAL);
            }
        });
        botonHibrido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(mMap.MAP_TYPE_HYBRID);
            }
        });
        botonNone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(mMap.MAP_TYPE_NONE);
            }
        });
        botonSatelital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(mMap.MAP_TYPE_SATELLITE);
            }
        });
        botonTerreno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(mMap.MAP_TYPE_TERRAIN);
            }
        });

    /*
        botonstandar=findViewById(R.id.radioButtonStyle1);
        botonSilver=findViewById(R.id.radioButtonStyle2);
        botonRetro=findViewById(R.id.radioButtonStyle3);
        botonDark=findViewById(R.id.radioButtonStyle4);
        botonNight=findViewById(R.id.radioButtonStyle5);
        botonAurbergine=findViewById(R.id.radioButtonStyle6);
*/
    btnreturn=findViewById(R.id.btnReturnProfileSalaJuegos);
    btnreturn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(mapasalajuegos.this,Profile.class));
        }
    });
        botongrupo.check(R.id.radioButtonStyle1);
        botongrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radioButtonStyle1){
                    try {
                        // Customise the styling of the base map using a JSON object defined
                        // in a raw resource file.
                        boolean success = mMap.setMapStyle(
                                MapStyleOptions.loadRawResourceStyle(
                                        mapasalajuegos.this, R.raw.estilosstandard));

                        if (!success) {
                            Log.e("Mensaje", "Style parsing failed.");
                        }
                    } catch (Resources.NotFoundException e) {
                        Log.e("Mensaje", "Can't find style. Error: ", e);
                    }
                }
                if (i==R.id.radioButtonStyle2){
                    try {
                        // Customise the styling of the base map using a JSON object defined
                        // in a raw resource file.
                        boolean success = mMap.setMapStyle(
                                MapStyleOptions.loadRawResourceStyle(
                                        mapasalajuegos.this, R.raw.estilosilver));

                        if (!success) {
                            Log.e("Mensaje", "Style parsing failed.");
                        }
                    } catch (Resources.NotFoundException e) {
                        Log.e("Mensaje", "Can't find style. Error: ", e);
                    }
                }
                if(i==R.id.radioButtonStyle3){
                    try {
                        // Customise the styling of the base map using a JSON object defined
                        // in a raw resource file.
                        boolean success = mMap.setMapStyle(
                                MapStyleOptions.loadRawResourceStyle(
                                        mapasalajuegos.this, R.raw.estilojsonretro));

                        if (!success) {
                            Log.e("Mensaje", "Style parsing failed.");
                        }
                    } catch (Resources.NotFoundException e) {
                        Log.e("Mensaje", "Can't find style. Error: ", e);
                    }
                }
                if(i==R.id.radioButtonStyle4){
                    try {
                        // Customise the styling of the base map using a JSON object defined
                        // in a raw resource file.
                        boolean success = mMap.setMapStyle(
                                MapStyleOptions.loadRawResourceStyle(
                                        mapasalajuegos.this, R.raw.estilosdark));

                        if (!success) {
                            Log.e("Mensaje", "Style parsing failed.");
                        }
                    } catch (Resources.NotFoundException e) {
                        Log.e("Mensaje", "Can't find style. Error: ", e);
                    }
                }
                if(i==R.id.radioButtonStyle5){
                    try {
                        // Customise the styling of the base map using a JSON object defined
                        // in a raw resource file.
                        boolean success = mMap.setMapStyle(
                                MapStyleOptions.loadRawResourceStyle(
                                        mapasalajuegos.this, R.raw.estilonigth));

                        if (!success) {
                            Log.e("Mensaje", "Style parsing failed.");
                        }
                    } catch (Resources.NotFoundException e) {
                        Log.e("Mensaje", "Can't find style. Error: ", e);
                    }
                }
                if(i==R.id.radioButtonStyle6){
                    try {
                        // Customise the styling of the base map using a JSON object defined
                        // in a raw resource file.
                        boolean success = mMap.setMapStyle(
                                MapStyleOptions.loadRawResourceStyle(
                                        mapasalajuegos.this, R.raw.estilosauvergine));

                        if (!success) {
                            Log.e("Mensaje", "Style parsing failed.");
                        }
                    } catch (Resources.NotFoundException e) {
                        Log.e("Mensaje", "Can't find style. Error: ", e);
                    }
                }
            }
        });

    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        //setCompassEnabled  para la brujula
        mMap.getUiSettings().setCompassEnabled(true);
        //Toolbar
        mMap.getUiSettings().setMapToolbarEnabled(true);

/*
        mMap.setMapType(googleMap.MAP_TYPE_HYBRID);
        mMap.setMapType(googleMap.MAP_TYPE_NONE);
        mMap.setMapType(googleMap.MAP_TYPE_NORMAL);
        mMap.setMapType(googleMap.MAP_TYPE_SATELLITE);
        mMap.setMapType(googleMap.MAP_TYPE_TERRAIN);
*/
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.estilosstandard));

            if (!success) {
                Log.e("Mensaje", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("Mensaje", "Can't find style. Error: ", e);
        }

        LatLng coordenadasinicio=new LatLng(-11.980564, -77.005424);
        CameraPosition cameraPosition=CameraPosition.builder()
                .zoom(16)
                .target(coordenadasinicio)
                .build();


        MarkerOptions optionMarker=new MarkerOptions().icon(BitmapDescriptorFactory
                .fromResource(R.drawable.markerbandera))
                .position(coordenadasinicio)
                .title("Centro de estudios");

        mMap.addMarker(optionMarker).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions markerOptions=new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.markerbandera)).position(latLng).title("Marcador Agregado");
                mMap.addMarker(markerOptions).showInfoWindow();
            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                new CuadroDialogoProfile(mapasalajuegos.this,""+latLng.latitude,""+latLng.longitude);
/*
                MarkerOptions markerOptions=new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.markerbandera)).position(latLng).title("Marcador Agregado");
                mMap.addMarker(markerOptions).showInfoWindow();
                */
            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                marker.remove();

                return false;
            }
        });
        //MARCADORES



    }
}
