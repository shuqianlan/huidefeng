package com.xihu.huidefeng.net.repository

import com.xihu.huidefeng.net.api.ApiService
import com.xihu.huidefeng.net.base.BaseRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RemoteRepository private constructor(): BaseRepository() {
    private val retrofit:Retrofit
    private val apiService: ApiService

    init {
        val client = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10L, TimeUnit.SECONDS)
            .addNetworkInterceptor {
                val request = it.request()
                println("OkHttpClient intercept: content $request")
                it.proceed(request)
            }.build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://wanandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    companion object {
        @Volatile
        private var instance: RemoteRepository? = null
        fun getInstance() = instance
            ?: synchronized(this) {
            instance
                ?: RemoteRepository().also { instance = it }
        }
    }

    suspend fun login() = request {
        apiService.login("15857184055", "dhafgaitryui6731da")
    }
}