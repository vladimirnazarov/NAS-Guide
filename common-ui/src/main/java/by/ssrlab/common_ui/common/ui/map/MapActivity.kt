package by.ssrlab.common_ui.common.ui.map

import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import by.ssrlab.common_ui.R
import by.ssrlab.common_ui.common.ui.base.BaseActivity
import by.ssrlab.common_ui.databinding.ActivityMapBinding
import by.ssrlab.data.data.common.DescriptionData
import by.ssrlab.data.data.remote.Place
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.mapbox.geojson.Point
import com.mapbox.maps.MapView
import com.mapbox.maps.MapboxMap
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import com.mapbox.maps.extension.style.expressions.dsl.generated.interpolate
import com.mapbox.maps.plugin.LocationPuck2D
import com.mapbox.maps.plugin.animation.camera
import com.mapbox.maps.plugin.locationcomponent.location
import com.mapbox.maps.plugin.scalebar.scalebar
import com.mapbox.maps.viewannotation.ViewAnnotationManager
import com.mapbox.maps.viewannotation.viewAnnotationOptions
import com.mapbox.navigation.core.MapboxNavigation
import com.mapbox.navigation.core.directions.session.RoutesObserver
import com.mapbox.navigation.core.lifecycle.MapboxNavigationObserver
import com.mapbox.navigation.core.lifecycle.requireMapboxNavigation
import com.mapbox.navigation.ui.maps.route.line.api.MapboxRouteLineApi
import com.mapbox.navigation.ui.maps.route.line.model.MapboxRouteLineOptions
import com.mapbox.navigation.ui.maps.route.line.model.RouteLineResources
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MapActivity : BaseActivity() {

    private lateinit var binding: ActivityMapBinding
    private var permissionGranted = false
    private val scope = CoroutineScope(Dispatchers.IO + Job())

    //List of pressed points
    private var pointsArray = arrayListOf<DescriptionData>()
    private val pointActivatedArray = arrayListOf<Boolean>()

    private var mapView: MapView? = null
    private lateinit var mapboxMap: MapboxMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var viewAnnotationManager: ViewAnnotationManager

    private lateinit var routeLineResources: RouteLineResources
    private lateinit var options: MapboxRouteLineOptions
    private lateinit var routeLineApi: MapboxRouteLineApi
    private lateinit var routesObserver: RoutesObserver

    private val mapboxNavigation: MapboxNavigation by requireMapboxNavigation(
        onResumedObserver = object : MapboxNavigationObserver {
            override fun onAttached(mapboxNavigation: MapboxNavigation) {
                mapboxNavigation.registerRoutesObserver(routesObserver)
            }

            override fun onDetached(mapboxNavigation: MapboxNavigation) {
                mapboxNavigation.unregisterRoutesObserver(routesObserver)
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mapView = binding.map
        viewAnnotationManager = binding.map.viewAnnotationManager

        //62 line through binding.map etc. not through property mapboxMap
        mapView?.scalebar?.enabled = false
        mapboxMap = binding.map.getMapboxMap()
        mapboxMap.loadStyleUri(Style.MAPBOX_STREETS).apply {
            //TODO add points with for cycle
            //pointActivatedArray.add(false)
        }

        setMapboxOptions()
        checkPermissions()
        setupButtons()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this@MapActivity)

        //Maybe insert setContentView here
    }

    override fun onStart() {
        super.onStart()

        //TODO make camera translation from the single selected point
    }

    override fun onDestroy() {
        super.onDestroy()

        mapboxNavigation.apply {
            stopTripSession()
            setNavigationRoutes(listOf())
        }
    }

    private fun setupButtons() {
        setLocationAction()
        setBackAction()
    }

    private fun setLocationAction() {
        scope.launch {
            if (permissionGranted) {

                withContext(Dispatchers.Main) {
                    setupMapbox()
                }

                binding.mapPosition.apply {
                    setImageResource(R.drawable.ic_location)
                    setOnClickListener {
                        //Current location check and then center camera on user
                        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                            mapView?.camera?.flyTo(
                                cameraOptions {
                                    center(Point.fromLngLat(location.longitude, location.latitude))
                                }
                            )
                        }
                    }
                }
            } else {
                binding.mapPosition.apply {
                    binding.mapPosition.setImageResource(R.drawable.ic_location_disable)
                    setOnClickListener {
                        //TODO
                    }
                }
            }

            delay(MAPBOX_LOCATION_RECHECK_TIME)
            checkPermissions()
            setLocationAction()
        }
    }

    private fun setBackAction() {
        binding.mapBack.setOnClickListener {
            OnBackPressedDispatcher().onBackPressed()
        }
    }

    private fun setupMapbox() {
        mapView?.location?.apply {
            enabled = true
            pulsingEnabled = true
            pulsingColor = ContextCompat.getColor(this@MapActivity, R.color.map_red)

            locationPuck = LocationPuck2D(
                topImage = AppCompatResources.getDrawable(this@MapActivity, R.drawable.ic_location_point),
                bearingImage = AppCompatResources.getDrawable(this@MapActivity, R.drawable.ic_location_point),
                shadowImage = AppCompatResources.getDrawable(this@MapActivity, R.drawable.ic_location_point),

                //This setting defines how lines and other will be interpolated on map scrolling
                scaleExpression = interpolate {
                    linear()
                    zoom()
                    stop {
                        literal(0.0)
                        literal(0.6)
                    }
                    stop {
                        literal(18.0)
                        literal(1.0)
                    }
                }.toJson()
            )
        }
    }

    private fun addPoint(pointObject: DescriptionData) {
        //Be careful with !! operator
        val point = Point.fromLngLat(pointObject.lon!!, pointObject.lat!!)
        val pointNumber = pointObject.pk.toString()
        val viewAnnotation = viewAnnotationManager.addViewAnnotation(
            resId = R.layout.view_map_point,
            options = viewAnnotationOptions { geometry(point) }
        )

//        TODO: next session
//        annotationArray.add(viewAnnotation
//
//        viewAnnotation.findViewById<TextView>(R.id.view_map_text).text = pointNumber
//        viewAnnotation.setOnClickListener {
//            setMapPointClicked(viewAnnotation, pointObject)
//        }
//
//        ViewMapBinding.bind(viewAnnotation)
    }
}