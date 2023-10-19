package com.hackaton.repository_impl

import com.hackaton.entity.Habitation
import com.hackaton.entity.request.HabitationRequest
import com.hackaton.network.services.HabitationService
import com.hackaton.repository.HabitationRepository


class HabitationRepositoryImpl(
    private val habitationService: HabitationService
): HabitationRepository {

    override suspend fun createHabitation(habitationRequest: HabitationRequest) {

        habitationService.createHabitation(habitationRequest)
    }

    override suspend fun getHabitations(): List<Habitation> {
        return habitationService.getHabitation().data.hostels
    }
}