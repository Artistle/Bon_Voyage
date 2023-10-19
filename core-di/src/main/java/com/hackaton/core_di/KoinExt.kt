package com.hackaton.core_di

import com.hackaton.core_di.qualifiers.Qualifiers
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.StringQualifier
import org.koin.core.qualifier.named
import org.koin.core.qualifier.qualifier
import org.koin.core.registry.ScopeRegistry
import org.koin.core.scope.Scope

inline fun <reified T : Any> Scope.getDeeps(
    nameDeeps: Qualifiers,
    noinline parameters: ParametersDefinition? = null,
): T {
    return get(T::class, named(nameDeeps.toString().lowercase()), parameters)
}

fun nameDeep(qualifier: Qualifiers) = qualifier.qualifier
val Qualifiers.qualifier
    get(): Qualifier {
        return StringQualifier(this.toString().lowercase())
    }


