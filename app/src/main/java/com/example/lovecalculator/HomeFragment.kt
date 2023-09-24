package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val loveViewModel: LoveViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculatorBtn.setOnClickListener {
                RetrofitService().api.countCompability(
                    firstEd.text.toString(),
                    secondEd.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        loveViewModel.loveModel = response.body()
                        findNavController().navigate(R.id.navigation_result)
                    }
                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}