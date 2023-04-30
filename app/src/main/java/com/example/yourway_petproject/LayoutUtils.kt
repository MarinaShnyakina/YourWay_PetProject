package com.example.yourway_petproject

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import androidx.core.view.isVisible


class LayoutUtils {
    companion object {
        fun crossFade(viewToShow: View, viewToHide: View, duration: Int = 500) {
            if (!viewToShow.isVisible) {
                viewToHide.visibility = View.VISIBLE
                viewToShow.fadeIn(duration)
                viewToHide.animate()
                    .alpha(0f)
                    .setDuration(duration.toLong())
                    .setListener(object  : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            viewToHide.visibility = View.GONE
                        }
                    })
            }
        }
    }
}

fun View.fadeIn(duration: Int = 500) {
    this.apply {
        alpha = 0f
        visibility = View.VISIBLE

        animate()
            .alpha(1f)
            .setDuration(duration.toLong())
            .setListener(null)
    }
}