package com.hackaton.network.services

interface ServiceFactoryApi {

    fun <S>createService(apiClass: Class<S>): S
}