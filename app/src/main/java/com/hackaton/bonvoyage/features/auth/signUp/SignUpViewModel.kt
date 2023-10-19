package com.hackaton.bonvoyage.features.auth.signUp

import com.hackaton.bonvoyage.coreFeatures.BaseViewModel
import com.hackaton.interactors.auth.userUseCases.CreateUserUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val createUserUseCase: CreateUserUseCase
): BaseViewModel() {

    private val _signUnResult: MutableSharedFlow<Boolean> = MutableSharedFlow()
    val signUnResult: Flow<Boolean> = _signUnResult
    fun createUser(phoneNumber: String, password: String) = launch {
        createUserUseCase.invoke(phoneNumber, password).collectLatest {
            _signUnResult.emit(true)
        }
    }
}