package com.demo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.data.models.entity.CanadaInfoEntity

/**
 * Data Access Object for the Canada Facts
 */
@Dao
interface CanadaInfoDao {
    /**
     * Select all information from CanadaInfoEntity table
     *
     * @return list of CanadaInfoEntity
     */
    @Query("SELECT * FROM CanadaInfoEntity")
    suspend fun getAllCanadaInfo(): List<CanadaInfoEntity>

    /**
     * Insert all Canada information to the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCanadaInfo(canadaInfo: List<CanadaInfoEntity?>?)

    /**
     * Delete all Canada Info
     */
    @Query("DELETE FROM CanadaInfoEntity")
    suspend fun deleteAllCanadaInfo()

    /**
     * Find the number of rows in the table to check cache
     */
    @Query("SELECT COUNT(*) FROM CanadaInfoEntity")
    suspend fun isCacheAvailable(): Int
}