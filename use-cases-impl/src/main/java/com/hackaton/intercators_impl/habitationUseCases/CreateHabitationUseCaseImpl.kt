package com.hackaton.intercators_impl.habitationUseCases

import com.hackaton.entity.request.HabitationRequest
import com.hackaton.interactors.auth.habitationUseCases.CreateHabitationUseCase
import com.hackaton.repository.HabitationRepository

class CreateHabitationUseCaseImpl(
    private val habitationRepository: HabitationRepository
): CreateHabitationUseCase {
    override suspend fun invoke(habitationRequest: HabitationRequest) {
        habitationRepository.createHabitation(habitationRequest)
    }
}