package com.roomdatabase.room_database_hilt.interfaces

import com.roomdatabase.room_database_hilt.database.databasemodel.StudentEntity

interface StudentClickedItem {
    fun onItemClick(studentEntity: StudentEntity)
    fun onDeleteClick(studentEntity: StudentEntity)
}