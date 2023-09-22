package com.example.myproject_kotlin.WaterQuality

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject_kotlin.R

class WaterQualityAdapter (private val waterQualityList: List<WaterQualityData>): RecyclerView.Adapter<WaterQualityAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val updateDate: TextView = itemView.findViewById(R.id.updateDate)
        val updateTime: TextView = itemView.findViewById(R.id.updateTime)
        val codeName: TextView = itemView.findViewById(R.id.codeName)
        val longitude: TextView = itemView.findViewById(R.id.longitude)
        val latitude: TextView = itemView.findViewById(R.id.latitude)
        val quaId: TextView = itemView.findViewById(R.id.qua_id)
        val quaCntu: TextView = itemView.findViewById(R.id.qua_cntu)
        val quaCl: TextView = itemView.findViewById(R.id.qua_cl)
        val quaPh: TextView = itemView.findViewById(R.id.qua_ph)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.waterqualityitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = waterQualityList[position]
        holder.updateDate.text = data.update_date
        holder.updateTime.text = data.update_time
        holder.codeName.text = data.code_name
        holder.longitude.text = data.longitude
        holder.latitude.text = data.latitude
        holder.quaId.text = data.qua_id
        holder.quaCntu.text = data.qua_cntu
        holder.quaCl.text = data.qua_cl
        holder.quaPh.text = data.qua_ph
    }

    override fun getItemCount(): Int {
        return waterQualityList.size
    }
}