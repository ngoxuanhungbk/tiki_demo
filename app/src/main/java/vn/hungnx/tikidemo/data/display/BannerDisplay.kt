package vn.hungnx.tikidemo.data.display

import vn.hungnx.tikidemo.base.BaseUI

interface BannerDisplay : BaseUI {

    fun getImageUrl():String

    fun getImageRatio():Float

}