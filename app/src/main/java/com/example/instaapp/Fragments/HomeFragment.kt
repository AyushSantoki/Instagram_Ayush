package com.example.instaapp.Fragments

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instaapp.Adapter.PostAdapter
import com.example.instaapp.Adapter.StoryAdapter
import com.example.instaapp.Api.RetrofitInstence
import com.example.instaapp.R
import com.example.instaapp.Repository.MainRepository
import com.example.instaapp.Response.myResponseItem
import com.example.instaapp.ViewModel.MainVeiwModelFactory
import com.example.instaapp.ViewModel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {
    lateinit var rvStory: RecyclerView
    lateinit var rvPost: RecyclerView
    var storyList=ArrayList<myResponseItem>()
    var postList=ArrayList<myResponseItem>()
    lateinit var storyAdapter: StoryAdapter
    lateinit var postAdapter: PostAdapter
    lateinit var mainViewModel: MainViewModel
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        rvStory=view.findViewById(R.id.rvStory)
        rvPost=view.findViewById(R.id.rvPost)


        val progressDialog = ProgressDialog(context)
        progressDialog.setMessage("loading")
        progressDialog.show()

        val apiServer= RetrofitInstence.retrofitServer
        val repository= MainRepository(apiServer)
        mainViewModel= ViewModelProvider(this, MainVeiwModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.data.observe(viewLifecycleOwner, Observer {tk->
            if(tk!=null){
                Log.d("ok::::",tk.toString())
                //set story
                progressDialog.dismiss()
                val linearLayoutManager=
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                rvStory.layoutManager=linearLayoutManager
                storyAdapter=StoryAdapter((requireActivity() as AppCompatActivity),storyList)
                rvStory.adapter=storyAdapter
                storyAdapter.setListData(tk)

                //set post
                val linearLayoutManager1= LinearLayoutManager(context)
                rvPost.layoutManager=linearLayoutManager1
                postAdapter=PostAdapter((requireActivity() as AppCompatActivity),postList)
                rvPost.adapter=postAdapter
                postAdapter.setListData(tk)

            }else{
                progressDialog.dismiss()
                Toast.makeText(context, "empty", Toast.LENGTH_SHORT).show()
            }
        })
        mainViewModel.getItems()
    }

}