package com.example.instaapp.Adapter

import android.content.Context
import android.content.Intent
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instaapp.Fragments.ProfileFragment
import com.example.instaapp.Response.myResponseItem
import com.example.instaapp.R
import de.hdodenhof.circleimageview.CircleImageView

class PostAdapter(val context: Context, var postList: ArrayList<myResponseItem>):RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val ivPostProfile=itemView.findViewById<CircleImageView>(R.id.ivPostProfile)
        val imgPost=itemView.findViewById<ImageView>(R.id.imgPost)
        val tvPostName=itemView.findViewById<TextView>(R.id.tvPostName)
        val llclickToProfile=itemView.findViewById<LinearLayoutCompat>(R.id.ll_clickToProfile)
    }

    fun setListData(data:ArrayList<myResponseItem>){
        this.postList=data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_post_item,parent,false))
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        //set story
        Glide.with(context)
            .load(postList[position].profileimage)
            .error(R.drawable.profile)
            .into(holder.ivPostProfile)

        if(postList[position].name==null || postList[position].name.isEmpty()){
            holder.tvPostName.text="User"
        }else{
            holder.tvPostName.text=postList[position].name

        }
        //set post
        Glide.with(context)
            .load(postList[position].profileimage)
            .error(R.drawable.profile)
            .into(holder.imgPost)

        holder.llclickToProfile.setOnClickListener {
//            val intent=Intent(context,ProfileFragment::class.java)
//            context.startActivity(intent)

                val activity = context as? AppCompatActivity
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.clHome, ProfileFragment())?.addToBackStack(null)?.commit()
            }

        }

    override fun getItemCount(): Int {
        return postList.size

    }
}