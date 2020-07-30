package vn.hungnx.tikidemo.data.source

import vn.hungnx.tikidemo.data.source.remote.response.GetBannerResponse
import vn.hungnx.tikidemo.data.source.remote.response.GetDealHotResponse
import vn.hungnx.tikidemo.data.source.remote.response.GetQuickLinkResponse

class DefaultAppRepository(
    private val moviesRemoteDataSource: AppDataSource
) :
    AppRepository {

    override suspend fun getBanners(): GetBannerResponse {
        return moviesRemoteDataSource.getBanners()
    }

    override suspend fun getQuickLinks(): GetQuickLinkResponse {
        return moviesRemoteDataSource.getQuickLinks()
    }

    override suspend fun getDealHots(): GetDealHotResponse {
        return moviesRemoteDataSource.getDealHots()
    }

}