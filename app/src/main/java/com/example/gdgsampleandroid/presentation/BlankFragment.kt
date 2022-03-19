package com.example.gdgsampleandroid.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gdgsampleandroid.R
import com.example.gdgsampleandroid.databinding.FragmentBlankBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class BlankFragment @Inject constructor(

) : Fragment() {

    private val viewModel by viewModels<BlankViewModel>()
    private var _binding:FragmentBlankBinding? = null
    private val binding:FragmentBlankBinding get() = _binding!!

    private var job: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentBlankBinding.inflate(inflater, container, false).let {
            _binding = it
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObserver()
        setUIEvent()


        binding.edInput.doOnTextChanged { text, start, before, count ->
            //todo when typing event stop for 0.5 seconds, request api

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUIEvent() {
        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_firstFragment)
        }
    }

    private fun setObserver(){
        viewModel.apiRequestData.observe(viewLifecycleOwner){
            Log.d("BlankFragment",it)
            binding.tvResult.text = it
        }
    }

}