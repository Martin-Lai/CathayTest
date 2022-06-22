package com.example.cathaytest

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubRepository private constructor() : IGithubRepository {
    private val apiService: ApiService

    companion object {
        var single = GithubRepository()

        fun getInstance(): GithubRepository {
            if (single == null)
                single = GithubRepository()
            return single
        }
    }

    init {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "token " + GlobalVariable.accessToken).build()
            return@Interceptor chain.proceed(request)
        })
        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build()
        apiService = retrofit.create(ApiService::class.java)
    }

    override fun getGithubList(
        sinceId: Int,
        callback: IGithubRepository.MyFinishListener<List<GithubBean>>
    ) {

        apiService.getUserList(sinceId).enqueue(object : Callback<List<GithubBean>> {
            override fun onResponse(
                call: Call<List<GithubBean>>,
                response: Response<List<GithubBean>>
            ) {
                if (response.body() != null) callback.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<List<GithubBean>>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }

    override fun getGithubUser(
        login: String,
        callback: IGithubRepository.MyFinishListener<GithubBeanDetail>
    ) {
        apiService.getUserDetail(login).enqueue(object : Callback<GithubBeanDetail> {
            override fun onResponse(
                call: Call<GithubBeanDetail>,
                response: Response<GithubBeanDetail>
            ) {
                callback.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<GithubBeanDetail>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }
}