package com.hackaton.repository_impl

import com.hackaton.entity.AuthState
import com.hackaton.entity.Profile
import com.hackaton.network.entity.request.userRequest.CreateUserRequest
import com.hackaton.network.services.AuthService
import com.hackaton.persistence.PreferenceManager
import com.hackaton.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepositoryImpl(
    private val authService: AuthService,
    private val preferenceManager: PreferenceManager
) : AuthRepository {

    override suspend fun auth(password: String, phoneNumber: String): Profile = withContext(Dispatchers.IO) {
        val response =
            authService.auth(CreateUserRequest(password = password, phoneNumber = phoneNumber)).data
        setAuthState(response?.tokenAuth, response?.vtbAuth, response?.externalId)
        return@withContext Profile(
            email = response.email,
            name = response.name,
            lastname = response.lastname,
            phoneNumber = response.phoneNumber
        )
    }

    override suspend fun getAuthState(): AuthState {
        return preferenceManager.authState
    }

    override suspend fun createUser(phoneNumber: String, password: String): Profile =
        withContext(Dispatchers.IO) {
            val vtbToken = preferenceManager.vtbToken
            val externalId = preferenceManager.externalId
            val response = authService.createUser(
                CreateUserRequest(
                    password, phoneNumber, vtbToken, externalId
                )
            ).data
            return@withContext Profile(
                name = response.name,
                lastname = response.lastname,
                phoneNumber = response.phoneNumber,
                email = response.email
            )
        }

    override suspend fun logout() {
        preferenceManager.clearUserData()
    }

    private fun setAuthState(newToken: String?, newVtbToken: String?, newExternalId: String?) {
        preferenceManager.apply {
            accessToken = newToken
            vtbToken = newVtbToken
            externalId = newExternalId
            authState =
                if (newToken.isNullOrEmpty()) AuthState.UNAUTHORIZED else AuthState.AUTHORIZED
        }
    }
}