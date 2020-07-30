package vn.hungnx.tikidemo.data.source.remote

import vn.hungnx.tikidemo.data.source.AppDataSource
import vn.hungnx.tikidemo.data.source.remote.response.GetBannerResponse
import vn.hungnx.tikidemo.data.source.remote.response.GetDealHotResponse
import vn.hungnx.tikidemo.data.source.remote.response.GetQuickLinkResponse

class AppRemoteDataSource(private val apiService: ApiService) : AppDataSource {

    override suspend fun getBanners(): GetBannerResponse {
        return apiService.getBanner()
    }

    override suspend fun getQuickLinks(): GetQuickLinkResponse {
        return apiService.getQuickLinks()
    }

    override suspend fun getDealHots(): GetDealHotResponse {
        return apiService.getDealHots()
    }


}