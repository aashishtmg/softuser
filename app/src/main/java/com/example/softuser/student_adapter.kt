package com.example.softuser

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class student_adapter (
    val lststudent: ArrayList<student>,
    val context: Context ): RecyclerView.Adapter<student_adapter.StudentViewHolder>(){

    class StudentViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val imgdp: ImageView
        val textViewname: TextView
        val textViewaddress:TextView
        val textViewage:TextView
        val textViewgender:TextView
        val idelete:ImageView

        init {
            imgdp=view.findViewById(R.id.imgdp)
            textViewname=view.findViewById(R.id.textViewname)
            textViewaddress=view.findViewById(R.id.textViewaddress)
            textViewage=view.findViewById(R.id.textViewage)
            textViewgender=view.findViewById(R.id.tvgender)
            idelete=view.findViewById(R.id.idelete)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_layout,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        val student=lststudent[position]
        holder.textViewname.text=student.sname
        holder.textViewaddress.text=student.saddress
        holder.textViewgender.text=student.sgender
        holder.textViewage.text=student.sage

        Glide.with(context).load(student.Image).into(holder.imgdp)


        holder.idelete.setOnClickListener {
            lststudent.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
            notifyItemRangeChanged(position,lststudent.size)
        }
    }

    override fun getItemCount(): Int {
        return lststudent.size
    }

}