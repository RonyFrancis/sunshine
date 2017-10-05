package com.example.rony.sunine

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

public class ListAdapter(context: Context, sList: Array<String>) : BaseAdapter() {
    // api : http://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b1b15e88fa797225412429c1c50c122a1
    private val mInflator: LayoutInflater
    private var sList: Array<String>

    init {
        this.mInflator = LayoutInflater.from(context)
        this.sList = sList as Array<String>
    }

    override fun getCount(): Int {
        return this.sList.size
    }

    override fun getItem(position: Int): Any {
        return this.sList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.listitem, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        vh.label.text = sList[position]
        return view
    }
}
private class ListRowHolder(row: View?) {
    public val label: TextView

    init {
        this.label = row?.findViewById(R.id.list_id) as TextView
    }
}

