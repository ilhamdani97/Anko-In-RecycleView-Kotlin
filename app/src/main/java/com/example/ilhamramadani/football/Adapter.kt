package com.example.ilhamramadani.football

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ilhamramadani.football.JadwalUI.Companion.clubfootball
import org.jetbrains.anko.AnkoContext
import java.util.*

class Adapter (var list : MutableList<ModelFootball>,var listener: (ModelFootball) -> Unit): RecyclerView.Adapter<Adapter.JadwalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalViewHolder {
        return JadwalViewHolder(JadwalUI().createView((AnkoContext.create(parent.context, parent))))
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: JadwalViewHolder, position: Int) {
        holder.bindItem(list[position], listener)
    }
    inner class JadwalViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView){
        var logoclub : ImageView
        var clubnama : TextView
        init {

            logoclub = itemView.findViewById(JadwalUI.logofootball)
            clubnama = itemView.findViewById(JadwalUI.clubfootball)
        }
        fun bindItem (items : ModelFootball, listener : (ModelFootball)->Unit){
            clubnama.text = items.club
            Glide.with(itemView.context).load(items.logo).into(logoclub)
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

}