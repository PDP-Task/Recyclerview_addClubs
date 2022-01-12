package com.example.recyclerview_add_clubs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_add_clubs.databinding.ItemLayoutBinding
import com.example.recyclerview_add_clubs.model.Club

class ClubAdapter : RecyclerView.Adapter<ClubAdapter.ClubHolder>() {
    private val clubList = ArrayList<Club>()

    inner class ClubHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val bin = ItemLayoutBinding.bind(item)
        fun bind(club: Club) = with(bin) {
            imageItem.setImageResource(club.image)
            textItem.text = club.title
        }

        init {
            item.setOnClickListener {
                clubList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ClubHolder(view)
    }

    override fun onBindViewHolder(holder: ClubHolder, position: Int) {
        holder.bind(clubList[position])
    }

    override fun getItemCount(): Int {
        return clubList.size
    }

    fun addClub(club: Club) {
        clubList.add(club)
        notifyDataSetChanged()
    }
}