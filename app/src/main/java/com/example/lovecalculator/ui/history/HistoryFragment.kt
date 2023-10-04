package com.example.lovecalculator.ui.history

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.ui.history.adapter.HistoryAdapter

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private val adapter = HistoryAdapter(this::onLongClick, this::onClick)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        val data = App.appDatabase.loveDao().getAll()
        adapter.addItems(data)
        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.navigation_home)
        }
    }

    private fun onClick(item: LoveModel){
        val alert = AlertDialog.Builder(requireContext())
            .setTitle("Информация")
            .setMessage("Дата создания:")
        alert.create().show()
    }

    private fun onLongClick(item: LoveModel) {
        val alert = AlertDialog.Builder(requireContext())
            .setTitle("Вы хотите удалить?")
            .setPositiveButton("Да"){_, _ ->
                App.appDatabase.loveDao().delete(item)
                setData()
            }
            .setNegativeButton("Нет"){dialog, _ -> dialog.dismiss()
            }
        alert.create().show()
    }

    private fun setData(){
        val data = App.appDatabase.loveDao().getAll()
        adapter.addItems(data)
    }
}