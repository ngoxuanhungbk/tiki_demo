package vn.hungnx.tikidemo.data

import vn.hungnx.tikidemo.data.display.BannerDisplay

data class Banner(
    val id: Long,
    val title: String,
    val content: String,
    val url: String,
    val image_url: String,
    val thumbnail_url: String,
    val mobile_url: String,
    val ratio: Float
):BannerDisplay{
    override fun getImageUrl(): String {
        return image_url
    }

    override fun getImageRatio(): Float {
        return ratio
    }

}