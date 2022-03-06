package com.iraimjanov.codialapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iraimjanov.codialapp.databinding.ItemMentorsBinding
import com.iraimjanov.codialapp.models.Mentors

class MentorsAdapter(val context: Context, private val arrayList: ArrayList<Mentors> , var rvClickMentors: RVClickMentors) :
    RecyclerView.Adapter<MentorsAdapter.VH>() {

    inner class VH(private var itemRV: ItemMentorsBinding) : RecyclerView.ViewHolder(itemRV.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(mentors: Mentors) {
            itemRV.tvName.text = "${mentors.name} ${mentors.surname}"
            itemRV.tvNumber.text = mentors.patronymic
            itemRV.cardDelete.setOnClickListener {
                rvClickMentors.onClickDelete(mentors)
            }
            itemRV.cardEdit.setOnClickListener {
                rvClickMentors.onClickEdit(mentors)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemMentorsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(arrayList[position])

    }

    override fun getItemCount(): Int = arrayList.size

    interface RVClickMentors {
        fun onClickEdit(mentors: Mentors) {

        }

        fun onClickDelete(mentors: Mentors) {

        }
    }

}