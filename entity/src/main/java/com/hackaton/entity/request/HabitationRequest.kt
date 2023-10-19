package com.hackaton.entity.request


import com.google.gson.annotations.SerializedName
import java.io.File

data class HabitationRequest(
    @SerializedName("avatar")
    val avatar: File?,
    @SerializedName("city_id")
    val cityId: Int,
    @SerializedName("date_end")
    val dateEnd: String,
    @SerializedName("date_start")
    val dateStart: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("hostel_type")
    val hostelType: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("person_count")
    val personCount: Int
)