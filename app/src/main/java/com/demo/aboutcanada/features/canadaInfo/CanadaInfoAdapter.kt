package com.demo.aboutcanada.features.canadaInfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.demo.aboutcanada.R
import com.demo.aboutcanada.model.CanadaInfoUiModel
import com.demo.aboutcanada.utils.GlideApp
import kotlinx.android.synthetic.main.item_canada_info.view.*
import javax.inject.Inject

class CanadaInfoAdapter @Inject constructor(
    private val items: List<CanadaInfoUiModel>,
) : RecyclerView.Adapter<CanadaInfoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_canada_info, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(canadaInfoUiModel: CanadaInfoUiModel) {
            itemView.apply {
                canadaInfoUiModel?.let {
                    tvTitle.text = it.title
                    tvDescription.text = it.description
                    ivImage.loadImage(it.imageHref.toString())
                }
            }


        }

    }
}

fun ImageView.loadImage(url: String) {
    GlideApp.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}
