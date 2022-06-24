package com.assembly.task.ui.main.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.app.ActivityCompat.invalidateOptionsMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.assembly.task.api.network.Resource
import com.assembly.task.databinding.LayoutGalleryBinding
import com.assembly.task.ui.main.adapter.ImageListAdapter
import com.assembly.task.ui.main.viewmodel.PicsViewModel
import com.assemblytask.models.PicsModel
import com.assemblytask.models.SubRedditModel
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

    var subRedditTypes = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LayoutGalleryBinding.inflate(inflater, container, false)
        binding.recyclerview.adapter = adapter
        picsViewModel.getPics("news")
        picsViewModel.getSubRedditTypes()
        picsViewModel.subRedditModelResponse.observe(viewLifecycleOwner){
            when(it){
                is Resource.Success ->{
                    val subRedditChildrenList = (it.value as SubRedditModel).data?.children
                    if (subRedditChildrenList != null) {
                        for(redditItem in subRedditChildrenList){
                            redditItem.data?.displayName?.let { it1 -> subRedditTypes.add(it1) }
                        }
                    }
                    activity?.invalidateOptionsMenu()
                }
            }
        }
        picsViewModel.picsModelResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    (it.value as PicsModel).data?.children?.let { it1 -> adapter.setDetails(it1) }
                }
                is Resource.Failure -> {

                }
            }
        }
        setHasOptionsMenu(true)
        return _binding!!.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        for(item in subRedditTypes){
            menu.add(item)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        picsViewModel.getPics(item.title.toString())
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
}