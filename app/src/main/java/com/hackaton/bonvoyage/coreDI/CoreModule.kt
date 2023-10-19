package com.hackaton.bonvoyage.coreDI

import com.hackaton.bonvoyage.MainViewModel
import com.hackaton.bonvoyage.features.auth.fillProfile.FillProfileModule.fillProfileModule
import com.hackaton.bonvoyage.features.auth.signIn.SignInFragmentModule.signInFragmentModule
import com.hackaton.bonvoyage.features.auth.signUp.SignUpModule.signUpFragmentModule
import com.hackaton.bonvoyage.features.main.profile.ProfileModule.profileModule
import com.hackaton.bonvoyage.navigation.NavigationModule
import com.hackaton.bonvoyage.network.module.NetworkModule.networkModule
import com.hackaton.core_di.getDeeps
import com.hackaton.core_di.qualifiers.UseCasesQualifiers
import com.hackaton.intercators_impl.module.UseCaseModule.useCaseModule
import com.hackaton.persistence_impl.module.PreferenceModule.preferenceModule
import com.hackaton.repository_impl.module.RepositoryModule.repositoryModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object CoreModule {

    private val featureModule = module {
        viewModel {
            MainViewModel(getDeeps(UseCasesQualifiers.AUTH_STATE_USE_CASE))
        }
    }


    val arrayModule: ArrayList<Module> = arrayListOf(
        NavigationModule.navigationModule,
        networkModule,
        preferenceModule,
        repositoryModule,
        useCaseModule,
        featureModule,
        signInFragmentModule,
        signUpFragmentModule,
        fillProfileModule,
        profileModule
    )
}