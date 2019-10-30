package com.sheldon.voicetubetest.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sheldon.voicetubetest.data.HomeVideoData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

private const val BASE_URL = "https://us-central1-lithe-window-713.cloudfunctions.net"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(client)
    .baseUrl(BASE_URL)
    .build()


//從網路得到 marketing-hots Data
interface VoiceTubeApiService {

    //送出 key & VoiceTube 並得到回傳資料於HomeVideoData

    @FormUrlEncoded
    @POST("/appQuiz")
    fun getVoiceTubeData(
        @Field("key") key: String = "VoiceTube"
    ): Deferred<HomeVideoData>
}

object VoiceTubeApi {
    val retrofitService: VoiceTubeApiService by lazy { retrofit.create(VoiceTubeApiService::class.java) }
}