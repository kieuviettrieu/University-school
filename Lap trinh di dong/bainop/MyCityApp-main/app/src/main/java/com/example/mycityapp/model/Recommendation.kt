package com.example.mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/*
* Data model for recommendation
* */

data class Recommendation(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val addressResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
