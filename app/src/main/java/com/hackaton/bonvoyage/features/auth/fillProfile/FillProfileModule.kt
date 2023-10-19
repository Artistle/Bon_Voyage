package com.hackaton.bonvoyage.features.auth.fillProfile

import com.hackaton.core_di.getDeeps
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.UseCasesQualifiers
import com.hackaton.core_di.qualifiers.featureQualifiers.FeaturesQualifiers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object FillProfileModule {

    val fillProfileModule = module {
        viewModel(nameDeep(FeaturesQualifiers.FILL_PROFILE_VIEW_MODEL)) {
            FillProfileViewModel(
                getDeeps(UseCasesQualifiers.UPLOAD_USER_DATA_USE_CASE)
            )
        }
    }
}