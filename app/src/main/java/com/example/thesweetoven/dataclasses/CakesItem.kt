package com.example.thesweetoven.dataclasses

data class CakesItem(
    val cakes_img : Int,
    val cakes_name : String,
    val cakes_desc : String,
    var cakes_isExpandable : Boolean = false
)
