package com.example.instaapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instaapp.Adapter.PostAdapter
import com.example.instaapp.Adapter.StoryAdapter
import com.example.instaapp.Api.RetrofitInstence
import com.example.instaapp.Fragments.*
import com.example.instaapp.Response.myResponseItem
import com.example.instaapp.Repository.MainRepository
import com.example.instaapp.ViewModel.MainVeiwModelFactory
import com.example.instaapp.ViewModel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeScreenActivity : AppCompatActivity() {
    lateinit var rvStory:RecyclerView
    lateinit var rvPost:RecyclerView
    var storyList=ArrayList<myResponseItem>()
    var postList=ArrayList<myResponseItem>()
    lateinit var storyAdapter:StoryAdapter
    lateinit var postAdapter: PostAdapter
    lateinit var mainViewModel: MainViewModel
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        supportActionBar?.hide()

        bottomNavigationView=findViewById(R.id.bottomNavigationView)!!

        changeFragment(HomeFragment())
        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home-> changeFragment(HomeFragment())
                R.id.search->changeFragment(SearchFragment())
                R.id.addPost->changeFragment(AddPostFragment())
                R.id.reel->changeFragment(ReelsFragment())
                R.id.profile->changeFragment(ProfileFragment())
            }
            true
        }
//        rvStory=findViewById(R.id.rvStory)
//        rvPost=findViewById(R.id.rvPost)
//        bottomNavigationView=findViewById(R.id.bottomNavigationView)
//
//        changeFragment(HomeFragment())
//        bottomNavigationView.setOnItemSelectedListener{
//            when(it.itemId){
//                R.id.home-> changeFragment(HomeFragment())
//                R.id.search->changeFragment(SearchFragment())
//                R.id.addPost->changeFragment(AddPostFragment())
//                R.id.reel->changeFragment(ReelsFragment())
//                R.id.profile->changeFragment(ProfileFragment())
//            }
//            true
//        }
//
//        val progressDialog = ProgressDialog(this)
//        progressDialog.setMessage("loading")
//        progressDialog.show()
//
//        val apiServer=RetrofitInstence.retrofitServer
//        val repository=MainRepository(apiServer)
//        mainViewModel=ViewModelProvider(this,MainVeiwModelFactory(repository))[MainViewModel::class.java]
//
//        mainViewModel.data.observe(this, Observer {tk->
//            if(tk!=null){
//                Log.d("ok::::",tk.toString())
//                //set story
//                progressDialog.dismiss()
//                val linearLayoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
//                rvStory.layoutManager=linearLayoutManager
//                storyAdapter=StoryAdapter(this,storyList)
//                rvStory.adapter=storyAdapter
//                storyAdapter.setListData(tk)
//
//                //set post
//                val linearLayoutManager1=LinearLayoutManager(this)
//                rvPost.layoutManager=linearLayoutManager1
//                postAdapter=PostAdapter(this,postList)
//                rvPost.adapter=postAdapter
//                postAdapter.setListData(tk)
//
//            }else{
//                progressDialog.dismiss()
//                Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show()
//            }
//        })
//        mainViewModel.getItems()
//
//    }
//
//    private fun changeFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.linearLayout,fragment)
//            .commit()
//
//    }
//
//    override fun onBackPressed() {
//        super.onBackPressed()
//        finishAffinity()
//    }
    }
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.linearLayout,fragment)
            .commit()

    }


}