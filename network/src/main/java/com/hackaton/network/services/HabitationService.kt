package com.hackaton.network.services

import com.hackaton.entity.request.HabitationRequest
import com.hackaton.network.entity.response.hostelResponses.HabitationResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface HabitationService {

    @POST("/hostels/")
    suspend fun createHabitation(@Body habitationRequest: HabitationRequest): Response<Void>

    @GET("/hostels/")
    suspend fun getHabitation(): HabitationResponse
}