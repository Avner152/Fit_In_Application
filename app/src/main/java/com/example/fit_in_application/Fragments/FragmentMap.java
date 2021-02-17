package com.example.avners.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fit_in_application.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

class Fragment_map extends Fragment{
    private View v;
    double dx, dy;
    private LatLng latLng;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.map_fragment, container, false);

        // init my map //
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_Map);

        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        latLng = getCoord();
                        MarkerOptions markerOptions = new MarkerOptions();
                        // sets position of marker //
                        markerOptions.position(latLng);
                        // set title of marker //
                        //  markerOptions.title(latLng.latitude + " : " + latLng.longitude);
                        // remove all markers //
                        googleMap.clear();
                        // Animating to zoom the marker //
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));

                        // add marker on map //
                        googleMap.addMarker(markerOptions.position(latLng).title("This is where the player placed") );
                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    }
                });
            }
        });

        return v;
    }

    public void setCoord(double d1, double d2){
        dx = d1;
        dy = d2;
        getCoord();
    }


    public LatLng getCoord(){
        return new LatLng(dx,dy);
    }
}