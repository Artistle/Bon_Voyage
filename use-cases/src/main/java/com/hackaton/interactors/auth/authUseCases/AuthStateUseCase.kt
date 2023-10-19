package com.hackaton.interactors.auth.authUseCases

import com.hackaton.entity.AuthState

interface AuthStateUseCase {

    operator fun invoke(): AuthState
}