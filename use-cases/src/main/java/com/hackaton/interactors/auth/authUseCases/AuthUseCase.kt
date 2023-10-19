package com.hackaton.interactors.auth.authUseCases

import com.hackaton.entity.Profile
import kotlinx.coroutines.flow.Flow

interface AuthUseCase {

    suspend operator fun invoke(password: String, phoneNumber: String): Flow<Profile>
    //suspend fun logout()
}