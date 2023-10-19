package com.hackaton.interactors.auth.userUseCases

import com.hackaton.entity.Profile
import kotlinx.coroutines.flow.Flow

interface CreateUserUseCase {

    suspend operator fun invoke(phoneNumber: String, password: String): Flow<Profile>
}