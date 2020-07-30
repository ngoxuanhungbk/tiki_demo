package vn.hungnx.tikidemo.data.source.remote.response

import vn.hungnx.tikidemo.data.QuickLink

data class GetQuickLinkResponse(
    val data: List<List<QuickLink>>?
)