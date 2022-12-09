package com.example.homework21_tms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework21_tms.adapter.ItemsAdapter
import com.example.homework21_tms.listener.ItemListener
import com.example.homework21_tms.model.ItemsModel


class ItemsFragment : Fragment(), ItemListener {

    private lateinit var itemsAdapter: ItemsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter


        val listItems = listOf<ItemsModel>(
            ItemsModel(
                "Изгой",
                R.string.cast_away,
                "",
                R.drawable.castaway,
                R.drawable.empty_star
            ),
            ItemsModel(
                "Город в котором меня нет",
                R.string.city,
                "",
                R.drawable.city,
                R.drawable.empty_star
            ),
            ItemsModel(
                "Игра престолов",
                R.string.game_of_thrones,
                "",
                R.drawable.gameofthrones,
                R.drawable.empty_star
            ),
            ItemsModel(
                "Талантливый мистер Рипли",
                R.string.the_talented_mr_ripley,
                "",
                R.drawable.mrripley,
                R.drawable.empty_star
            ),
            ItemsModel(
                "По ту сторону изгороди",
                R.string.over_the_garden_wall,
                "",
                R.drawable.overthegardenwall,
                R.drawable.empty_star
            )
        )
        itemsAdapter.submitList(listItems)
    }


    override fun onClick() {
        Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(
        title_listener: String,
        description_listener: Int,
        time_listener: String,
        image_listener: Int
    ) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("title_listener", title_listener)
        bundle.putInt("description_listener", description_listener)
        bundle.putString("time_listener", time_listener)
        bundle.putInt("image_listener", image_listener)
        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack("")
            .commit()
    }
}