package com.example.goweather;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

import java.security.Provider;

public class mapatouchgo extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button botonRetornarProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapatouchgo);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        new CuadroDialogoMensajeLongClick(mapatouchgo.this);

        //Configurando boton retorar  a profile
        botonRetornarProfile=findViewById(R.id.btnReturnProfileMapsTouch);
        botonRetornarProfile.getBackground().setAlpha(98);
        botonRetornarProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mapatouchgo.this,Profile.class));
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
/*
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
*/
        //Configurando Zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);
        //setCompassEnabled  para la brujula
        mMap.getUiSettings().setCompassEnabled(true);
        //Toolbar
        mMap.getUiSettings().setMapToolbarEnabled(true);

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.estilojsonretro));

            if (!success) {
                Log.e("Mensaje", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("Mensaje", "Can't find style. Error: ", e);
        }

        LatLng coordenadasinicio=new LatLng(-11.980564, -77.005424);
        CameraPosition cameraPosition=CameraPosition.builder()
                .zoom(19)
                .target(coordenadasinicio)
                .build();


        MarkerOptions optionMarker=new MarkerOptions().icon(BitmapDescriptorFactory
                .fromResource(R.drawable.markerbandera))
                .position(coordenadasinicio)
                .title("Centro de estudios");

        mMap.addMarker(optionMarker).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                EnviarCoordenadasPorLongClick(latLng);
            }
        });

        //mMap.setMapStyle()
    }

    public void EnviarCoordenadasPorLongClick(LatLng latLng){

        new CuadroDialogoProfile(mapatouchgo.this,""+latLng.latitude,""+latLng.longitude);
    }
}
