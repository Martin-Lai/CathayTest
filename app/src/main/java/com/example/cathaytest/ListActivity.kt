package com.example.cathaytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cathaytest.databinding.ActivityListBinding

class ListActivity : AppCompatActivity(), ListContract.IListActivity {
    lateinit var mAdapter: ListAdapter
    lateinit var presenter: ListPresenter
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListBinding.inflate(layoutInflater)
        supportActionBar!!.show()
        supportActionBar!!.title = "Github Users"
        setContentView(binding.root)
        layoutManager = LinearLayoutManager(this)
        mAdapter = ListAdapter(ArrayList<GithubBean>())
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.adapter = mAdapter
        binding.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                presenter.updateLastCompletelyVisibleItemPosition(layoutManager.findLastCompletelyVisibleItemPosition())
            }
        })

        presenter = ListPresenter(this, GithubRepository())
    }

    override fun onResume() {
        super.onResume()
        presenter.getGithubList()
    }

    override fun notifyGithubListChange(githubList: ArrayList<GithubBean>) {
        mAdapter.setDataAndNotify(githubList)
    }
}