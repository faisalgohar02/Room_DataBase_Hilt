package com.roomdatabase.room_database_hilt.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roomdatabase.room_database_hilt.database.databasemodel.StudentEntity
import com.roomdatabase.room_database_hilt.repository.StudentRepositoryDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor(private val studentRepositoryDB: StudentRepositoryDB) :
    ViewModel(), LifecycleObserver {

    fun insertStudentData(studentEntity: StudentEntity) = viewModelScope.launch(Dispatchers.IO) {
        studentRepositoryDB.insertStudentData(studentEntity)
    }

    fun readAllStudentData() = studentRepositoryDB.readAllStudent()

    fun deleteAllStudentData() = viewModelScope.launch(Dispatchers.IO) {
        studentRepositoryDB.deleteAllStudent()
    }

    fun deleteStudentDataBYId(id:String) = viewModelScope.launch(Dispatchers.IO) {
        studentRepositoryDB.deleteStudentById(id)
    }

}