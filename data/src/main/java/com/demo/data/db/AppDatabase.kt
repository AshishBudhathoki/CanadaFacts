package com.demo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.data.models.entity.CanadaInfoEntity

/**
 * Room Database
 */

@Database(entities = [CanadaInfoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun canadaInfoDao(): CanadaInfoDao
}