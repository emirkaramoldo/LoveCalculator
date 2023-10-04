package com.example.lovecalculator.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.presenter.HomePresenter
import com.example.lovecalculator.view.HomeView
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHomeBinding
import com.example.lovecalculator.model.LoveModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeView {

    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var presenter: HomePresenter

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
        presenter.setView(this)
        presenter.showOnBoard()
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculatorBtn.setOnClickListener {
                    presenter.getLove(firstEd.text.toString(), secondEd.text.toString())
                }
            }
    }

    override fun changeFragment(loveModel: LoveModel) {
        findNavController().navigate(R.id.navigation_result)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateOnBoardFragment() {
        findNavController().navigate(R.id.navigation_on_board)
    }
}