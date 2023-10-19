package com.hackaton.persistence_impl

import android.content.SharedPreferences
import com.hackaton.entity.AuthState.UNAUTHORIZED
import com.hackaton.entity.AuthState
import com.hackaton.entity.Profile
import com.hackaton.persistence.PreferenceManager

class PreferenceManagerImpl(
    private val sharedPreferences: SharedPreferences
) : PreferenceManager {

    override var accessToken: String?
        get() = sharedPreferences.getString(ACCESS_TOKEN_KEY, null)
        set(value) = setToken(ACCESS_TOKEN_KEY, value)

    override var refreshToken: String?
        get() = sharedPreferences.getString(REFRESH_TOKEN_KEY, null)
        set(value) = setToken(REFRESH_TOKEN_KEY, value)

    override var vtbToken: String?
        get() = sharedPreferences.getString(VTB_TOKEN_KEY, null)
        set(value) = setToken(VTB_TOKEN_KEY, value)

    override var externalId: String?
        get() = sharedPreferences.getString(EXTERNAL_ID_KEY, null)
        set(value) = setToken(EXTERNAL_ID_KEY, value)

    override var authState: AuthState
        get() = sharedPreferences.getString(AUTH_STATE_KEY, UNAUTHORIZED.name)!!
            .let { AuthState.valueOf(it) }
        set(value) {
            sharedPreferences.edit().putString(AUTH_STATE_KEY, value.name).apply()
        }

    override fun clearUserData() {
        sharedPreferences.edit().clear().apply()
    }

    private fun setToken(key: String, value: String?) {
        if (value == null) {
            sharedPreferences.edit().remove(key).apply()
        } else {
            sharedPreferences.edit().putString(key, value).apply()
        }
    }

    companion object {

        private const val REFRESH_TOKEN_KEY = "refresh_token_key"
        private const val ACCESS_TOKEN_KEY = "access_token_key"
        private const val VTB_TOKEN_KEY = "vtn_token_key"
        private const val EXTERNAL_ID_KEY = "external_id_key"
        private const val AUTH_STATE_KEY = "auth_state_key"
    }
}