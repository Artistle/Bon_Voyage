package com.hackaton.network.entity.response.hostelResponses

import com.google.gson.annotations.SerializedName
import com.hackaton.entity.Habitation

data class HabitationResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)

data class Data(
    @SerializedName("hostels")
    val hostels: List<Habitation>
)
