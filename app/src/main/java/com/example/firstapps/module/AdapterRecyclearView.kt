package com.example.firstapps.module

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapps.R
import com.example.firstapps.databinding.ActivityAutoCompleteTextAndCardViewBinding.inflate

class AdapterRecyclearView(var personList: MutableList<PersonData>,var context : Context) :RecyclerView.Adapter<AdapterRecyclearView.MyViewHolder>(){


    inner class MyViewHolder(var binding : View) : RecyclerView.ViewHolder(binding)
    {


    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view_design,parent,false)
         return MyViewHolder(view)

     //    var binding = inflate(LayoutInflater.from(context),parent,false)
      //   return MyViewHolder(binding.root)
     }

     override fun getItemCount(): Int {
         return personList.size
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      //  holder.binding.profileImage.setImageResource(personList[position].profileImage)
      //  holder.binding.name.text = personList[position].name
      //   holder.binding.dob.text = personList[position].dob

     }

 }