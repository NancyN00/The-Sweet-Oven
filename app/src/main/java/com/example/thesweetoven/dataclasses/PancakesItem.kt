package com.example.thesweetoven.dataclasses

data class PancakesItem(
    val pancakes_img : Int,
    val pancakes_name : String,
    val pancakes_desc : String,
    var pancakes_isExpandable : Boolean = false
)
