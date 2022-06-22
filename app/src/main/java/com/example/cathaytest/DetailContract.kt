package com.example.cathaytest

class DetailContract {
    interface IDetailActivity {
        fun setUserInfo(user: GithubBeanDetail)
    }

    interface IDetailPresenter {
        fun fetchUser(login: String)
    }
}