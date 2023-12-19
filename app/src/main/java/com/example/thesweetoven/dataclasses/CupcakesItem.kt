package com.example.thesweetoven.dataclasses

data class CupcakesItem(
    val cupcakes_img : Int,
    val cupcakes_name : String,
    val cupcakes_desc : String,
    var cupcakes_isExpandable : Boolean = false
)
