package com.hackaton.network.entity.response.authResponses

import com.google.gson.annotations.SerializedName
import com.hackaton.entity.Profile
import kotlin.properties.Delegates

data class UserResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val data: UserResponseData,
    @SerializedName("success")
    val success: Boolean?
)

data class UserResponseData(
    @SerializedName("email")
    val email: String?,
    @SerializedName("external_id")
    val externalId: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lastname")
    val lastname: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("phone_number")
    val phoneNumber: String?,
    @SerializedName("token_auth")
    val tokenAuth: String?,
    @SerializedName("vtb_auth")
    val vtbAuth: String?
)

class TestCheck<D>(dataModel: Class<D>) {

    @SerializedName("")
    var code: Int? = null

    @SerializedName("data")
    val data: D? = null

}