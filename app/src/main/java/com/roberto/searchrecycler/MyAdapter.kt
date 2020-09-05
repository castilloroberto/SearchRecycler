package com.roberto.searchrecycler

import android.content.Context
import android.content.Intent
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_card.view.*

class MyAdapter(private val arrayList: ArrayList<Model>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var codePack: String? = null


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(model: Model) {

            itemView.tv_titulo.text = model.title
            itemView.tv_desc.text = model.desc
            itemView.tv_price.text = model.price
            itemView.tv_code.text = model.code


        }

        init {
            itemView.setOnClickListener { v: View? ->
//                val position: Int = adapterPosition
//
//                Toast.makeText(
//                    itemView.context,
//                    "codigo: ${itemView.tv_code.text}",
//                    Toast.LENGTH_SHORT
//                ).show()
//                itemView.tv_titulo.text
            }
        }
    }

    // local 
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.items_card, parent, false)

        return ViewHolder(v)
    }

    // local
    override fun getItemCount(): Int {
        return arrayList.size
    }

    // local
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {
            val location = arrayList.get(position)
            var gTitle: String = location.title
            var gCode = location.code

            val inte = Intent(context,an)
        }

    }
}   