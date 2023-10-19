package com.hackaton.interactors.auth.habitationUseCases

import com.hackaton.entity.Habitation

interface GetHabitationsUseCase {

    suspend operator fun invoke(): List<Habitation>
}