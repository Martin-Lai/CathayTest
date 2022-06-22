package com.example.cathaytest

interface IGithubRepository {
    fun getGithubList(sinceId: Int, callback: MyFinishListener<List<GithubBean>>)
    fun getGithubUser(login: String, callback: MyFinishListener<GithubBeanDetail>)

    interface MyFinishListener<T> {
        fun onSuccess(response: T)
        fun onFailure(t: Throwable)
    }
}