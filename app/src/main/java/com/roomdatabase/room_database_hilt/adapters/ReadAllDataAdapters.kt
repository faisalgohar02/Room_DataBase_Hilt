package com.roomdatabase.room_database_hilt.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roomdatabase.room_database_hilt.database.databasemodel.StudentEntity
import com.roomdatabase.room_database_hilt.databinding.StudentAdapterItemsBinding
import com.roomdatabase.room_database_hilt.interfaces.StudentClickedItem

class ReadAllDataAdapters(
    private var studentList: List<StudentEntity>? = null,
    private var listener: StudentClickedItem? = null
) : RecyclerView.Adapter<ReadAllDataAdapters.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        StudentAdapterItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val studentListItems = studentList?.get(position)
        holder.binding.run {

            nameTxt.text="${studentListItems?.name}"
            addressTxt.text="${studentListItems?.address}"
            mobileTxt.text="${studentListItems?.mobils}"

            deleteBtn.setOnClickListener {
                listener?.onDeleteClick(studentListItems!!)
            }

        }
    }
    override fun getItemCount(): Int = studentList!!.size
    inner class ViewHolder(val binding: StudentAdapterItemsBinding) : RecyclerView.ViewHolder(binding.root)

}