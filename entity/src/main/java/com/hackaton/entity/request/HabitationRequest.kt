package com.hackaton.entity.request


import com.google.gson.annotations.SerializedName
import java.io.File
import java.io.Serializable

data class HabitationRequest(
    @SerializedName("city_id")
    var cityId: Int = 0,
    @SerializedName("date_end")
    var dateEnd: String = "",
    @SerializedName("date_start")
    var dateStart: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("hostel_type")
    var hostelType: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("person_count")
    var personCount: Int = 0
): Serializable