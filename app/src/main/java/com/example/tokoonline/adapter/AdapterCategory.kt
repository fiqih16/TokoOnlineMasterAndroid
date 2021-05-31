package com.example.tokoonline.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.tokoonline.R
import com.example.tokoonline.model.CategoryModel
import java.net.URL

class AdapterCategory (val context: Context) : RecyclerView.Adapter<AdapterCategory.ViewHolder>(),
    Filterable {
    var arrayList = ArrayList<CategoryModel>()
    var CategoryListFilter = ArrayList<CategoryModel>()

    fun setData(arrayList: ArrayList<CategoryModel>) {
        this.arrayList = arrayList
        this.CategoryListFilter = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(model: CategoryModel) {
            //itemView.categoryName.text = "${model.id}. ${model.name}"
            //val url: URL = URL("http://fiqih.teknisitik.com/" + model.image_link)
            // menampilkan gambar yang didapatkan di url
            //val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            //itemView.imgProduct.setImageBitmap(bmp)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_sign, parent, false)
        return AdapterCategory.ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(arrayList[position])
        holder.itemView.setOnClickListener() {
            val model = arrayList.get(position)
//
//            var gId: Int = model.idProduct
//            var gProduct: String = model.nmProduct
//            var gDesc: String    = model.dsProduct
//            var gHarga: Int      = model.priceofProduct.toString().toInt()
//            var gImg: Int        = model.picProduct
//
//            val intent = Intent(context, Order::class.java)
//            intent.putExtra("pId", gId)
//            intent.putExtra("pProduct", gProduct)
//            intent.putExtra("pDesc", gDesc)
//            intent.putExtra("pHarga", gHarga)
//            intent.putExtra("pImg", gImg)
//            context.startActivity(intent)
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (constraint == null || constraint.length < 0) {
                    filterResults.count = CategoryListFilter.size
                    filterResults.values = CategoryListFilter
                } else {
                    var searchChr = constraint.toString()
                    val categorySearch = ArrayList<CategoryModel>()
                    for (item in CategoryListFilter) {
                        if (item.name.toLowerCase()
                                .contains(searchChr)
                        ) {
                            categorySearch.add(item)
                        }
                    }
                    filterResults.count = categorySearch.size
                    filterResults.values = categorySearch
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, filterResults: FilterResults?) {
                arrayList = filterResults!!.values as ArrayList<CategoryModel>
                notifyDataSetChanged()
            }
        }
    }
}