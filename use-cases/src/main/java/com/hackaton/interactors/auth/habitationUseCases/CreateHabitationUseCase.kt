package com.hackaton.interactors.auth.habitationUseCases

import com.hackaton.entity.request.HabitationRequest

interface CreateHabitationUseCase {

    suspend operator fun invoke(habitationRequest: HabitationRequest)
}