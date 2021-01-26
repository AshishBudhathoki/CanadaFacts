package com.demo.aboutcanada.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.demo.data.db.AppDatabase
import com.demo.data.db.CanadaInfoDao
import com.demo.data.utils.SharedPrefsHelper
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            SharedPrefsHelper.PREF_NAME,
            Context.MODE_PRIVATE
        )
    }

    @Singleton
    @Provides
    fun provideDb(context: Context, @Named("databaseName") dbName: String): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            dbName
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Named("databaseName")
    fun provideDatabaseName(): String = "CanadaInfo.db"

    @Singleton
    @Provides
    fun provideCanadaInfoDao(appDatabase: AppDatabase): CanadaInfoDao =
        appDatabase.canadaInfoDao()
}