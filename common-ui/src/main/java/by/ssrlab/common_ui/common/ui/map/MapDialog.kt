package by.ssrlab.common_ui.common.ui.map

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import by.ssrlab.common_ui.R
import by.ssrlab.common_ui.databinding.ViewMapBottomSheetBinding
import by.ssrlab.data.data.common.DescriptionData
import coil.load
import coil.transform.RoundedCornersTransformation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mapbox.api.directions.v5.DirectionsCriteria
import com.mapbox.api.directions.v5.models.RouteOptions
import com.mapbox.geojson.Point
import com.mapbox.navigation.base.extensions.applyDefaultNavigationOptions
import com.mapbox.navigation.base.route.NavigationRoute
import com.mapbox.navigation.base.route.NavigationRouterCallback
import com.mapbox.navigation.base.route.RouterFailure
import com.mapbox.navigation.base.route.RouterOrigin
import com.mapbox.navigation.core.MapboxNavigation

class MapDialog(
    private val mapActivity: MapActivity,
    private val point: DescriptionData,
    private val viewAnnotation: View,
    private val viewAnnotationArray: ArrayList<View>,
    private val userCoordinates: Point,
    private val navigation: MapboxNavigation,
    private val case: Int
): BottomSheetDialogFragment() {

    private lateinit var binding: ViewMapBottomSheetBinding

    override fun getTheme() = R.style.BottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ViewMapBottomSheetBinding.inflate(layoutInflater)
        binding.apply {
           bottomSheetImage.load(point.logo) {
               crossfade(true)
               transformations(RoundedCornersTransformation(16f))
           }

            bottomSheetTitle.text = point.keyName
        }

        binding.bottomSheetRoute.setOnClickListener {
            if (case == 0) {
                navigation.requestRoutes(
                    RouteOptions
                        .builder()
                        .applyDefaultNavigationOptions()
                        .profile(DirectionsCriteria.PROFILE_WALKING)
                        .coordinatesList(
                            listOf(
                                userCoordinates,
                                Point.fromLngLat(point.lon!!, point.lat!!)
                            )
                        )
                        .build(),

                    setCallback()
                )
            } else {
                Toast.makeText(mapActivity, resources.getText(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)

        viewAnnotation.findViewById<ConstraintLayout>(R.id.view_map_parent).background = ContextCompat.getDrawable(requireContext(), R.drawable.background_map_point_inactive)
        viewAnnotation.findViewById<TextView>(R.id.view_map_text).setTextColor(ContextCompat.getColor(requireContext(), R.color.map_point_text_inactive))
    }

    @SuppressLint("MissingPermission")
    private fun setCallback() = object : NavigationRouterCallback {
        override fun onCanceled(routeOptions: RouteOptions, routerOrigin: RouterOrigin) {}

        override fun onFailure(reasons: List<RouterFailure>, routeOptions: RouteOptions) {
            Toast.makeText(mapActivity, resources.getText(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
        }

        override fun onRoutesReady(routes: List<NavigationRoute>, routerOrigin: RouterOrigin) {
            navigation.setNavigationRoutes(routes)
            navigation.startTripSession()

            dismiss()

            for (i in viewAnnotationArray) {
                i.findViewById<ConstraintLayout>(R.id.view_map_parent).background = ContextCompat.getDrawable(requireContext(), R.drawable.background_map_point_inactive)
                i.findViewById<TextView>(R.id.view_map_text).setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            }

            viewAnnotation.findViewById<ConstraintLayout>(R.id.view_map_parent).background = ContextCompat.getDrawable(requireContext(), R.drawable.background_map_point_active)
            viewAnnotation.findViewById<TextView>(R.id.view_map_text).setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
        }
    }
}