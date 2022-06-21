package com.example.cathaytest

class ListPresenter(private val view: ListContract.IListActivity) : ListContract.IListPresenter {
    override fun getGithubList() {
        val mockData = ArrayList<GithubBean>();
        val user1 = GithubBean()
        user1.apply {
            id = 1
            login = "Jay"
            site_admin = false
            avatar_url =
                "https://infura-ipfs.io/ipfs/QmTCoNbCSw59iXbzfLGMNPCWvSokeTQhSfJkc7sCqMypRU"
        }
        mockData.add(user1)
        val user2 = GithubBean()
        user2.apply {
            id = 2
            login = "May"
            site_admin = true
            avatar_url =
                "https://infura-ipfs.io/ipfs/QmSg4AgCs6DSzKGYAHcqWzjoA5DzDsDDw1yYTWkBJHQJ6J"
        }
        mockData.add(user2)
        view.notifyGithubListChange(mockData)
    }
}