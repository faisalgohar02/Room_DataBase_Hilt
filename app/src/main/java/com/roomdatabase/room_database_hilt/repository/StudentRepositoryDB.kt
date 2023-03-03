package com.roomdatabase.room_database_hilt.repository

import com.roomdatabase.room_database_hilt.database.databasemodel.StudentDAO
import com.roomdatabase.room_database_hilt.database.databasemodel.StudentEntity
import javax.inject.Inject

class StudentRepositoryDB @Inject constructor(private val studentDAO: StudentDAO) {
    fun insertStudentData(studentEntity: StudentEntity) = studentDAO.insertStudents(studentEntity)
    fun readAllStudent() = studentDAO.readAllStudents()
    fun deleteAllStudent( ) = studentDAO.deleteAllStudents()
    fun deleteStudentById(id: String) = studentDAO.deleteStudentsById(id)
}