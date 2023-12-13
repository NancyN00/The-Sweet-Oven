package com.example.thesweetoven.dataclasses

data class DonutsItem(
    val donuts_img: Int,
    val donuts_name: String,
    val donuts_desc: String,
    var donut_isExpandable: Boolean = false
)
