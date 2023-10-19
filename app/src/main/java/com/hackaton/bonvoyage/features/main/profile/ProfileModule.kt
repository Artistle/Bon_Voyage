package com.hackaton.bonvoyage.features.main.profile

import com.hackaton.core_di.getDeeps
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.UseCasesQualifiers
import com.hackaton.core_di.qualifiers.featureQualifiers.FeaturesQualifiers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ProfileModule {

    val profileModule = module {
        viewModel(nameDeep(FeaturesQualifiers.PROFILE_VIEW_MODEL)) {
            ProfileViewModel(getDeeps(UseCasesQualifiers.USER_USE_CASE))
        }
    }
}