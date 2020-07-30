package vn.hungnx.tikidemo.di

import android.content.Context
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.hungnx.tikidemo.data.source.remote.ApiService
import java.util.concurrent.TimeUnit

val networkModule = module {
    single(named("base_url")){ provideBaseUrl()}
    single { provideOkHttpCache(get()) }
    single(named("logging")){ provideLoggingInterceptor()}
    single(named("header")){ provideHeaderInterceptor()}
    single { provideOkHttpClient(get(named("logging")),get(named("header"))) }
    single { provideAppRetrofit(get(),get(named("base_url"))) }
    single { provideApiService(get()) }
}

const val TIMEOUT = 10

fun provideBaseUrl() = "https://api.tiki.vn/"

fun provideOkHttpCache(context: Context):Cache = Cache(context.cacheDir,(10*10*1024).toLong())

fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

fun provideHeaderInterceptor():Interceptor =
    Interceptor{chain ->
        val request = chain.request()
        val newUrl = request.url.newBuilder()
            .build()
        val newRequest = request.newBuilder()
            .url(newUrl)
            .method(request.method,request.body)
            .build()
        chain.proceed(newRequest)
    }

fun provideOkHttpClient(logging:Interceptor,header:Interceptor):OkHttpClient=
    OkHttpClient.Builder()
        .connectTimeout(TIMEOUT.toLong(),TimeUnit.SECONDS)
        .readTimeout(TIMEOUT.toLong(),TimeUnit.SECONDS)
        .addInterceptor(header)
        .addInterceptor(logging)
        .build()

fun provideAppRetrofit(okHttpClient: OkHttpClient,baseUrl:String):Retrofit=
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()

fun provideApiService(retrofit: Retrofit):ApiService =
    retrofit.create(ApiService::class.java)