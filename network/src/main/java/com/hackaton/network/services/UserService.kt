package com.hackaton.network.services

import com.hackaton.entity.Profile
import com.hackaton.network.entity.request.userRequest.CreateUserRequest
import com.hackaton.network.entity.request.userRequest.UploadUserDataRequest
import com.hackaton.network.entity.response.authResponses.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @POST("user_data/")
    fun uploadUserData(@Body userDataRequest: UploadUserDataRequest): UserResponse

    @GET("auth/")
    suspend fun getUser(): UserResponse
}