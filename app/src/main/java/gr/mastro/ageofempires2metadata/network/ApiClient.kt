package gr.mastro.ageofempires2metadata.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val BASE_URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/"

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val okHttpClient : OkHttpClient by lazy {
        OkHttpClient.Builder()
            .readTimeout(100, TimeUnit.SECONDS)
            .connectTimeout(100, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}