package com.hackaton.bonvoyage.navigation.navigationAuth

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

interface NavigationAuth {
    val cicerone: Cicerone<Router>

    val router: Router

    val navigatorHolder: NavigatorHolder
}