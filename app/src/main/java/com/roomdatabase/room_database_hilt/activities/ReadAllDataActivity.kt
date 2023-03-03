package com.roomdatabase.room_database_hilt.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.roomdatabase.room_database_hilt.adapters.ReadAllDataAdapters
import com.roomdatabase.room_database_hilt.database.databasemodel.StudentEntity
import com.roomdatabase.room_database_hilt.databinding.ActivityReadAllDataBinding
import com.roomdatabase.room_database_hilt.interfaces.StudentClickedItem
import com.roomdatabase.room_database_hilt.viewmodel.StudentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ReadAllDataActivity : AppCompatActivity(), StudentClickedItem {

    private lateinit var binding: ActivityReadAllDataBinding
    private var readAllDataAdapters: ReadAllDataAdapters? = null
    private var studentViewModel: StudentViewModel? = null
    private val studentList: ArrayList<StudentEntity> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityReadAllDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentViewModel= ViewModelProvider(this).get(StudentViewModel::class.java)

        lifecycleScope.launch {
            studentViewModel?.readAllStudentData()?.collect() { songList: List<StudentEntity> ->
                studentList.clear()
                studentList.addAll(songList)
                readAllDataAdapters?.notifyDataSetChanged()

            }
        }

        binding.recyclerView.setLayoutManager(LinearLayoutManager(this))
        readAllDataAdapters = ReadAllDataAdapters(studentList, this)
        binding.recyclerView.setAdapter(readAllDataAdapters)
    }
    override fun onItemClick(studentEntity: StudentEntity) {

    }

    override fun onDeleteClick(studentEntity: StudentEntity) {
        studentViewModel?.deleteStudentDataBYId(studentEntity.id.toString())
    }

}