package com.example.qulturapp.view.mapas

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import org.osmdroid.config.Configuration.*
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import android.Manifest
import android.annotation.SuppressLint
import android.content.*
import android.graphics.Color
import android.location.Location
import android.location.LocationManager

import android.os.Looper
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

import androidx.core.content.ContextCompat
import androidx.viewbinding.BuildConfig
import com.example.qulturapp.databinding.ActivityMapBinding
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.tasks.Task
import com.example.qulturapp.location.LocationProviderChangedReceiver
import com.example.qulturapp.location.MyEventLocationSettingsChange
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration


import org.osmdroid.views.overlay.compass.CompassOverlay
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider
import timber.log.Timber
import java.util.*

import com.example.qulturapp.R
import org.osmdroid.views.overlay.*

class ActivityMap: AppCompatActivity (){
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 1
    private lateinit var activityResultLauncher: ActivityResultLauncher<Array<String>>
    private lateinit var fusedLocationClient: FusedLocationProviderClient //https://developer.android.com/training/location/retrieve-current
    private var lastLoction: Location? = null
    private lateinit var locationCallback: LocationCallback
    private lateinit var locationRequest: LocationRequest
    private var requestingLocationUpdates = false

    companion object {
        val REQUEST_CHECK_SETTINGS = 20202
    }

    // funcion que configura los parametros de las actualizaciones
    // de ubicacion como el intervalo, la cantidad de error de la ubicacion
    // y la prioridad
    init {
        locationRequest = LocationRequest.create()
            .apply { //https://stackoverflow.com/questions/66489605/is-constructor-locationrequest-deprecated-in-google-maps-v2
                interval = 1000 //puede ser mayor
                fastestInterval = 500
                smallestDisplacement = 10f //10m
                priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                maxWaitTime = 1000
            }
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult ?: return
                for (location in locationResult.locations) {
                    // Actualiza la interfaz de usuario con la informacion
                    // de la ubicación
                    updateLocation(location)
                }
            }
        }

        this.activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { result ->
            var allAreGranted = true
            for (b in result.values) {
                allAreGranted = allAreGranted && b
            }

            Timber.d("Permissions granted $allAreGranted")
            if (allAreGranted) {
                initCheckLocationSettings()
                //initMap() if settings are ok
            }
        }
    }

    // Coloca mapa en Queretaro independientemente de
    // permisos de ubicación

    private lateinit var binding: ActivityMapBinding
    val rnd = Random()
    lateinit var map: MapView
    var startPoint: GeoPoint = GeoPoint(46.55951, 15.63970);
    lateinit var mapController: IMapController
    var marker: Marker? = null
    var path1: Polyline? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree()) //reporte de función init
        }
        val br: BroadcastReceiver = LocationProviderChangedReceiver()
        val filter = IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION)
        registerReceiver(br, filter)

        //LocalBroadcastManager.getInstance(this).registerReceiver(locationProviderChange)
        Configuration.getInstance()
            .load(applicationContext, this.getPreferences(Context.MODE_PRIVATE))
        binding = ActivityMapBinding.inflate(layoutInflater)

        map = binding.map
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)
        mapController = map.controller
        setContentView(binding.root)
        val appPerms = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.INTERNET
        )
        activityResultLauncher.launch(appPerms)

        // Añadir Iconos
        // con breve descripcion de cada uno
        val items = ArrayList<OverlayItem>()
        items.add(OverlayItem("Museo de Arte de Queretaro", "Exconvento de San Agustín, Claustro Barroco, el más importante de América. Museo inclusivo con servicios de accesibilidad. Visitas guiadas, talleres, eventos culturales. ", GeoPoint(20.59138, -100.3935)))
        items.add(OverlayItem("Galeria Libertad", "A un costado de Plaza de Armas se encuentra ubicada la Galería Libertad, digno albergue para la obra pictográfica producida en nuestro país y en el extranjero.", GeoPoint(20.5925, -100.3897)))
        items.add(OverlayItem("Secretaria de Cultura", " El Instituto Queretano de la Cultura y las Artes se transforman en Secretaría de Cultura del Estado de Querétaro. ", GeoPoint(20.58819, -100.39645)))

        //the overlay
        var overlay = ItemizedOverlayWithFocus<OverlayItem>(items, object:
            ItemizedIconOverlay.OnItemGestureListener<OverlayItem> {
            override fun onItemSingleTapUp(index:Int, item:OverlayItem):Boolean {
                //do something
                return true
            }
            override fun onItemLongPress(index:Int, item:OverlayItem):Boolean {
                return false
            }
        }, this)
        overlay.setFocusItemsOnTap(true);

        map.overlays.add(overlay);

    }
    override fun onResume() {
        super.onResume()
        //esto reinicia la configuracion de osmdroid al resumir
        binding.map.onResume() //requerido para el overlay de ubicacion, v6.0.0 +
    }
    override fun onPause() {
        super.onPause()
        //esto reinicia la configuracion de osmdroid al resumir
        if (requestingLocationUpdates) {
            requestingLocationUpdates = false
            stopLocationUpdates()
        }
        binding.map.onPause()  //requerido para el overlay de ubicacion, v6.0.0 +
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this);
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMsg(status: MyEventLocationSettingsChange) {
        if (status.on) {
            initMap()
        } else {
            Timber.i("Stop something")
        }
    }

    fun initLoaction() { //funcion llamada en onCreate
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        readLastKnownLocation()
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() { //onResume
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    private fun stopLocationUpdates() { //onPause
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    @SuppressLint("MissingPermission") //Permisos son revisados antes
    fun readLastKnownLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                location?.let { updateLocation(it) }
            }
    }

    fun initCheckLocationSettings() {
        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
        val client: SettingsClient = LocationServices.getSettingsClient(this)
        val task: Task<LocationSettingsResponse> = client.checkLocationSettings(builder.build())
        task.addOnSuccessListener { locationSettingsResponse ->
            Timber.d("Settings Location IS OK")
            MyEventLocationSettingsChange.globalState = true //default
            initMap()
            // Todas las configuraciones de ubicación fueron cumplidas. El cliente puede
            // inicializar las peticiones de ubicación.
        }

        task.addOnFailureListener { exception ->
            if (exception is ResolvableApiException) {
                // Configuracion de configuración no fueron cumplidos, pero
                // se puede usar el dialogo
                Timber.d("Settings Location addOnFailureListener call settings")
                try {
                    exception.startResolutionForResult(
                        this@ActivityMap,
                        REQUEST_CHECK_SETTINGS
                    )
                } catch (sendEx: IntentSender.SendIntentException) {
                    // Ignorar este error
                    Timber.d("Settings Location sendEx??")
                }
            }
        }

    }
    // si el codigo de la peticion de ubicación es la misma a que se recibe por parte
    // del sistema entonces se llama initMap()
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.d("Settings onActivityResult for $requestCode result $resultCode")
        if (requestCode == REQUEST_CHECK_SETTINGS) {
            if (resultCode == RESULT_OK) {
                initMap()
            }
        }
    }

    fun updateLocation(newLocation: Location) {
        lastLoction = newLocation
        //GUI, MAP TODO
        binding.tvLat.setText(newLocation.latitude.toString())
        binding.tvLon.setText(newLocation.longitude.toString())
        //var currentPoint: GeoPoint = GeoPoint(newLocation.latitude, newLocation.longitude);
        startPoint.longitude = newLocation.longitude
        startPoint.latitude = newLocation.latitude
        mapController.setCenter(startPoint)
        getPositionMarker().position = startPoint
        map.invalidate()

    }

    // inicializa en el mapa en el punto inicial
    // y comienza las actualizaciones de ubicacion
    fun initMap() {
        initLoaction()
        if (!requestingLocationUpdates) {
            requestingLocationUpdates = true
            startLocationUpdates()
        }
        mapController.setZoom(18.5)
        mapController.setCenter(startPoint);
        map.invalidate()
    }

    private fun getPath(): Polyline { //Singelton
        if (path1 == null) {
            path1 = Polyline()
            path1!!.outlinePaint.color = Color.RED
            path1!!.outlinePaint.strokeWidth = 10f
            path1!!.addPoint(startPoint.clone())
            map.overlayManager.add(path1)
        }
        return path1!!
    }

    private fun getPositionMarker(): Marker { //Singelton
        if (marker == null) {
            marker = Marker(map)
            marker!!.title = "Usted se encuentra aquí"
            marker!!.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            marker!!.icon = ContextCompat.getDrawable(this, R.drawable.ic_position)
            map.overlays.add(marker)
        }
        return marker!!
    }


    fun onClickDraw1(view: View?) {
        startPoint.latitude = startPoint.latitude + (rnd.nextDouble() - 0.5) * 0.001
        mapController.setCenter(startPoint)
        getPositionMarker().position = startPoint
        map.invalidate()
        mapController.setZoom(17.5)

    }

    fun onClickDraw2(view: View?) {
        /*
        startPoint.latitude = startPoint.latitude + (rnd.nextDouble() - 0.5) * 0.001
        mapController.setCenter(startPoint)
        val circle = Polygon(map)
        circle.points = Polygon.pointsAsCircle(startPoint, 40.0 + rnd.nextInt(100))
        circle.fillPaint.color = 0x32323232 //transparent
        circle.outlinePaint.color = Color.GREEN
        circle.outlinePaint.strokeWidth = 2f
        circle.title = "Area X"
        map.overlays.add(circle) //Duplicate every time new
        map.invalidate()
        */

        // Coloca el mapa en Galeria Libertad
        val mapController = map.controller
        mapController.setZoom(17.5)
        val startPoint = GeoPoint(20.59138, -100.3935);
        mapController.setCenter(startPoint);

    }

    fun onClickDraw3(view: View?) {
        /*
        val mCompassOverlay = CompassOverlay(this, InternalCompassOrientationProvider(this), map)
        mCompassOverlay.enableCompass()
        map.overlays.add(mCompassOverlay)
        map.invalidate()

         */
        //Coloca el mapa en Galeria Libertad
        val mapController = map.controller
        mapController.setZoom(17.5)
        val startPoint = GeoPoint(20.5925, -100.3897);
        mapController.setCenter(startPoint);

    }

    fun onClickDraw4(view: View?) {
        //Polyline path = new Polyline();
        /*
        startPoint.latitude = startPoint.latitude + (rnd.nextDouble() - 0.5) * 0.001
        startPoint.longitude = startPoint.longitude + (rnd.nextDouble() - 0.5) * 0.001
        getPath().addPoint(startPoint.clone())
        map.invalidate()

         */

        //Colocar mapa en Secretaria de Cultura
        val mapController = map.controller
        mapController.setZoom(17.5)
        val startPoint = GeoPoint(20.58819, -100.39645)
        mapController.setCenter(startPoint)


    }

}