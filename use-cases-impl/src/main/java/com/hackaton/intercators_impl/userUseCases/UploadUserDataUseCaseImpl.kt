package com.hackaton.intercators_impl.userUseCases

import com.hackaton.entity.Profile
import com.hackaton.interactors.auth.userUseCases.UploadUserDataUseCase
import com.hackaton.repository.UserRepository

class UploadUserDataUseCaseImpl(
    private val userRepository: UserRepository
): UploadUserDataUseCase {

    override suspend fun invoke(name: String, lastname: String): Profile {
        return userRepository.uploadUserData(name, lastname)
    }
}