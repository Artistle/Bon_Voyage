package com.hackaton.interactors.auth.userUseCases

import com.hackaton.entity.Profile

interface GetUserUseCase {

    suspend operator fun invoke(): Profile
}