package com.example.goweather;

import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class milocalizacion extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Location location;
    private LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milocalizacion);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
*/
         locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
               // location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                //Toast.makeText(milocalizacion.this,"1",Toast.LENGTH_LONG).show();
                Log.i("Informacion",""+location.getLatitude());

            }
            else{
               // location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
               // Toast.makeText(milocalizacion.this,"latitud : "+location.getLatitude()+" longitud "+location.getLongitude(),Toast.LENGTH_LONG).show();
               // Toast.makeText(milocalizacion.this,"2"+location.getLatitude(),Toast.LENGTH_LONG).show();
                Log.i("Informacion",""+location.getLatitude());
            }
        }
        else{
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
           // Toast.makeText(milocalizacion.this,"latitud : "+location.getLatitude()+" longitud "+location.getLongitude(),Toast.LENGTH_LONG).show();
            Toast.makeText(milocalizacion.this,"3",Toast.LENGTH_LONG).show();
        }

       // LatLng latLng=new LatLng(location.getLatitude(),location.getLongitude());


        /*
         MarkerOptions markerOptions=new MarkerOptions()
                 .icon(BitmapDescriptorFactory.fromResource(R.drawable.markerbandera))
                 .position(latLng)
                 .title("Te encuentras aqui");
         mMap.addMarker(markerOptions).showInfoWindow();
        CameraPosition cameraPosition=CameraPosition.builder().zoom(19).target(latLng).build();
         mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

*/

    }
}
