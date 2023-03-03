package com.roomdatabase.room_database_hilt.database.databasemodel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDAO {
    @Query("SELECT * FROM Student ORDER BY id DESC")
    fun readAllStudents(): Flow<List<StudentEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertStudents(recentEntity: StudentEntity)

    @Query("DELETE FROM Student")
    fun deleteAllStudents()

    @Query("DELETE FROM Student WHERE id=:id")
    fun deleteStudentsById(id: String)
}