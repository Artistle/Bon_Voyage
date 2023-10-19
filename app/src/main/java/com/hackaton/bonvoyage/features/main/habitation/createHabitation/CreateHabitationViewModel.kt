package com.hackaton.bonvoyage.features.main.habitation.createHabitation

import com.hackaton.bonvoyage.coreFeatures.BaseViewModel
import com.hackaton.entity.request.HabitationRequest
import com.hackaton.interactors.auth.habitationUseCases.CreateHabitationUseCase
import kotlinx.coroutines.launch

class CreateHabitationViewModel(
    private val createHabitationUseCase: CreateHabitationUseCase
): BaseViewModel() {

    fun createHabitation(request: HabitationRequest) = launch {
        createHabitationUseCase.invoke(request)
    }
}