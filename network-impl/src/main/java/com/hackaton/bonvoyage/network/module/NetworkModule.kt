package com.hackaton.bonvoyage.network.module

import com.hackaton.bonvoyage.network.AuthInterceptor
import com.hackaton.bonvoyage.network.CallAdapterFactory
import com.hackaton.bonvoyage.network.ServiceFactoryImpl
import com.hackaton.core_di.getDeeps
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.NetworkQualifiers
import com.hackaton.core_di.qualifiers.PersistenceQualifiers
import com.hackaton.core_di.qualifiers.ServiceQualifiers
import com.hackaton.network.services.AuthService
import com.hackaton.network.services.UserService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module

object NetworkModule {

    val networkModule = module {

        factory<Interceptor>(nameDeep(NetworkQualifiers.AUTH_INTERCEPTOR)) {
            AuthInterceptor(getDeeps(PersistenceQualifiers.PREFERENCE_MANAGER))
        }

        single(nameDeep(NetworkQualifiers.CALL_ADAPTER_FACTORY), createdAtStart = true) { CallAdapterFactory.create() }

        single<OkHttpClient.Builder>(nameDeep(NetworkQualifiers.OKHTTP_CLIENT_BUILDER)) {
            OkHttpClient.Builder()
        }

        factory<AuthService>(nameDeep(ServiceQualifiers.AUTH_SERVICE)) {
            ServiceFactoryImpl(
                getDeeps(NetworkQualifiers.OKHTTP_CLIENT_BUILDER),
                getDeeps(NetworkQualifiers.CALL_ADAPTER_FACTORY)
            ).createService(AuthService::class.java)
        }

        factory<UserService>(nameDeep(ServiceQualifiers.USER_SERVICE)) {
            ServiceFactoryImpl(
                getDeeps<OkHttpClient.Builder>(NetworkQualifiers.OKHTTP_CLIENT_BUILDER).addInterceptor(
                    getDeeps<Interceptor>(
                        NetworkQualifiers.AUTH_INTERCEPTOR
                    )
                ),
                getDeeps(NetworkQualifiers.CALL_ADAPTER_FACTORY)
            ).createService(UserService::class.java)
        }


    }
}