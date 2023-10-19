package com.hackaton.bonvoyage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hackaton.bonvoyage.coreFeatures.BaseViewModel
import com.hackaton.entity.AuthState
import com.hackaton.interactors.auth.authUseCases.AuthStateUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val authStateUseCase: AuthStateUseCase
) : BaseViewModel() {

    private val _stateFlow: MutableLiveData<AuthState> = MutableLiveData()
    val stateFlow: LiveData<AuthState> = _stateFlow

    fun loadState() {
        viewModelScope.launch {
            _stateFlow.postValue(authStateUseCase.invoke())
        }
    }
}