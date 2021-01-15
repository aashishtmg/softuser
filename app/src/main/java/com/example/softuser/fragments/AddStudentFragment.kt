package com.example.softuser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.softuser.R


class AddStudentFragment : Fragment() {
    private lateinit var uname: EditText
    private lateinit var uaddress: EditText
    private lateinit var umobile: EditText
    private lateinit var uage: EditText
    private lateinit var rbmale: RadioButton
    private lateinit var rbfemale: RadioButton
    private lateinit var btnsubmit: Button
    private lateinit var radiogroupp: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_add_student, container, false)
        uname = view.findViewById(R.id.uname)
        uaddress = view.findViewById(R.id.uaddress)
        uage = view.findViewById(R.id.uage)
        rbmale = view.findViewById(R.id.rbmale)
        rbfemale = view.findViewById(R.id.rbfemale)
        btnsubmit = view.findViewById(R.id.btnsubmit)
        radiogroupp = view.findViewById(R.id.radiogroupp)



        radiogroupp?.setOnCheckedChangeListener { group, checkedId ->
            var gender = ""
            gender += if (R.id.rbmale == checkedId) "male" else "female"
        }
        radiogroupp.check(R.id.rbmale)

        btnsubmit.setOnClickListener {

        }

        return view

    }
}