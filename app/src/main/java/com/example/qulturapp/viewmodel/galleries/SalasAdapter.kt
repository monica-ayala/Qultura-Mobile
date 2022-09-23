package com.example.qulturapp.viewmodel.galleries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.qulturapp.R
import com.example.qulturapp.model.galleries.GalleryResults

class SalasAdapter (private val salasList: List<GalleryResults>): RecyclerView.Adapter<SalasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SalasViewHolder(layoutInflater.inflate(R.layout.item_gallery_detail, parent, false))
    }

    override fun onBindViewHolder(holder: SalasViewHolder, position: Int) {
        val item = salasList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = salasList.size
}

class SalasViewHolder(view: View):RecyclerView.ViewHolder(view) {

    //val obraid = view.findViewById<TextView>(R.id.tvObraId)
    val obranom = view.findViewById<TextView>(R.id.tv_sala_nom)
    //val obraaudio = view.findViewById<TextView>(R.id.tvObraAudio)
    val obrafoto = view.findViewById<ImageView>(R.id.iv_sala_gallery)


    fun render(salaModel: GalleryResults){
        //obraid.id = obraModel.idObras
        obranom.text = salaModel.name
            //obraaudio.text = obraModel.audObras
        Glide.with(obrafoto.context).load(salaModel.url).into(obrafoto)
    }

}