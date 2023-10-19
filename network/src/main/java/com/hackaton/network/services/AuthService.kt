package com.hackaton.network.services

import com.hackaton.network.entity.request.userRequest.CreateUserRequest
import com.hackaton.network.entity.response.authResponses.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST

interface AuthService {

    //@GET("/user")
    @POST("/auth")
    suspend fun auth(@Body requestAuthBody: CreateUserRequest): UserResponse

    @POST("/user")
    fun createUser(@Body createUserRequest: CreateUserRequest): UserResponse

    @GET("/user_vtb")
    fun authByVtb(): UserResponse
}