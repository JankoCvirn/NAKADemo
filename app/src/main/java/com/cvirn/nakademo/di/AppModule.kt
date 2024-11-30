package com.cvirn.nakademo.di

import com.cvirn.nakademo.usecase.RemoteUserUseCaseImpl
import com.cvirn.nakademo.usecase.UserCrudUseCaseImpl
import com.cvirn.nakademo.viewmodel.HomeScreenViewModel
import com.cvirn.nakademo.viewmodel.RemoteUsersViewModel
import com.cvirn.nakademo.viewmodel.StatisticsScreenViewModel
import com.cvirn.nakademo.viewmodel.UserPostsViewModel
import com.cvirn.nakademo.viewmodel.UserScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {

        single { UserCrudUseCaseImpl(get()) }
        single { RemoteUserUseCaseImpl(get()) }

        viewModel { HomeScreenViewModel(get()) }
        viewModel { UserScreenViewModel(get()) }
        viewModel { StatisticsScreenViewModel(get()) }
        viewModel { RemoteUsersViewModel(get()) }
        viewModel { UserPostsViewModel(get()) }
    }
