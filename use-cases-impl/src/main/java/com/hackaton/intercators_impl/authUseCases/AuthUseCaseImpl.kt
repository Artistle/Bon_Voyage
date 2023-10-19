package com.hackaton.intercators_impl.authUseCases

import com.hackaton.entity.Profile
import com.hackaton.interactors.auth.authUseCases.AuthUseCase
import com.hackaton.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthUseCaseImpl(
    private val authRepository: AuthRepository
): AuthUseCase {


    override suspend fun invoke(password: String, phoneNumber: String): Flow<Profile> = flow {
        val response = authRepository.auth(password, phoneNumber)
        emit(response)
    }
}