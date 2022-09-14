package com.example.qulturapp.view.mapas

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.preference.PreferenceManager
import com.example.qulturapp.R

import org.osmdroid.config.Configuration.*
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

import java.util.ArrayList

class ActivityMap: AppCompatActivity (){
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 1
    private lateinit var map : MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
        setContentView(R.layout.activity_main)

        map = findViewById<MapView>(R.id.map)
        map.setTileSource(TileSourceFactory.MAPNIK)

        // Start on Queretaro
        val mapController = map.controller
        mapController.setZoom(12)
        val startPoint = GeoPoint(20.5880, -100.3880)
        mapController.setCenter(startPoint)
    }
    override fun onResume() {
        super.onResume()
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        map.onResume() //needed for compass, my location overlays, v6.0.0 and up
    }
    override fun onPause() {
        super.onPause()
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        map.onPause()  //needed for compass, my location overlays, v6.0.0 and up
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val permissionsToRequest = ArrayList<String>()
        var i = 0
        while (i < grantResults.size) {
            permissionsToRequest.add(permissions[i])
            i++
        }
        if (permissionsToRequest.size > 0) {
            ActivityCompat.requestPermissions(
                this,
                permissionsToRequest.toTypedArray(),
                REQUEST_PERMISSIONS_REQUEST_CODE)
        }
    }
}