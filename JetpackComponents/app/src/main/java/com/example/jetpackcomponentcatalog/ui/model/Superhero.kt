package com.example.jetpackcomponentcatalog.ui.model

import androidx.annotation.DrawableRes

data class Superhero(
    val heroName: String,
    val realName: String,
    val publisher: String,
    @DrawableRes var image: Int
)
