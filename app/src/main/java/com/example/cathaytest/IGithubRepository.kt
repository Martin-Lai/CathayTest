package com.example.cathaytest

interface IGithubRepository {
    fun getGithubList(callback: MyFinishListener)
    fun getGithubUser(id: Int, callback: MyFinishListener)

    interface MyFinishListener {
        fun onSuccess(githubList: List<GithubBean>)
        fun onFailure()
    }
}