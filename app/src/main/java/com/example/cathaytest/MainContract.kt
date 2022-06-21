package com.example.cathaytest

import java.lang.Exception

class MainContract {
    interface IMainPresenter {
        fun login()
    }

    interface IMainActivity {
        fun loginSuccess()
        fun loginFailure(exception: Exception)
    }
}