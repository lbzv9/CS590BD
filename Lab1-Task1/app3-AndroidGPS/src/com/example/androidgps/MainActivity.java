package com.example.androidgps;


import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MapController;
import com.google.android.maps.GeoPoint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import android.location.Geocoder;
import android.location.Address;

import com.google.android.maps.Overlay;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.List;
import java.util.Locale;
import java.io.IOException;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends MapActivity {
    /** Called when the activity is first created. */

	private LocationManager locationManager;
    private LocationListener locationListener;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);    
        
        locationListener = new GPSLocationListener();
        
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER, 
            0, 
            0, 
            locationListener);
    }
    
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
    
    private class GPSLocationListener implements LocationListener 
    {
        @Override
        public void onLocationChanged(Location location) {
            if (location != null) {
                GeoPoint point = new GeoPoint(
                        (int) (location.getLatitude() * 1E6), 
                        (int) (location.getLongitude() * 1E6));
                
                 Toast.makeText(getBaseContext(), 
                        "Latitude: " + location.getLatitude() + 
                        " Longitude: " + location.getLongitude(), 
                        Toast.LENGTH_SHORT).show();
                                
          			
                String address = ConvertPointToLocation(point);
                Toast.makeText(getBaseContext(), address, Toast.LENGTH_SHORT).show();

            }
        }
        
        public String ConvertPointToLocation(GeoPoint point) {   
        	String address = "";
            Geocoder geoCoder = new Geocoder(
                    getBaseContext(), Locale.getDefault());
            try {
                List<Address> addresses = geoCoder.getFromLocation(
                	point.getLatitudeE6()  / 1E6, 
                    point.getLongitudeE6() / 1E6, 1);
	 
		        if (addresses.size() > 0) {
		            for (int index = 0; index < addresses.get(0).getMaxAddressLineIndex(); index++)
		            	address += addresses.get(0).getAddressLine(index) + " ";
		        }
            }
            catch (IOException e) {                
                e.printStackTrace();
            }   
            
            return address;
        } 

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }
    
    
}