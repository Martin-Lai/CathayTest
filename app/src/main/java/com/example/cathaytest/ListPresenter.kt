package com.example.cathaytest

import android.util.Log

class ListPresenter(private val view: ListContract.IListActivity, private val githubRepository: GithubRepository) : ListContract.IListPresenter {
    private val TAG = "ListPresenter"
    private var loading = false
    private var data = ArrayList<GithubBean>()
    private var lastId = 0
    override fun getGithubList() {
        loading = true
        githubRepository.getGithubList(lastId, object: IGithubRepository.MyFinishListener<List<GithubBean>> {
            override fun onSuccess(githubList: List<GithubBean>) {
                data.addAll(githubList)
                view.notifyGithubListChange(data)
                loading = false
                lastId = data.last().id
            }

            override fun onFailure(t: Throwable) {
                loading = false
                Log.e(TAG, "onFailure: ", t)
            }
        })
    }

    override fun updateLastCompletelyVisibleItemPosition(position: Int) {
        if (!loading && data.size <= 100 - 20) {
            if (position == data!!.size - 1) {
                getGithubList()
            }
        }
    }
}