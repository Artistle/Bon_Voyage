package com.hackaton.bonvoyage.features.auth.fillProfile

import com.hackaton.bonvoyage.coreFeatures.BaseViewModel
import com.hackaton.interactors.auth.userUseCases.CreateUserUseCase
import com.hackaton.interactors.auth.userUseCases.UploadUserDataUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class FillProfileViewModel(
    private val uploadUserDataUseCase: UploadUserDataUseCase
): BaseViewModel() {

    private val _fillProfileResult: MutableSharedFlow<Boolean> = MutableSharedFlow()
    val fillProfileResult: Flow<Boolean> = _fillProfileResult
    fun createUser(name: String, lastname: String) = launch {
        uploadUserDataUseCase.invoke(name, lastname)
        _fillProfileResult.emit(true)
    }
}