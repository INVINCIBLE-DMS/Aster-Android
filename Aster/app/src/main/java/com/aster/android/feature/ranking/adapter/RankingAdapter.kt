package com.aster.android.feature.ranking.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aster.android.R
import com.aster.android.feature.ranking.model.RankingResponse

class RankingAdapter(
    private val itemList: List<RankingResponse>,
    private val context: Context
) : RecyclerView.Adapter<RankingAdapter.RankingViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RankingAdapter.RankingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ranking_item, parent, false)
        return RankingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        val grade = itemList[position].grade.toString()
        val classNum = itemList[position].classNumber.toString()
        val candyNum = itemList[position].candyCount.toString()
        val rank = (position + 1).toString()

        holder.classGrade.text = "$grade 학년 $classNum 반"
        holder.count.text = "$candyNum 개"
        holder.rank.text = "$rank 위"
    }

    class RankingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val classGrade: TextView = itemView.findViewById(R.id.tv_ranking_item_class)
        val count: TextView = itemView.findViewById(R.id.tv_ranking_item_count)
        val rank: TextView = itemView.findViewById(R.id.tv_ranking_item_rank)
    }

}