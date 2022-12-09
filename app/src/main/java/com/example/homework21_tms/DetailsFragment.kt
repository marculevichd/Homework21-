package com.example.homework21_tms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsTitle = view.findViewById<TextView>(R.id.title_details)
        val detailsDescription = view.findViewById<TextView>(R.id.description_details)
        val detailsTime = view.findViewById<TextView>(R.id.time_details)
        val detailsImage = view.findViewById<ImageView>(R.id.image_details)

        val bundle = arguments
        bundle?.let { safeBundle ->

            val title = safeBundle.getString("title_listener")
            val description = safeBundle.getInt("description_listener")
            val time = safeBundle.getString("time_listener")
            val image = safeBundle.getInt("image_listener")

            detailsTitle.text = title
            detailsDescription.setText(description)
            detailsTime.text = time
            detailsImage.setBackgroundResource(image)
        }
    }
}