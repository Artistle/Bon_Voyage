package com.hackaton.intercators_impl.userUseCases

import com.hackaton.entity.Profile
import com.hackaton.interactors.auth.userUseCases.GetUserUseCase
import com.hackaton.repository.UserRepository

class GetUserUseCaseImpl(private val userRepository: UserRepository): GetUserUseCase {
    override suspend fun invoke(): Profile {
        val response = userRepository.getUser()
        return Profile(
            email = response.email,
            name = response.name,
            lastname = response.lastname,
            phoneNumber = response.phoneNumber
        )
    }
}