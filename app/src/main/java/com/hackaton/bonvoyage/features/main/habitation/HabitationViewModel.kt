package com.hackaton.bonvoyage.features.main.habitation

import com.hackaton.bonvoyage.coreFeatures.BaseViewModel
import com.hackaton.interactors.auth.habitationUseCases.CreateHabitationUseCase
import com.hackaton.network.entity.request.habitationRequest.CreateHabitationRequest
import kotlinx.coroutines.launch

class HabitationViewModel(
    private val createHabitationUseCase: CreateHabitationUseCase
): BaseViewModel() {


    init {

        launch {

        }
    }

}