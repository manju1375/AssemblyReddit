package com.assembly.task.ui.main.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.assembly.task.R
import com.assembly.task.api.network.Resource
import com.assembly.task.databinding.LayoutGalleryBinding
import com.assembly.task.ui.main.adapter.ImageListAdapter
import com.assembly.task.ui.main.viewmodel.PicsViewModel
import com.assemblytask.models.PicsModel
import com.assembly.task.model.subreddittypes.SubRedditChildren
import com.assembly.task.model.subreddittypes.SubRedditModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.layout_gallery.*
import javax.inject.Inject


/**
 * Developed by Manjunath on 19,June,2022
 */

@AndroidEntryPoint
class PicsMainFragment : Fragment(), ImageListAdapter.OnImageItemClickListener {

    companion object {
        fun newInstance() = PicsMainFragment()
    }

    private var _binding: LayoutGalleryBinding? = null

    private val binding get() = _binding!!

    private val picsViewModel: PicsViewModel by activityViewModels()

    @Inject
    lateinit var adapter: ImageListAdapter

    var subRedditTypes = mutableListOf<String>()

    var subRedditChildrenList = mutableListOf<SubRedditChildren>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LayoutGalleryBinding.inflate(inflater, container, false)
        binding.recyclerview.adapter = adapter
        picsViewModel.subRedditModelResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    if (subRedditChildrenList.size == 0) {
                        subRedditChildrenList = (it.value as SubRedditModel).data?.children!!
                        for (redditItem in subRedditChildrenList) {
                            redditItem.data?.displayName?.let { it1 -> subRedditTypes.add(it1) }
                        }
                    }
                    activity?.invalidateOptionsMenu()
                }
            }
        }
        picsViewModel.picsModelResponse.observe(viewLifecycleOwner) {
            progressDialog.visibility = View.GONE
            when (it) {
                is Resource.Success -> {
                    (it.value as PicsModel).data?.children?.let { it1 -> adapter.setDetails(it1) }
                }
                is Resource.Failure -> {

                }
            }
        }
        setHasOptionsMenu(true)
        adapter.setOnItemClickListener(this)
        return _binding!!.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        for (item in subRedditTypes) {
            menu.add(item)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        binding.progressDialog.visibility = View.VISIBLE
        picsViewModel.getPics(item.title.toString())
        (activity as AppCompatActivity?)!!.supportActionBar!!.title =
            "${resources.getString(R.string.redditstring)}  ${item.title.toString()}"
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        picsViewModel.getPics(resources.getString(R.string.gaming))
        picsViewModel.getSubRedditTypes()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title =
            "${resources.getString(R.string.redditstring)}  ${resources.getString(R.string.gaming)}"
    }

    override fun onClick(position: Int) {
        picsViewModel.selectedItem.postValue(
            adapter.dataList[position].data
        )
        findNavController().navigate(R.id.action_picsMainFragment_to_picsDetailsFragment)
    }
}