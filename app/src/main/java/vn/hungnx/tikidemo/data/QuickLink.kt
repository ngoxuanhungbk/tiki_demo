package vn.hungnx.tikidemo.data

import vn.hungnx.tikidemo.data.display.QuickLinkDisplay

data class QuickLink(
    val title: String,
    val content: String,
    val url: String,
    val authentication: Boolean,
    val web_url: String,
    val image_url: String
) : QuickLinkDisplay{
    override fun getImageUrl(): String {
        return image_url
    }

    override fun getStringTitle(): String {
        return title
    }
}