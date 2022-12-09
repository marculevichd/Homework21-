package com.example.homework21_tms.listener

interface ItemListener {

    fun onClick()


    fun onElementSelected(
        title_listener: String,
        description_listener: Int,
        time_listener: String,
        image_listener: Int,
    )



}