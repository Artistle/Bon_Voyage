package com.hackaton.bonvoyage.features.auth.signIn

import android.util.Log
import com.hackaton.bonvoyage.coreFeatures.BaseViewModel
import com.hackaton.interactors.auth.authUseCases.AuthUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SignInViewModel(
    private val authUseCase: AuthUseCase
): BaseViewModel() {

    private val _signInResult: MutableSharedFlow<Boolean> = MutableSharedFlow()
    val signInResult: Flow<Boolean> = _signInResult

    fun signInDefault(phone: String, password: String) = launch {
        authUseCase.invoke(phoneNumber = phone, password = password).collectLatest {
            _signInResult.emit(true)
            //Log.i("http errors", it.phoneNumber)
        }
    }

    fun signInByVtb() {

    }

    fun signInByGos() {

    }
}