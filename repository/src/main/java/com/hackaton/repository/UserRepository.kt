package com.hackaton.repository

import com.hackaton.entity.Profile

interface UserRepository {

    suspend fun getUser(): Profile
    suspend fun uploadUserData(name: String, lastname: String): Profile
}