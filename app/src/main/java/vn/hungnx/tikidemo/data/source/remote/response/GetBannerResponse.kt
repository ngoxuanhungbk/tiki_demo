package vn.hungnx.tikidemo.data.source.remote.response

import vn.hungnx.tikidemo.data.Banner

data class GetBannerResponse(
    val data: List<Banner>?
)