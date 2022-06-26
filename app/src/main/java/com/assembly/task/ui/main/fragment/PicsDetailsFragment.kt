package com.assembly.task.ui.main.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.assembly.task.R
import com.assembly.task.databinding.PicDetailsBinding
import com.assembly.task.model.ChildrenData
import com.assembly.task.ui.main.viewmodel.PicsViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint


/**
 * [PicsDetailsFragment] Details Fragment
 */
@AndroidEntryPoint
class PicsDetailsFragment : Fragment() {

    private var _binding: PicDetailsBinding? = null

    val picsDetailsViewModel:PicsViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val requestOptions: RequestOptions
    init {
        requestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.loading_drawable)
            .error(R.drawable.ic_launcher_foreground)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PicDetailsBinding.inflate(inflater, container, false)
        Glide.with(binding.imageView.context).load((picsDetailsViewModel.selectedItem.value as ChildrenData).url).apply(requestOptions).into(binding.imageView)
        binding.title.text = picsDetailsViewModel.selectedItem.value?.title
        binding.explanation.text = picsDetailsViewModel.selectedItem.value?.authorFullname
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}