package vn.hungnx.tikidemo.data

import vn.hungnx.tikidemo.data.display.DealHotDisplay
import java.text.NumberFormat
import java.util.*

data class DealHot(
    val status: Int,
    val url: String,
    val tags: String,
    val discount_percent: Int,
    val special_price: Long,
    val special_from_date: Long,
    val from_date: String,
    val special_to_date: Long,
    val progress: DealProgress,
    val product: DealProduct
) : DealHotDisplay {
    override fun getImageUrl(): String {
        return product.thumbnail_url
    }

    override fun getPrice(): String {
        return "${NumberFormat.getInstance(Locale.GERMANY).format(special_price)}₫"
    }

    override fun getPercentDiscount(): String {
        return String.format("-%d%%",discount_percent)
    }

    override fun getQty(): Int {
        return progress.qty
    }

    override fun getQtyOrdered(): Int {
        return progress.qty_ordered
    }

    override fun getOrderString(): String {
        return if (progress.qty_ordered==0){
            "Vừa mở bán"
        }else{
            "Đã bán ${progress.qty_ordered}"
        }
    }
}

data class DealProgress(
    val qty: Int,
    val qty_ordered: Int,
    val qty_remain: Int,
    val percent: Float,
    val status: String
)

data class DealProduct(
    val id: Long,
    val sku: String?,
    val name: String,
    val url_path: String,
    val price: Long,
    val list_price: Long,
    val discount: Long,
    val rating_average: Float,
    val review_count: Int,
    val order_count: Int,
    val thumbnail_url: String,
    val is_visible: Boolean,
    val is_fresh: Boolean,
    val is_flower: Boolean,
    val is_gift_card: Boolean,
    val url_attendant_input_form: String,
    val master_id: Long,
    val seller_product_id: Long,
    val price_prefix: String
)