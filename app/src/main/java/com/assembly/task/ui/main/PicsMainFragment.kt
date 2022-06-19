package com.assembly.task.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.assembly.task.api.network.Resource
import com.assembly.task.databinding.FragmentMainBinding
import com.assembly.task.ui.main.viewmodel.PicsViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Developed by Manjunath on 19,June,2022
 */

@AndroidEntryPoint
class PicsMainFragment : Fragment() {

    companion object {
        fun newInstance() = PicsMainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val picsViewModel:PicsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        picsViewModel.getPics()
        picsViewModel.picsModelResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success ->{
                    Log.d("Result Data",it.value.toString())
                }
                is Resource.Failure ->{

                }
            }
        })

        return _binding!!.root
    }
}