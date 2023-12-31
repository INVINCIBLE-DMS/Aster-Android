package com.aster.android.feature.feed.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aster.android.R
import com.aster.android.feature.feed.model.FeedResponse
import com.bumptech.glide.Glide

class FeedAdapter(
    private val itemList: List<FeedResponse>,
    private val context: Context,
): RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_feed_item_title)
        val time: TextView = itemView.findViewById(R.id.tv_feed_item_time)
        val writerImg: ImageView = itemView.findViewById(R.id.iv_feed_item_writer)
        val writer: TextView = itemView.findViewById(R.id.tv_feed_item_writer)
        val likeImg : ImageView = itemView.findViewById(R.id.iv_feed_item_like_inactive)
        val likeNum: TextView = itemView.findViewById(R.id.tv_feed_item_like_count)
        val feedImg : ImageView = itemView.findViewById(R.id.iv_feed_item)
        val chatNum : TextView = itemView.findViewById(R.id.tv_feed_item_chat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return FeedAdapter.FeedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.apply {
            title.text = itemList[position].content
            time.text = itemList[position].createdAt.toString()
            Glide
                .with(context)
                .load(itemList[position].profileImgUrl)
                .into(writerImg)
            writer.text = itemList[position].username
            likeNum.text = itemList[position].likeCount.toString()
            Glide
                .with(context)
                .load(itemList[position].feedImgUrl)
                .into(feedImg)
            chatNum.text = itemList[position].commentCount.toString()
        }
    }
}