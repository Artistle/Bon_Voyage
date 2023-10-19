package com.hackaton.bonvoyage.features.auth.fillProfile

import com.hackaton.bonvoyage.coreFeatures.BaseViewModel
import com.hackaton.interactors.auth.userUseCases.CreateUserUseCase
import kotlinx.coroutines.launch

class FillProfileViewModel(
    private val createUserUseCase: CreateUserUseCase
): BaseViewModel() {

    fun createUser() = launch {
        //createUserUseCase.invoke()
    }
}