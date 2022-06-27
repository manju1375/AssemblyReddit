package com.assembly.task.ui.main.adapter


import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.assembly.task.R
import com.assembly.task.util.convertLongToTime
import com.assemblytask.models.Children
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_image.view.*
import javax.inject.Inject


class ImageListAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var dataList = mutableListOf<Children>()
    private lateinit var itemClickListener:OnImageItemClickListener

    fun setOnItemClickListener(itemClickListener: OnImageItemClickListener){
        this.itemClickListener = itemClickListener
    }

    fun setDetails(list: List<Children>) {
        this.dataList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageItemViewHolder(view) //object of ImagePostViewHolder will return

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val postData = dataList[position]
        val viewHolder = holder as ImageItemViewHolder
        Glide.with(holder.itemView.context)
            .asDrawable()
            .fitCenter()
            .load(postData.data?.thumbnail)
            .listener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable?>,
                    isFirstResource: Boolean
                ): Boolean {
                    viewHolder.itemView.progressDialog.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable?>,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    viewHolder.itemView.progressDialog.visibility = View.GONE
                    return false
                }
            })

            .into(viewHolder.imageView)
        viewHolder.itemView.setOnClickListener {
            itemClickListener.onClick(position)
        }
        viewHolder.itemView.titletv.apply {
            this.text = postData.data?.title
        }
        viewHolder.itemView.timestamptv.apply {
            text = "posted On "+(postData.data?.created?.let { convertLongToTime(it) })
        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    interface OnImageItemClickListener{
        fun onClick(position: Int)
    }



}