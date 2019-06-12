package com.example.tvapp

import java.io.Serializable

data class Image(
    var id: Long = 0,
    var title: String? = null,
    var imageURL: String? = null
) : Serializable {

    override fun toString(): String {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}'
    }

    companion object {
        internal const val serialVersionUID = 727566175075960653L
    }
}