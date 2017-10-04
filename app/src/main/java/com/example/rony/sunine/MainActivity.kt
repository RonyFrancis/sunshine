package com.example.rony.sunine

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    // array values
    var sList: Array<String>  = arrayOf("One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lv = findViewById(R.id.listview) as ListView

        lv.adapter = ListAdapter(this, sList)
    }
    private class ListAdapter(context: Context,sList: Array<String>) : BaseAdapter() {
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
}
