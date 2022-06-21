package com.example.cathaytest

import android.app.Application

class GlobalVariable : Application() {
    companion object {
        var accessToken: String = ""

    }

}