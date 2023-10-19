package com.hackaton.network.entity.request.userRequest

import com.google.gson.annotations.SerializedName

data class UploadUserDataRequest(

    @SerializedName("external_id")
    val externalId: String?,

    @SerializedName("lastname")
    val lastname: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("phone_number")
    val phoneNumber: String,

    @SerializedName("vtb_auth")
    val vtbAuth: String? = null
)