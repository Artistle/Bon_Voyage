package com.hackaton.network.entity.request.userRequest

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: UserData,
    @SerializedName("success")
    val success: Boolean
)

data class UserData(
    @SerializedName("email")
    val email: Any,
    @SerializedName("external_id")
    val externalId: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastname")
    val lastname: Any,
    @SerializedName("name")
    val name: Any,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("token_auth")
    val tokenAuth: String,
    @SerializedName("vtb_auth")
    val vtbAuth: String
)