package com.hackaton.intercators_impl.userUseCases

import com.hackaton.entity.Profile
import com.hackaton.interactors.auth.userUseCases.CreateUserUseCase
import com.hackaton.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CreateUserUseCaseImpl(
    private val authRepository: AuthRepository
): CreateUserUseCase {

    override suspend fun invoke(phoneNumber: String, password: String): Flow<Profile> = flow {
        val response = authRepository.createUser(phoneNumber, password)
        val profile = Profile(
            name = response.name,
            email = response.email,
            lastname = response.lastname,
            phoneNumber = response.lastname
        )
        emit(profile)
    }
}