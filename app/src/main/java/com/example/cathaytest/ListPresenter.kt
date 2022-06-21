package com.example.cathaytest

class ListPresenter(private val view: ListContract.IListActivity, private val githubRepository: GithubRepository) : ListContract.IListPresenter {
    private var loading = false
    private var data = ArrayList<GithubBean>()
    private var lastId = 0
    override fun getGithubList() {
        loading = true
        githubRepository.getGithubList(lastId, object: IGithubRepository.MyFinishListener {
            override fun onSuccess(githubList: List<GithubBean>) {
                data.addAll(githubList)
                view.notifyGithubListChange(data)
                loading = false
                lastId = data.last().id
            }

            override fun onFailure() {
                loading = false
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