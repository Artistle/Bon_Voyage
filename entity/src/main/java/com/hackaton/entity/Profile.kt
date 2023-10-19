package com.hackaton.entity

import java.io.Serializable

data class Profile(
    val email: String?,
    val lastname: String?,
    val name: String?,
    val phoneNumber: String?,
): Serializable