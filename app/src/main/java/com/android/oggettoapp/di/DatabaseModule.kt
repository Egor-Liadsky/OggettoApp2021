package com.android.oggettoapp.di

import android.content.Context
import androidx.room.Room
import com.android.oggettoapp.data.local.database.OggettoRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            OggettoRoomDatabase::class.java,
            "oggetto_db"
        ).fallbackToDestructiveMigration().build()


    @Provides
    @Singleton
    fun provideEventDao(db: OggettoRoomDatabase) = db.eventDao()

    @Provides
    @Singleton
    fun provideUserDao(db: OggettoRoomDatabase) = db.userDao()
}