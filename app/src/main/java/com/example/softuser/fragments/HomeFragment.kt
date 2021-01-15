package com.example.softuser.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softuser.R
import com.example.softuser.student
import com.example.softuser.student_adapter


class HomeFragment : Fragment() {
    private var lstStudent = ArrayList<student>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerview)


        return view


        loadStudent()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.apply {
            val adapter = student_adapter(lstStudent, context)
            recyclerView.layoutManager=LinearLayoutManager(context)
            recyclerView.adapter=adapter

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1)
            if (resultCode==Activity.RESULT_OK){
                var student= data?.getSerializableExtra("tag")as student
                lstStudent.add(student)
                recyclerView.adapter?.notifyDataSetChanged();
            }
    }
    private fun loadStudent(){
        lstStudent.add(student(0, "Aashish Tamang", "Kathmandu", "22", "Male" ))
    }
}