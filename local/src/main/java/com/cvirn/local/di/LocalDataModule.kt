package com.cvirn.local.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.cvirn.local.LocalDataRepositoryImpl
import org.koin.dsl.module
import sqldelight.db.Database

val localDataModule =
    module {
        single<SqlDriver> {
            AndroidSqliteDriver(
                schema = Database.Schema,
                context = get(),
                name = "app_database.db",
            )
        }
        single { Database(get()) }
        single { LocalDataRepositoryImpl(get()) }
    }
