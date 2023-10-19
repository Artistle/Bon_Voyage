package com.hackaton.interactors.auth.userUseCases

import com.hackaton.entity.Profile

interface CreateUserUseCase {

    suspend operator fun invoke(phoneNumber: String, password: String): Profile
}