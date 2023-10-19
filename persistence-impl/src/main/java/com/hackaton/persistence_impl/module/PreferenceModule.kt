package com.hackaton.persistence_impl.module

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.hackaton.core_di.getDeeps
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.AppQualifiers
import com.hackaton.core_di.qualifiers.PersistenceQualifiers
import com.hackaton.persistence.PreferenceManager
import com.hackaton.persistence_impl.PreferenceManagerImpl
import org.koin.dsl.module

object PreferenceModule {

    private const val SHARED_PREF_NAME = "shared_pref_name"

    val preferenceModule = module {
        single<PreferenceManager>(nameDeep(PersistenceQualifiers.PREFERENCE_MANAGER)) { PreferenceManagerImpl(getDeeps(PersistenceQualifiers.SHARED_PREF)) }
        single<SharedPreferences>(nameDeep(PersistenceQualifiers.SHARED_PREF)) {
            getDeeps<Context>(AppQualifiers.APP_CONTEXT).getSharedPreferences(
                SHARED_PREF_NAME,
                MODE_PRIVATE
            )
        }
    }
}