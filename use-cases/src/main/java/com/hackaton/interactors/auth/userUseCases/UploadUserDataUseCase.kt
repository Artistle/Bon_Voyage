package com.hackaton.interactors.auth.userUseCases

import com.hackaton.entity.Profile

interface UploadUserDataUseCase {

    suspend operator fun invoke(name: String, lastname: String): Profile
}