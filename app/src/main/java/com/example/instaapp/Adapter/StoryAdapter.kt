package com.example.instaapp.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instaapp.Response.myResponseItem
import com.example.instaapp.R
import de.hdodenhof.circleimageview.CircleImageView

class StoryAdapter(val context: Context,var storyList: ArrayList<myResponseItem>):RecyclerView.Adapter<StoryAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val ivStoryProfile=itemView.findViewById<CircleImageView>(R.id.ivStoryProfile)
        val tvStoryName=itemView.findViewById<TextView>(R.id.tvStoryName)
    }
    fun setListData(data:ArrayList<myResponseItem>){
        this.storyList=data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_story_item,parent,false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StoryAdapter.ViewHolder, position: Int) {
//        holder.ivStoryProfile.setImageResource(storyList[position].profileimage)
        Glide.with(context)
            .load(storyList[position].profileimage)
//            .placeholder(R.drawable.loading)
            .error(R.drawable.profile)
            .into(holder.ivStoryProfile)

        if(storyList[position].name==null || storyList[position].name.isEmpty()){
            holder.tvStoryName.text="User"
        }else{
            holder.tvStoryName.text=storyList[position].name

        }
    }

    override fun getItemCount(): Int {
        return storyList.size
    }
}