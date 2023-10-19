package com.hackaton.intercators_impl.habitationUseCases

import com.hackaton.entity.Habitation
import com.hackaton.interactors.auth.habitationUseCases.GetHabitationsUseCase
import com.hackaton.repository.HabitationRepository

class GetHabitationUseCaseImpl(
    private val habitationRepository: HabitationRepository
): GetHabitationsUseCase {
    override suspend fun invoke(): List<Habitation> {
        return habitationRepository.getHabitations()
    }
}