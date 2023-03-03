package com.roomdatabase.room_database_hilt.database.databasemodel

import android.content.Context
import com.roomdatabase.room_database_hilt.database.DataBaseStudent
import com.roomdatabase.room_database_hilt.repository.StudentRepositoryDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DBModuleProvider {

    @Provides
    fun provideStudentDAO(@ApplicationContext appContext: Context) : StudentDAO {
        return DataBaseStudent.getInstance(appContext).studentDao
    }
    @Provides
    fun provideRepositoryDB(studentDAO: StudentDAO) = StudentRepositoryDB(studentDAO)

}