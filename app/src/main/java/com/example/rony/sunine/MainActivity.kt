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
    var character = arrayOf("arrow", "robin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //       var lv = findViewById(R.id.listview) as ListView

        //    var mforcastAdapter= ArrayAdapter<String>(applicationContext,
        //           R.layout.listitem,
        //           R.id.list_id,
        //           character
        //           ) as ArrayAdapter<String>
        //lv.adapter = mforcastAdapter
        //    lv.setAdapter(mforcastAdapter)i
        val lv = findViewById(R.id.listview) as ListView
        lv.adapter = ListAdapter(this)
    }
    private class ListAdapter(context: Context) : BaseAdapter() {
        internal var sList = arrayOf("One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen")
        private val mInflator: LayoutInflater
        init {
            this.mInflator = LayoutInflater.from(context)
        }

        override fun getCount(): Int {
            return sList.size
        }

        override fun getItem(position: Int): Any {
            return sList[position]
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
