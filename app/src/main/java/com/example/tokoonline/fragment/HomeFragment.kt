package com.example.tokoonline.fragment

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.tokoonline.R
import com.example.tokoonline.adapter.AdapterProduk
import com.example.tokoonline.adapter.AdapterSlider
import com.example.tokoonline.model.Produk
import javax.security.auth.callback.Callback

class HomeFragment : Fragment () {

    lateinit var vpSlide: ViewPager
    lateinit var rvProduk:RecyclerView
    lateinit var rvProdukTerlaris:RecyclerView
    lateinit var rvElektronik:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)


        vpSlide = view.findViewById(R.id.vp_slide)
        rvProduk = view.findViewById(R.id.rv_produk)
        rvProdukTerlaris = view.findViewById(R.id.rv_produkTerlaris)
        rvElektronik = view.findViewById(R.id.rv_elektronik)

        val arrSlide = ArrayList<Int>()
        arrSlide.add(R.drawable.ft6)
        arrSlide.add(R.drawable.ft7)
        arrSlide.add(R.drawable.ft5)

        val adapterSlider = AdapterSlider(arrSlide,activity)
        vpSlide.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager3 = LinearLayoutManager(activity)
        layoutManager3.orientation = LinearLayoutManager.HORIZONTAL

        rvProduk.adapter = AdapterProduk(arrProduk)
        rvProduk.layoutManager = layoutManager

        rvProdukTerlaris.adapter = AdapterProduk(arrProdukTerlaris)
        rvProdukTerlaris.layoutManager = layoutManager2

        rvElektronik.adapter = AdapterProduk(arrElektronik)
        rvElektronik.layoutManager = layoutManager3

        return view
    }

    val arrProduk: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Sepatu Convers"
        p1.harga = "Rp.150.000"
        p1.gambar = R.drawable.ft4

        val p2 = Produk()
        p2.nama = "Sepatu Convers"
        p2.harga = "Rp.150.000"
        p2.gambar = R.drawable.ft4

        val p3 = Produk()
        p3.nama = "Sepatu Convers"
        p3.harga = "Rp.150.000"
        p3.gambar = R.drawable.ft4

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)

        return arr
    }

    val arrElektronik: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Sepatu Convers"
        p1.harga = "Rp.150.000"
        p1.gambar = R.drawable.ft4

        val p2 = Produk()
        p2.nama = "Sepatu Convers"
        p2.harga = "Rp.150.000"
        p2.gambar = R.drawable.ft4

        val p3 = Produk()
        p3.nama = "Sepatu Convers"
        p3.harga = "Rp.150.000"
        p3.gambar = R.drawable.ft4

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)

        return arr
    }

    val arrProdukTerlaris: ArrayList<Produk>get(){
        val arr1 = ArrayList<Produk>()
        val p4 = Produk()
        p4.nama = "Sepatu Convers"
        p4.harga = "Rp.150.000"
        p4.gambar = R.drawable.ft4

        val p4a = Produk()
        p4a.nama = "Sepatu Convers"
        p4a.harga = "Rp.150.000"
        p4a.gambar = R.drawable.ft4

        val p4b = Produk()
        p4b.nama = "Sepatu Convers"
        p4b.harga = "Rp.150.000"
        p4b.gambar = R.drawable.ft4

        arr1.add(p4)
        arr1.add(p4a)
        arr1.add(p4b)

        return arr1
    }

}