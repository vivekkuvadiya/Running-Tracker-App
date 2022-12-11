package com.android.runningtracker.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.android.runningtracker.db.RunningDatabase
import com.android.runningtracker.others.Constant
import com.android.runningtracker.others.Constant.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(@ApplicationContext app:Context) = Room.databaseBuilder(
        app,RunningDatabase::class.java,RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db:RunningDatabase) = db.getRunDao()

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext app: Context) =
        app.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME,MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideName(sharedPref:SharedPreferences)  =  sharedPref.getString(Constant.KEY_NAME,"") ?:""

    @Singleton
    @Provides
    fun provideWeight(sharedPref:SharedPreferences)  =  sharedPref.getFloat(Constant.KEY_WIGHT,80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(sharedPref:SharedPreferences)  =  sharedPref.getBoolean(Constant.KEY_FIRST_TIME_TOGGLE,true)

}