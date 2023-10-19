package com.hackaton.repository_impl.module

import com.hackaton.core_di.getDeeps
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.PersistenceQualifiers
import com.hackaton.core_di.qualifiers.RepositoryQualifiers
import com.hackaton.core_di.qualifiers.ServiceQualifiers
import com.hackaton.repository.AuthRepository
import com.hackaton.repository.HabitationRepository
import com.hackaton.repository.UserRepository
import com.hackaton.repository_impl.AuthRepositoryImpl
import com.hackaton.repository_impl.HabitationRepositoryImpl
import com.hackaton.repository_impl.UserRepositoryImpl
import org.koin.dsl.module

object RepositoryModule {

    val repositoryModule = module {
        factory<AuthRepository>(nameDeep(RepositoryQualifiers.AUTH_REPOSITORY)) {
            AuthRepositoryImpl(
                getDeeps(ServiceQualifiers.AUTH_SERVICE),
                getDeeps(PersistenceQualifiers.PREFERENCE_MANAGER)
            )
        }

        factory<UserRepository>(nameDeep(RepositoryQualifiers.USER_REPOSITORY)) {
            UserRepositoryImpl(
                getDeeps(ServiceQualifiers.USER_SERVICE),
                getDeeps(PersistenceQualifiers.PREFERENCE_MANAGER)
            )
        }

        factory<HabitationRepository>(nameDeep(RepositoryQualifiers.HABITATION_REPOSITORY)) {
            HabitationRepositoryImpl(getDeeps(ServiceQualifiers.HABITATION_SERVICE))
        }
    }
}