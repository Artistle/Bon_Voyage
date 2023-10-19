package com.hackaton.repository

import com.hackaton.entity.AuthState
import com.hackaton.entity.Profile
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    /**
     *  url.../user/
     */
    suspend fun auth(password: String, phoneNumber: String): Profile
    suspend fun getAuthState(): AuthState
    suspend fun createUser(phoneNumber: String, password: String): Profile
    suspend fun logout()

}