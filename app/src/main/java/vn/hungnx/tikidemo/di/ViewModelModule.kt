package vn.hungnx.tikidemo.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vn.hungnx.tikidemo.main.MainViewModel

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}