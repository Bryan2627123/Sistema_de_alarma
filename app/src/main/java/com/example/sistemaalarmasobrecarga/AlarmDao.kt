package com.example.sistemaalarmasobrecarga

import androidx.room.*

@Dao
interface AlarmDao {
    @Insert
    suspend fun insert(alarm: Alarm)

    @Query("SELECT * FROM Alarm ORDER BY id DESC LIMIT 1")
    suspend fun getLastAlarm(): Alarm?

    @Delete
    suspend fun delete(alarm: Alarm)
}
