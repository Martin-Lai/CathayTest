package com.example.cathaytest

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubRepository: IGithubRepository {
    private val TAG = "GithubRepository"
    override fun getGithubList(callback: IGithubRepository.MyFinishListener) {
        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com").addConverterFactory(GsonConverterFactory.create()).build()
        val apiService = retrofit.create(ApiService::class.java)
        apiService.getUserList().enqueue(object : Callback<List<GithubBean>>{
            override fun onResponse(
                call: Call<List<GithubBean>>,
                response: Response<List<GithubBean>>
            ) {
                val data = response.body()
                callback.onSuccess(data!!)
            }

            override fun onFailure(call: Call<List<GithubBean>>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }
        })
    }

    override fun getGithubUser(id: Int, callback: IGithubRepository.MyFinishListener) {

    }
}