package com.example.cathaytest

class ListContract {
    interface IListActivity {
        fun notifyGithubListChange(githubList: ArrayList<GithubBean>)
    }

    interface IListPresenter {
        fun getGithubList()
        fun updateLastCompletelyVisibleItemPosition(position: Int)
    }
}