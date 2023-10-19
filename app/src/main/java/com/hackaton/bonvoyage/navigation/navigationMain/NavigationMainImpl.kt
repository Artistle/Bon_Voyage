package com.hackaton.bonvoyage.navigation.navigationMain

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

class NavigationMainImpl: NavigationMain {

    override val cicerone: Cicerone<Router>
        get() = Cicerone.create()

    override val router: Router
        get() = cicerone.router

    override val navigatorHolder: NavigatorHolder
        get() = cicerone.getNavigatorHolder()
}