package com.assembly.task.ui.main.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assembly.task.R
import com.assemblytask.models.Children
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import javax.inject.Inject


class ImageListAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var dataList = mutableListOf<Children>()
    private lateinit var itemClickListener:OnImageItemClickListener

    private val requestOptions: RequestOptions = RequestOptions()
        .centerCrop()
        .placeholder(R.drawable.loading_drawable)
        .error(R.drawable.ic_launcher_foreground)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)

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
        //Glide.with(holder.itemView.context).load(postData.data?.thumbnail).apply(requestOptions).into(viewHolder.imageView)
        //viewHolder.imageView.layout(0,0,0,0)
        Glide.with(holder.itemView.context)
        .asBitmap()
            .fitCenter()
            .load(postData.data?.thumbnail)
            .into(viewHolder.imageView)
        viewHolder.itemView.setOnClickListener {
            itemClickListener.onClick(position)
        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    interface OnImageItemClickListener{
        fun onClick(position: Int)
    }

}