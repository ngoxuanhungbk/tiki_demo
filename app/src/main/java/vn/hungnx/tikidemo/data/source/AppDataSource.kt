package vn.hungnx.tikidemo.data.source

import vn.hungnx.tikidemo.data.source.remote.response.GetBannerResponse
import vn.hungnx.tikidemo.data.source.remote.response.GetDealHotResponse
import vn.hungnx.tikidemo.data.source.remote.response.GetQuickLinkResponse

interface AppDataSource {

    suspend fun getBanners(): GetBannerResponse

    suspend fun getQuickLinks(): GetQuickLinkResponse

    suspend fun getDealHots(): GetDealHotResponse
}