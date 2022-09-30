package com.example.qulturapp.viewmodel.museums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.qulturapp.databinding.ItemMuseumDetailBinding
import com.example.qulturapp.model.museums.MModel

class MAdapter(private var mList: List<MModel>):RecyclerView.Adapter<MAdapter.MHolder>() {
    class MHolder(val binding: ItemMuseumDetailBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MHolder {
        val binding = ItemMuseumDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MHolder(binding)
    }

    override fun onBindViewHolder(holder: MHolder, position: Int) {
        val mus = mList[position]
        holder.binding.apply {
            Glide.with(ivMusImg).load(mus.image).into(ivMusImg)
            tvMusName.text = mus.name
        }
    }

    override fun getItemCount(): Int = mList.size
}