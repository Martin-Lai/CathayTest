package com.example.cathaytest

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    fun getUserList(): Call<List<GithubBean>>
}