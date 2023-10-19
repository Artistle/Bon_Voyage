package com.hackaton.bonvoyage.navigation

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.hackaton.core_di.getDeeps
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.NavigationQualifiers
import org.koin.dsl.module

object NavigationModule {
    val navigationModule = module(createdAtStart = true) {

        single<Cicerone<Router>>(nameDeep(NavigationQualifiers.CICERONE)) { Cicerone.create() }

        single<Router>(nameDeep(NavigationQualifiers.ROUTER)) {
            getDeeps<Cicerone<Router>>(NavigationQualifiers.CICERONE).router
        }

        single<NavigatorHolder>(nameDeep(NavigationQualifiers.HOLDER)) {
            getDeeps<Cicerone<Router>>(NavigationQualifiers.CICERONE).getNavigatorHolder()
        }

        single<Cicerone<Router>>(nameDeep(NavigationQualifiers.CICERONE_MAIN)) { Cicerone.create() }

        single<Router>(nameDeep(NavigationQualifiers.ROUTER_MAIN)) {
            getDeeps<Cicerone<Router>>(NavigationQualifiers.CICERONE_MAIN).router
        }

        single<NavigatorHolder>(nameDeep(NavigationQualifiers.HOLDER_MAIN)) {
            getDeeps<Cicerone<Router>>(NavigationQualifiers.CICERONE_MAIN).getNavigatorHolder()
        }
    }
}