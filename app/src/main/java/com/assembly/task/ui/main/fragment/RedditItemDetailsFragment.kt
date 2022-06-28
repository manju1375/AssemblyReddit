package com.assembly.task.ui.main.fragment


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.assembly.task.R
import com.assembly.task.data.AppPreferencesHelper
import com.assembly.task.databinding.PicDetailsBinding
import com.assembly.task.model.ChildrenData
import com.assembly.task.ui.main.viewmodel.RedditDataViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * [RedditItemDetailsFragment] Details Fragment
 */
@AndroidEntryPoint
class RedditItemDetailsFragment : Fragment() {

    private var _binding: PicDetailsBinding? = null

    val picsDetailsViewModel: RedditDataViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val requestOptions: RequestOptions

    @Inject
    lateinit var  preferenceHelper:AppPreferencesHelper

    init {
        requestOptions = RequestOptions()
            .placeholder(R.drawable.loading_drawable)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PicDetailsBinding.inflate(inflater, container, false)
        when ((picsDetailsViewModel.selectedItem.value as ChildrenData).is_gallery) {
            false -> {
                Glide.with(binding.imageView.context)
                    .load((picsDetailsViewModel.selectedItem.value as ChildrenData).url)
                    .apply(requestOptions)
                    .listener(object : RequestListener<Drawable?> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: com.bumptech.glide.request.target.Target<Drawable?>,
                            isFirstResource: Boolean
                        ): Boolean {
                           binding.imageView.visibility = View.GONE
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: com.bumptech.glide.request.target.Target<Drawable?>,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            binding.imageView.visibility = View.VISIBLE
                            return false
                        }
                    }).into(binding.imageView)
            }
            else -> {
                Glide.with(binding.imageView.context)
                    .load((picsDetailsViewModel.selectedItem.value as ChildrenData).thumbnail)
                    .apply(requestOptions).into(binding.imageView)
            }
        }
        if(preferenceHelper.getFavorites()
                ?.contains(picsDetailsViewModel.selectedItem.value?.id) == true){
           binding.favoritebutton.setBackgroundResource(R.drawable.ic_favorite)
        }else{
            binding.favoritebutton.setBackgroundResource(R.drawable.ic_un_favorite)
        }
            binding.title.text = picsDetailsViewModel.selectedItem.value?.title
            binding.explanation.text =
                "${resources.getString(R.string.posted_by)} ${picsDetailsViewModel.selectedItem.value?.authorFullname}"
            binding.favoritebutton.setOnClickListener {
                if (preferenceHelper.getFavorites()
                        ?.contains(picsDetailsViewModel.selectedItem.value?.id) == true
                ) {
                    binding.favoritebutton.setBackgroundResource(R.drawable.ic_un_favorite)
                    picsDetailsViewModel.selectedItem.value?.id?.let { it1 ->
                        preferenceHelper.deleteFromFavorites(
                            it1
                        )
                    }
                } else {
                    binding.favoritebutton.setBackgroundResource(R.drawable.ic_favorite)
                    picsDetailsViewModel.selectedItem.value?.id?.let { it1 ->
                        preferenceHelper.addToFavorites(it1)
                    }
                }
            }
            return binding.root
        }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}