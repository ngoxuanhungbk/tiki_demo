package vn.hungnx.tikidemo.data.display

import vn.hungnx.tikidemo.base.BaseUI

interface QuickLinkDisplay : BaseUI {

    fun getImageUrl():String

    fun getStringTitle():String
}