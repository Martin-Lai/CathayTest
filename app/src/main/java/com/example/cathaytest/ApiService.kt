package com.example.cathaytest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/users")
    fun getUserList(@Query("since") since: Int, @Query("per_page") per_page: Int = 20): Call<List<GithubBean>>
}