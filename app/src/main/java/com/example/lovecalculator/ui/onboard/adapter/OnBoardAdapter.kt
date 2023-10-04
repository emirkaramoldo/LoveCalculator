package com.example.lovecalculator.ui.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnBoardBinding
import com.example.lovecalculator.model.OnBoard

class OnBoardAdapter(
    private val onClick: () -> Unit,
) :
    Adapter<OnBoardAdapter.OnBoardViewHolder>() {


    private val list = arrayListOf(
        OnBoard(
            "Have a good time",
            "You should take the time to help those who need you",
            R.drawable.onboard_1,

        ),
        OnBoard(
            "Cherishing love",
            "It is now no longer possible for you to cherish love",
            R.drawable.onboard_2,

        ),
        OnBoard(
            "Have a breakup",
            "We have made the correction for you don't worry \n" +
                    "Maybe someone is waiting for you",
            R.drawable.onboard_3,
        ),
        OnBoard(
            "Let's find your couple!",
            "Don't waste time when you can become happy right now!",
            R.drawable.logo,
    )
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) = with(binding) {
            tvTitle.text = onBoard.title
            tvDesc.text = onBoard.description
            onBoard.image?.let { ivBoard.setImageResource(it) }
            binding.btnStart.isVisible = adapterPosition == list.lastIndex
            binding.btnSkip.isVisible = adapterPosition != list.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }
            binding.btnSkip.setOnClickListener {
                onClick()
            }
        }
    }
}