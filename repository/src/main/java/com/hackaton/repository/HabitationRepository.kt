package com.hackaton.repository

import com.hackaton.entity.Habitation
import com.hackaton.entity.request.HabitationRequest

interface HabitationRepository {

    suspend fun createHabitation(habitationRequest: HabitationRequest)

    suspend fun getHabitations(): Habitation
}