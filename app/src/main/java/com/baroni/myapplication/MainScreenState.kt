package com.baroni.myapplication

data class MainScreenState(
    val isButtonEnabled:Boolean = true,
    val text:String = "",
    val textBIG : String = "",
    val speech:String? = null
)