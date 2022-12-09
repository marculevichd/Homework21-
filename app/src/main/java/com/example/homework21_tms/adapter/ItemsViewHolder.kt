package com.example.homework21_tms.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework21_tms.R
import com.example.homework21_tms.listener.ItemListener
import com.example.homework21_tms.model.ItemsModel

class ItemsViewHolder(
    private val view: View,
    private val itemListener: ItemListener
) : RecyclerView.ViewHolder(view) {

    fun bind(itemsModel: ItemsModel) {

        val title = view.findViewById<TextView>(R.id.title_item_film)
        val description = view.findViewById<TextView>(R.id.description_item_film)
        val time = view.findViewById<TextView>(R.id.clock_item_film)
        val image = view.findViewById<ImageView>(R.id.image_item_film)
        val imageFave = view.findViewById<ImageView>(R.id.image_fave_item_film)

        title.text = itemsModel.title
        description.setText( itemsModel.description)
        time.text = itemsModel.time
        image.setBackgroundResource(itemsModel.image)
        imageFave.setBackgroundResource(itemsModel.imageFave)


        var addImageFave = false
        imageFave.setOnClickListener {
            if (addImageFave) {
                imageFave.setImageResource(R.drawable.empty_star)
                addImageFave = false
            } else {
                imageFave.setImageResource(R.drawable.full_star)
            }
        }

        image.setOnClickListener {
            itemListener.onClick()
        }


        itemView.setOnClickListener {
            itemListener.onElementSelected(
                itemsModel.title,
                itemsModel.description,
                itemsModel.time,
                itemsModel.image

            )
        }



    }
}