package vn.hungnx.tikidemo.data.source.remote

import retrofit2.http.GET
import vn.hungnx.tikidemo.data.source.remote.response.GetBannerResponse
import vn.hungnx.tikidemo.data.source.remote.response.GetDealHotResponse
import vn.hungnx.tikidemo.data.source.remote.response.GetQuickLinkResponse

interface ApiService {

    @GET("v2/home/banners/v2")
    suspend fun getBanner(): GetBannerResponse

    @GET("shopping/v2/widgets/quick_link")
    suspend fun getQuickLinks(): GetQuickLinkResponse

    @GET("v2/widget/deals/hot")
    suspend fun getDealHots(): GetDealHotResponse
}