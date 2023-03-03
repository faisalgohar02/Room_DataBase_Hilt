package com.roomdatabase.room_database_hilt.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.roomdatabase.room_database_hilt.database.databasemodel.StudentDAO
import com.roomdatabase.room_database_hilt.database.databasemodel.StudentEntity

@Database(entities = [StudentEntity::class], version = 1, exportSchema = false)
abstract class DataBaseStudent: RoomDatabase() {
    abstract val studentDao: StudentDAO

    companion object {
        @Volatile
        private var INSTANCE: DataBaseStudent? = null

        fun getInstance(context: Context): DataBaseStudent {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBaseStudent::class.java,
                        "DataBase_Student_Impl"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}