package com.juacie.viewsonic.di

import com.juacie.viewsonic.BuildConfig
import com.juacie.viewsonic.ui.screen.time.TimeViewModel
import com.juacie.viewsonic.data.network.ApiService
import com.juacie.viewsonic.data.network.LoggingInterceptor
import com.juacie.viewsonic.data.repository.TimeRepository
import com.juacie.viewsonic.domain.TimeUseCase
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    // 提供 Retrofit 實例
    single { provideRetrofit() }
    // 提供 API Service
    single { get<Retrofit>().create(ApiService::class.java) }
    // 提供 Repository
    single { TimeRepository() }
    // 提供 UseCase
    single { TimeUseCase(get()) }
    // 提供 ViewModel
    viewModel { TimeViewModel(get()) }
}

fun provideRetrofit(): Retrofit {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val requestBuilder = it.request().newBuilder()
                .addHeader("Accept", "application/json, text/plain, */*")
                .addHeader("Content-Type", "application/json")
                .url(it.request().url)
            it.proceed(requestBuilder.build())
        }
        .addInterceptor(LoggingInterceptor())
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    return Retrofit.Builder()
        .baseUrl(BuildConfig.TIMEAPI_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

