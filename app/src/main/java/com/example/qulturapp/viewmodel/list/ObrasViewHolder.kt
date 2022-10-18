package com.example.qulturapp.viewmodel.list

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.qulturapp.R
import com.example.qulturapp.model.museums.Obras
import com.squareup.picasso.Picasso

class ObrasViewHolder(view: View):RecyclerView.ViewHolder(view) {

    //val obraid = view.findViewById<TextView>(R.id.tvObraId)
    val obranom = view.findViewById<Button>(R.id.tvObraNom)
    //val obraaudio = view.findViewById<TextView>(R.id.tvObraAudio)
    val obrafoto = view.findViewById<ImageView>(R.id.ivObra)


    fun render(obraModel: Obras){
        //obraid.id = obraModel.idObras
        obranom.text = obraModel.nomObras
        //obraaudio.text = obraModel.audObras
        //val ligaImg = "https://qulturaqro.live/uploads/" + item.img_sala
        //Picasso.get().load(ligaImg).into(salasImg);
    }

}