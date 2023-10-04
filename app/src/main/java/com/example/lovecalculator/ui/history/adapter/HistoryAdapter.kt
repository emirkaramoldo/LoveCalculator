package com.example.lovecalculator.ui.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.databinding.ItemHistoryBinding
import com.example.lovecalculator.model.LoveModel
import java.util.Date

class HistoryAdapter(
    private val onLongClick: (LoveModel) -> Unit,
    private val onClick: (LoveModel) -> Unit,
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val list = arrayListOf<LoveModel>()

    fun addItems(items: List<LoveModel>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LoveModel, position: Int) = with(binding) {
            firstNameTv.text = item.firstName
            SecondNameTv.text = item.secondName
            percentageTv.text = item.percentage
            item.date = Date().toString()
            itemView.setOnLongClickListener {
                onLongClick(item)
                false
            }
            itemView.setOnClickListener{
                onClick(item)
            }
        }
    }
}