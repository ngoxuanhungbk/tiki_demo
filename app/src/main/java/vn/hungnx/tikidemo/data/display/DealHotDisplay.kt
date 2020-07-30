package vn.hungnx.tikidemo.data.display

import vn.hungnx.tikidemo.base.BaseUI

interface DealHotDisplay : BaseUI{

    fun getImageUrl(): String

    fun getPrice(): String

    fun getPercentDiscount(): String

    fun getQty(): Int

    fun getQtyOrdered(): Int

    fun getOrderString():String
}