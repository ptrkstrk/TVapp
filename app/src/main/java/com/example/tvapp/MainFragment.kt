package com.example.tvapp

import android.os.Bundle
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import androidx.leanback.widget.RowPresenter
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.OnItemViewClickedListener

import android.content.Intent
import com.example.tvapp.Data.Companion.prepareBlocksData
import com.example.tvapp.Data.Companion.prepareFoodData
import com.example.tvapp.Data.Companion.prepareToolsData


class MainFragment : BrowseSupportFragment() {

    private val tools = ArrayList<Pair<String,String>>()
    private val blocks = ArrayList<Pair<String,String>>()
    private val foods  = ArrayList<Pair<String,String>>()

    companion object {
        const val TOOLS_PRESENTER_NAME = "Data"
        const val BLOCKS_PRESENTER_NAME = "Blocks"
        const val FOOD_PRESENTER_NAME = "Food"
    }

    init {
        prepareToolsData(tools)
        prepareBlocksData(blocks)
        prepareFoodData(foods)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpUI()
        loadRows()
        onItemViewClickedListener = ItemViewClickedListener()
    }

    private inner class ItemViewClickedListener : OnItemViewClickedListener {
        override fun onItemClicked(
            itemViewHolder: Presenter.ViewHolder, item: Any,
            rowViewHolder: RowPresenter.ViewHolder, row: Row
        ) {
            val image = item as Image
            val intent = Intent(context, ViewItemActivity::class.java)
            intent.putExtra(ViewItemActivity.IMAGE, image)
            activity!!.startActivity(intent)
        }
    }

    private fun loadRows() {
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        val toolsPresenterHeader = HeaderItem(0, TOOLS_PRESENTER_NAME)
        val toolsRowAdapter = ArrayObjectAdapter(CardPresenter())
        setUpAdapter(toolsRowAdapter, tools)

        val blocksPresenterHeader = HeaderItem(1, BLOCKS_PRESENTER_NAME)
        val blocksRowAdapter = ArrayObjectAdapter(CardPresenter())
        setUpAdapter(blocksRowAdapter, blocks)

        val foodPresenterHeader = HeaderItem(2, FOOD_PRESENTER_NAME)
        val foodRowAdapter = ArrayObjectAdapter(CardPresenter())
        setUpAdapter(foodRowAdapter, foods)

        rowsAdapter.add(ListRow(toolsPresenterHeader, toolsRowAdapter))
        rowsAdapter.add(ListRow(blocksPresenterHeader, blocksRowAdapter))
        rowsAdapter.add(ListRow(foodPresenterHeader, foodRowAdapter))
        adapter = rowsAdapter
    }

    private fun setUpAdapter(rowAdapter: ArrayObjectAdapter, items: ArrayList<Pair<String, String>>) {
        for(item in items){
            val image = Image()
            image.imageURL = item.first
            image.title = item.second
            rowAdapter.add(image)
        }
    }

    private fun setUpUI() {
        title = getString(R.string.app_title)
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true
        brandColor = resources.getColor(R.color.brand_color)
    }
}