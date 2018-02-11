package com.example.tikhon.ksp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateInterpolator
import kotlinx.android.synthetic.main.activity_eastern_egg.*

class EasternEggActivity : AppCompatActivity() {

    private val animator by lazy {
        ObjectAnimator.ofFloat(this, "alpha", 0f, 1f).apply {
            duration = 2500
            startDelay = 4500
            interpolator = AccelerateInterpolator()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eastern_egg)
        btnGo.setOnClickListener {
            tvKate.alpha = 0f
            animatedSvgView.start()
            animator.start()
        }
    }

    @Suppress("unused")
    private fun setAlpha(alpha: Float) {
        tvKate.alpha = alpha
    }

}
