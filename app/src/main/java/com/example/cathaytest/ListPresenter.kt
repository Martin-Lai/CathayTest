package com.example.cathaytest

class ListPresenter(private val view: ListContract.IListActivity, private val githubRepository: GithubRepository) : ListContract.IListPresenter {
    override fun getGithubList() {
        githubRepository.getGithubList(object: IGithubRepository.MyFinishListener {
            override fun onSuccess(githubList: List<GithubBean>) {
                view.notifyGithubListChange(githubList as ArrayList<GithubBean> /* = java.util.ArrayList<com.example.cathaytest.GithubBean> */)
            }

            override fun onFailure() {
                TODO("Not yet implemented")
            }
        })
    }
}