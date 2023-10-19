package com.hackaton.bonvoyage.features.auth.signIn

import com.hackaton.core_di.getDeeps
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.UseCasesQualifiers
import com.hackaton.core_di.qualifiers.featureQualifiers.SignInQualifier
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object SignInFragmentModule {

    val signInFragmentModule = module {
        viewModel(nameDeep(SignInQualifier.SIGN_IN_VIEW_MODEL)) {
            SignInViewModel(
                getDeeps(
                    UseCasesQualifiers.AUTH_USE_CASE
                )
            )
        }
    }
}