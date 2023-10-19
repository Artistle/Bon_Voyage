package com.hackaton.persistence

import com.hackaton.entity.AuthState

interface PreferenceManager {

    var accessToken: String?

    var refreshToken: String?

    var vtbToken: String?

    var externalId: String?

    var authState: AuthState

    fun clearUserData()
}