package vn.hungnx.tikidemo.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import vn.hungnx.tikidemo.base.BaseUI
import vn.hungnx.tikidemo.data.Banner
import vn.hungnx.tikidemo.data.DealHot
import vn.hungnx.tikidemo.data.QuickLink
import vn.hungnx.tikidemo.data.Result
import vn.hungnx.tikidemo.data.source.AppRepository

class MainViewModel (private val repository: AppRepository):ViewModel(){


    private val _banners = MutableLiveData<Result<List<Banner>>>()
    val banners : LiveData<Result<List<Banner>>> = _banners

    private val _quickLinks = MutableLiveData<Result<List<QuickLink>>>()
    val quickLinks : LiveData<Result<List<QuickLink>>> = _quickLinks

    private val _dealHots = MutableLiveData<Result<List<DealHot>>>()
    val dealHots : LiveData<Result<List<DealHot>>> = _dealHots

    private val _isRefresh = MutableLiveData(false)
    val isRefresh : LiveData<Boolean> = _isRefresh

    private val _items = MutableLiveData<ArrayList<Result<List<BaseUI>>>>()
    val items:LiveData<ArrayList<Result<List<BaseUI>>>> = _items

    fun start(){
        viewModelScope.launch {
            loadData()
        }
    }

    private suspend fun loadData(){
        _isRefresh.value = true
        val data:ArrayList<Result<List<BaseUI>>> = arrayListOf(Result.Loading)
        _items.value = data
        _banners.value = Result.Loading
        _quickLinks.value = Result.Loading
        _dealHots.value = Result.Loading

        //load banner
        try {
            val response = repository.getBanners()
            data.remove(data.last())
            if (response.data != null && response.data.isNotEmpty()){
                data.add(Result.Success(response.data))
                _items.value = data
                _banners.value = Result.Success(response.data)
            }else {
                _banners.value = Result.Error(Throwable("No data"))
            }
        }catch (e: Exception){
            _banners.value = Result.Error(e)
            data.remove(data.last())
        }

        //load quick link
        data.add(Result.Loading)
        _items.value = data
        try {
            val response = repository.getQuickLinks()
            data.remove(data.last())
            if (response.data!=null && response.data.isNotEmpty()){
                val quickLinks = arrayListOf<QuickLink>()
                response.data.forEach {
                    quickLinks.addAll(it)
                }
                data.add(Result.Success(quickLinks))
                _items.value = data
//                _quickLinks.value = Result.Success(response.data)
            }else{
                _quickLinks.value = Result.Error(Throwable("No data"))
            }
        }catch (e:Exception){
            data.remove(data.last())
            _quickLinks.value = Result.Error(e)
        }

        //load deal hot
        data.add(Result.Loading)
        _items.value = data
        try {
            val response = repository.getDealHots()
            data.remove(data.last())
            if (response.data!=null && response.data.isNotEmpty()){
                _dealHots.value = Result.Success(response.data)
                data.add(Result.Success(response.data))
                _items.value = data
            }else{
                _dealHots.value = Result.Error(Throwable("No data"))
            }
        }catch (e: Exception){
            data.remove(data.last())
            _dealHots.value = Result.Error(e)
        }
        _isRefresh.value = false
    }

    fun onRefresh(){
        viewModelScope.launch {
            loadData()
        }
    }
}