package com.hackaton.bonvoyage.features.auth.signUp

import com.hackaton.core_di.getDeeps
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.UseCasesQualifiers
import com.hackaton.core_di.qualifiers.featureQualifiers.FeaturesQualifiers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object SignUpModule {

    val signUpFragmentModule = module {
        viewModel(nameDeep(FeaturesQualifiers.SIGN_UP_VIEW_MODEL)) {
            SignUpViewModel(
                getDeeps(
                    UseCasesQualifiers.CREATE_USER_USE_CASE
                )
            )
        }
    }
}