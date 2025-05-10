package com.uts.hoopsnews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.uts.hoopsnews.NewsItem

class NewsAdapter(
    private val context: Context,
    private val newsList: List<NewsItem>
) : ArrayAdapter<NewsItem>(context, 0, newsList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_news, parent, false)
        }

        val newsItem = newsList[position]

        val imageView = view!!.findViewById<ImageView>(R.id.newsImage)
        val titleView = view.findViewById<TextView>(R.id.newsTitle)

        imageView.setImageResource(newsItem.imageResId)
        titleView.text = newsItem.title

        return view
    }
}
