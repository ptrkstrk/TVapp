package com.example.tvapp

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_view_item.*

class ViewItemActivity : AppCompatActivity() {

    companion object {
        const val IMAGE = "Image"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_item)
        val actionBar = supportActionBar

        actionBar!!.setDisplayHomeAsUpEnabled(true)
        loadImage()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun loadImage() {
        val image = intent.getSerializableExtra(IMAGE) as Image
        Glide.with(this)
            .load(image.imageURL)
            .into(itemImage)
    }
}
