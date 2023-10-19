package com.hackaton.bonvoyage.features.main.habitation

import com.hackaton.bonvoyage.coreFeatures.BaseViewModel
import com.hackaton.entity.Habitation
import com.hackaton.interactors.auth.habitationUseCases.CreateHabitationUseCase
import com.hackaton.interactors.auth.habitationUseCases.GetHabitationsUseCase
import com.hackaton.network.entity.request.habitationRequest.CreateHabitationRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class HabitationViewModel(
    private val getHabitationsUseCase: GetHabitationsUseCase
): BaseViewModel() {

    private val _habitations: MutableSharedFlow<List<Habitation>> = MutableSharedFlow()
    val habitations: Flow<List<Habitation>> = _habitations

    init {

        launch {
            _habitations.emit(getHabitationsUseCase.invoke())
        }
    }

}