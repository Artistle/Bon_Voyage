package com.hackaton.intercators_impl.userUseCases

import com.hackaton.entity.Profile
import com.hackaton.interactors.auth.userUseCases.CreateUserUseCase
import com.hackaton.repository.AuthRepository

class CreateUserUseCaseImpl(
    private val authRepository: AuthRepository
): CreateUserUseCase {

    override suspend fun invoke(phoneNumber: String, password: String): Profile {
        val response = authRepository.createUser(phoneNumber, password)
        return Profile(
            name = response.name,
            email = response.email,
            lastname = response.lastname,
            phoneNumber = response.lastname
        )
    }
}