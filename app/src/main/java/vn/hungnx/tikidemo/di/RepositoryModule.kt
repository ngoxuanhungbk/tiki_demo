package vn.hungnx.tikidemo.di

import org.koin.dsl.module
import vn.hungnx.tikidemo.data.source.DefaultAppRepository
import vn.hungnx.tikidemo.data.source.AppDataSource
import vn.hungnx.tikidemo.data.source.AppRepository
import vn.hungnx.tikidemo.data.source.remote.ApiService
import vn.hungnx.tikidemo.data.source.remote.AppRemoteDataSource

val repositoryModule = module {
    single { provideRemoteDataSource(get()) }
    single { provideMoviesRepository(get()) }
}

fun provideRemoteDataSource(apiService: ApiService): AppDataSource =
    AppRemoteDataSource(apiService)

fun provideMoviesRepository(
    remoteDataSource: AppDataSource
): AppRepository =
    DefaultAppRepository(remoteDataSource)