package com.hackaton.network.services

import com.hackaton.entity.request.HabitationRequest
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface HabitationService {

    @POST("/hostels/")
    suspend fun createHabitation(@Body habitationRequest: MultipartBody): Void

    @GET("/hostels/")
    suspend fun getHabitation(): Void
}