package com.elementalist.milksniffer.presentation

sealed class Screen(val route: String, val icon: Int? = null){
    object MainScreen: Screen("main_screen")
    object SetUpScreen: Screen("set_up_screen")
    object SniffScreen: Screen("sniff_screen")
}

