package com.example.cathaytest

import android.util.Log

class DetailPresenter(
    private val view: DetailContract.IDetailActivity,
    private val githubRepository: GithubRepository
) : DetailContract.IDetailPresenter {
    private val TAG = "DetailPresenter"
    override fun fetchUser(login: String) {
        githubRepository.getGithubUser(login,
            object : IGithubRepository.MyFinishListener<GithubBeanDetail> {
                override fun onSuccess(user: GithubBeanDetail) {
                    view.setUserInfo(user)
                }

                override fun onFailure(t: Throwable) {
                    Log.e(TAG, "onFailure: ", t )
                }
            })
    }
}