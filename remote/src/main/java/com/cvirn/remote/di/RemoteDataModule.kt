package com.cvirn.remote.di

import com.cvirn.remote.client.httpClient
import com.cvirn.remote.repository.RemoteRepositoryImpl
import com.cvirn.remote.service.ApiServiceImpl
import io.ktor.client.HttpClient
import org.koin.dsl.module

val remoteDataModule =
    module {
        single { RemoteRepositoryImpl(get()) }
        single { provideApiService(get()) }
        single { provideHttpClient() }
    }

fun provideHttpClient(): HttpClient = httpClient()

fun provideApiService(httpClient: HttpClient): ApiServiceImpl = ApiServiceImpl(httpClient)
