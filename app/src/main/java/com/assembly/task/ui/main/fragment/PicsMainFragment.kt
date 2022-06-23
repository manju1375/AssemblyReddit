package com.assembly.task.ui.main.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.assembly.task.api.network.Resource
import com.assembly.task.databinding.LayoutGalleryBinding
import com.assembly.task.ui.main.adapter.ImageListAdapter
import com.assembly.task.ui.main.viewmodel.PicsViewModel
import com.assemblytask.models.PicsModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Developed by Manjunath on 19,June,2022
 */

@AndroidEntryPoint
class PicsMainFragment : Fragment() {

    companion object {
        fun newInstance() = PicsMainFragment()
    }

    private var _binding: LayoutGalleryBinding? = null

    private val binding get() = _binding!!

    private val picsViewModel: PicsViewModel by activityViewModels()

    @Inject
    lateinit var adapter: ImageListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LayoutGalleryBinding.inflate(inflater, container, false)
        binding.recyclerview.adapter = adapter
        picsViewModel.getPics()
        picsViewModel.picsModelResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    (it.value as PicsModel).data?.children?.let { it1 -> adapter.setDetails(it1) }
                }
                is Resource.Failure -> {

                }
            }
        }
        return _binding!!.root
    }
}