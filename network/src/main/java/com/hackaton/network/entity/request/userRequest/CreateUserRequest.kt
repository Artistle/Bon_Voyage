package com.hackaton.network.entity.request.userRequest

import com.google.gson.annotations.SerializedName

data class CreateUserRequest(

    @SerializedName("password")
    val password: String,

    @SerializedName("phone_number")
    val phoneNumber: String,

    @SerializedName("vtb_auth")
    val vtbAuthToken: String? = null,

    @SerializedName("external_id")
    val externalId: String? = null
)