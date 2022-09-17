package com.example.qulturapp.viewmodel.Informacion

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.Info.Guia
import com.example.qulturapp.model.Info.Link

class ViewHolderLinks (view: View): RecyclerView.ViewHolder(view){
    val textLink = view.findViewById(R.id.tv_link_name) as TextView
//    val nameGuia = view.findViewById(R.id.tv_guia_name) as TextView

    fun bind(item: Link){
        textLink.text = item.link
    }

//    fun bindGuia(item: Guia){
//        nameGuia.text = item.name
//    }
}

class ViewHolderGuias (view: View): RecyclerView.ViewHolder(view){
    val nameGuia = view.findViewById(R.id.tv_guia_name) as TextView


    fun bindGuia(item: Guia){
        nameGuia.text = item.name
    }
}