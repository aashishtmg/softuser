package com.example.softuser.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softuser.NavBarActivity
import com.example.softuser.R
import com.example.softuser.student_adapter

class HomeFragment : Fragment() {

    private lateinit var studentlayout : RecyclerView


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        studentlayout= view.findViewById(R.id.recyclerview)
        studentlayout.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        studentlayout.adapter= student_adapter((activity as NavBarActivity).lstStudent,requireContext())

        return view
    }
}