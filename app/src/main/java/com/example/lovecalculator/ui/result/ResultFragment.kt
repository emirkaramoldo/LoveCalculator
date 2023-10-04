package com.example.lovecalculator.ui.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.model.LoveViewModel
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val loveViewModel: LoveViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initClickers()
    }

    private fun initViews() {
        val loveModel = loveViewModel.loveModel
        if (loveModel != null) {
            binding.firstEd.text = loveModel.firstName
            binding.secondEd.text = loveModel.secondName
            val percentageWithSymbol = "${loveModel.percentage}%"
            binding.percentageTv.text = percentageWithSymbol
        }
    }

    private fun initClickers() {
        with(binding) {
            tryAgainBtn.setOnClickListener {
                    findNavController().navigate(R.id.navigation_home)
                }
            historyBtn.setOnClickListener {
                findNavController().navigate(R.id.navigation_history)
            }
            }
        }
}