package com.hackaton.intercators_impl.authUseCases

import com.hackaton.entity.AuthState
import com.hackaton.interactors.auth.authUseCases.AuthStateUseCase
import com.hackaton.persistence.PreferenceManager

class AuthStateUseCaseImpl(
    private val preferenceManager: PreferenceManager
): AuthStateUseCase {

    override fun invoke(): AuthState = preferenceManager.authState

}