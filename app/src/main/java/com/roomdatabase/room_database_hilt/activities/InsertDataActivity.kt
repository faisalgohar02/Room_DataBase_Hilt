package com.roomdatabase.room_database_hilt.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.roomdatabase.room_database_hilt.R
import com.roomdatabase.room_database_hilt.database.databasemodel.StudentEntity
import com.roomdatabase.room_database_hilt.databinding.ActivityInsertDataBinding
import com.roomdatabase.room_database_hilt.viewmodel.StudentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InsertDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInsertDataBinding
    private var studentViewModel:StudentViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityInsertDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        studentViewModel= ViewModelProvider(this).get(StudentViewModel::class.java)

        binding.insertBtn.setOnClickListener {

            if(binding.nameEdt.text.toString().isNotEmpty() && binding.addressEdt.text.toString().isNotEmpty() && binding.mobileEdt.text.toString().isNotEmpty())
            {
                val studentEntity=StudentEntity(0,binding.nameEdt.text.toString(), binding.addressEdt.text.toString(),binding.mobileEdt.text.toString())
                studentViewModel?.insertStudentData(studentEntity)

                binding.nameEdt.setText("")
                binding.addressEdt.setText("")
                binding.mobileEdt.setText("")

                Toast.makeText(this, "Insert Successfully.", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "All Fields Are Necessary.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}