package com.example.tvapp

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide


class CardPresenter : Presenter() {
    private var defaultCardImage: Drawable? = null
    private var selectedBackgroundColor: Int = 0
    private var defaultBackgroundColor: Int = 0
    private var infoBackgroundColor:Int = 0
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup): Presenter.ViewHolder {
        context = parent.context
        defaultBackgroundColor = ContextCompat.getColor(context, R.color.card_item_background)
        selectedBackgroundColor = ContextCompat.getColor(context, R.color.selected_background)
        infoBackgroundColor = ContextCompat.getColor(context, R.color.info_background)
        defaultCardImage = ContextCompat.getDrawable(context, R.mipmap.app_icon)

        val cardView = prepareCardView()

        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true
        updateCardBackgroundColor(cardView, false)
        return Presenter.ViewHolder(cardView)
    }

    private fun prepareCardView(): ImageCardView {
        return object : ImageCardView(context) {
            override fun setSelected(selected: Boolean) {
                updateCardBackgroundColor(this, selected)
                super.setSelected(selected)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) {
        val image = item as Image
        val cardView = viewHolder.view as ImageCardView

        cardView.titleText = image.title
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT)
        Glide.with(viewHolder.view.context)
            .load(image.imageURL)
            .centerCrop()
            .error(defaultCardImage)
            .into(cardView.mainImageView)
    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) {
        val cardView = viewHolder.view as ImageCardView
        cardView.badgeImage = null
        cardView.mainImage = null
    }

    private fun updateCardBackgroundColor(view: ImageCardView, selected: Boolean) {
        view.setBackgroundColor(if (selected) selectedBackgroundColor else defaultBackgroundColor)
        view.setInfoAreaBackgroundColor(infoBackgroundColor)
    }

    companion object {
        private const val CARD_WIDTH = 270
        private const val CARD_HEIGHT = 270
    }
}