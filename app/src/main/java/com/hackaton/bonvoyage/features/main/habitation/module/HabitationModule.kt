package com.hackaton.bonvoyage.features.main.habitation.module

import com.hackaton.bonvoyage.features.main.habitation.HabitationViewModel
import com.hackaton.core_di.getDeeps
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.UseCasesQualifiers
import com.hackaton.core_di.qualifiers.featureQualifiers.FeaturesQualifiers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object HabitationModule {

    val habitationModule = module {
        viewModel(nameDeep(FeaturesQualifiers.HABITATION_VIEW_MODEL)) {
            HabitationViewModel(getDeeps(UseCasesQualifiers.GET_HABITATION))
        }
    }
}