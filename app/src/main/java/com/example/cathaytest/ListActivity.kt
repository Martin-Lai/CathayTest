package com.example.cathaytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cathaytest.databinding.ActivityListBinding

class ListActivity : AppCompatActivity(), ListContract.IListActivity {
    lateinit var mAdapter: ListAdapter
    lateinit var presenter: ListPresenter
    private val TAG = "ListActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_list)
        val binding = ActivityListBinding.inflate(layoutInflater)
        supportActionBar!!.title = "Github Users"
        setContentView(binding.root)
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
        }
        mAdapter = ListAdapter(ArrayList<GithubBean>())
        binding.recyclerview.adapter = mAdapter

        presenter = ListPresenter(this)
        Log.d(TAG, "onCreate: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
        presenter.getGithubList()
    }

    override fun notifyGithubListChange(githubList: ArrayList<GithubBean>) {
        Log.d(TAG, "notifyGithubListChange: ")
        mAdapter.setDataAndNotify(githubList)
    }
}