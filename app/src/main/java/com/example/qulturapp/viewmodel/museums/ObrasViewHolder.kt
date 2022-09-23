package com.example.qulturapp.viewmodel.museums

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.qulturapp.R
import com.example.qulturapp.model.museums.Obras

class ObrasViewHolder(view: View):RecyclerView.ViewHolder(view) {

    //val obraid = view.findViewById<TextView>(R.id.tvObraId)
    val obranom = view.findViewById<TextView>(R.id.tvObraNom)
    //val obraaudio = view.findViewById<TextView>(R.id.tvObraAudio)
    val obrafoto = view.findViewById<ImageView>(R.id.ivObra)


    fun render(obraModel: Obras){
        //obraid.id = obraModel.idObras
        obranom.text = obraModel.nomObras
        //obraaudio.text = obraModel.audObras
        Glide.with(obrafoto.context).load(obraModel.imgObras).into(obrafoto)
    }

}