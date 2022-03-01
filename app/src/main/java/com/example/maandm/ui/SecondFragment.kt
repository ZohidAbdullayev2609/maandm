package com.example.maandm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.maandm.R
import com.example.maandm.databinding.FragmentSecondBinding
import com.example.maandm.model.Person
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*

class SecondFragment : Fragment() {
    private lateinit var _binding: FragmentSecondBinding
    private val binding get() = _binding
    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        val position = arguments?.getSerializable("position") as Person
        binding.iv.setImageResource(position.image)
        binding.tv.text = position.name
        binding.dv.text = position.about


        val supportMapFragment =
            childFragmentManager.findFragmentById(R.id.maps) as SupportMapFragment
        supportMapFragment.getMapAsync(OnMapReadyCallback {
            mMap = it
            mMap.addMarker(
                MarkerOptions().position(
                    LatLng(
                        position.x,
                        position.y
                    )
                ).title("Marker in ${position.name}")
            )
            mMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(
                        position.x,
                        position.y
                    ), 17f
                )
            )

            mMap.uiSettings.isZoomControlsEnabled = true
            mMap.uiSettings.isZoomGesturesEnabled = true
            mMap.uiSettings.isMapToolbarEnabled = true
        })

//        val transaction = fragmentManager?.beginTransaction()
//        transaction?.addToBackStack("salom")?.replace(R.id.container,FirstFragment())?.commit()

        return binding.root
    }


}