package com.hackaton.repository_impl

import com.hackaton.entity.Profile
import com.hackaton.network.entity.request.userRequest.CreateUserRequest
import com.hackaton.network.entity.request.userRequest.UploadUserDataRequest
import com.hackaton.network.services.UserService
import com.hackaton.persistence.PreferenceManager
import com.hackaton.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(
    private val userService: UserService,
    private val preferenceManager: PreferenceManager
): UserRepository {

    override suspend fun getUser(): Profile = withContext(Dispatchers.IO) {
        val response = userService.getUser().data
        return@withContext Profile(
            email = response.email,
            lastname = response.lastname,
            name = response.name,
            phoneNumber = response.phoneNumber
        )
    }

    override suspend fun uploadUserData(
        name: String,
        lastname: String
    ): Profile = withContext(Dispatchers.IO) {
        val user = userService.getUser().data
        val vtbToken = preferenceManager.vtbToken
        val externalId = preferenceManager.externalId

        val request = UploadUserDataRequest(
            externalId = externalId,
            lastname = lastname,
            name = name,
            phoneNumber = user.phoneNumber,
            vtbAuth = vtbToken
        )
        val response = userService.uploadUserData(request).data

        return@withContext Profile(
            email = response.email,
            lastname = response.lastname,
            name = response.name,
            phoneNumber = response.phoneNumber
        )
    }
}