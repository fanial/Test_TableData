package com.example.test_tabledata.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.test_tabledata.R
import com.example.test_tabledata.data.MenuDataClass

internal class MenuAdapter (
    private val menuList: List<MenuDataClass>,
    private val context: Context
): BaseAdapter(){
    private var layoutInflater: LayoutInflater? = null
    private lateinit var menuTV: TextView
    private lateinit var menuImg: ImageView
    override fun getCount(): Int {
        return  menuList.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
       return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        var convertView = p1

        if (layoutInflater == null){
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView == null){
            convertView = layoutInflater!!.inflate(R.layout.item_menu, null)
        }

        menuImg = convertView!!.findViewById(R.id.image_menu)
        menuTV = convertView!!.findViewById(R.id.tv_menu)

        menuImg.setImageResource(menuList.get(p0).img)
        menuTV.setText(menuList.get(p0).name)

        return convertView
    }
}

