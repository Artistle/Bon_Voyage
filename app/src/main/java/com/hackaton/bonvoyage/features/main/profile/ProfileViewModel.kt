package com.hackaton.bonvoyage.features.main.profile

import com.hackaton.bonvoyage.coreFeatures.BaseViewModel
import com.hackaton.entity.Profile
import com.hackaton.interactors.auth.userUseCases.GetUserUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserUseCase: GetUserUseCase
): BaseViewModel() {

    private val _profile: MutableSharedFlow<Profile> = MutableSharedFlow()
    val profile: Flow<Profile> = _profile

    init {
        loadProfile()
    }
    private fun loadProfile() = launch {
        _profile.emit(getUserUseCase.invoke())
    }
}