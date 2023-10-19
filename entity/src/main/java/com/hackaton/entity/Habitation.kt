package com.hackaton.entity

import com.google.gson.annotations.SerializedName

data class Habitation(
    @SerializedName("avatar")
    val avatar: Any?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("city_id")
    val cityId: Int?,
    @SerializedName("date_end")
    val dateEnd: String?,
    @SerializedName("date_start")
    val dateStart: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("hostel_type")
    val hostelType: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("person_count")
    val personCount: Int?,
    @SerializedName("user_id")
    val userId: Int?
)