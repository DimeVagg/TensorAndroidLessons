package com.dimevagg.animationlesson

import android.animation.*
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class MainFragment: Fragment() {

    lateinit var square: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_to_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rectangle = view.findViewById<View>(R.id.rectangle)
        val square = view.findViewById<View>(R.id.square)

        view.findViewById<Button>(R.id.fragment_button).setOnClickListener{
            startAnimation(rectangle, square)
        }
    }

    private fun startAnimation(rectangle: View, square: View) {
        val squareBigSize = resources.getDimension(R.dimen.square_big)
        val rectangleBigSize = resources.getDimension(R.dimen.rectangle_big)
        val squareColor = (square.getBackground() as ColorDrawable).color
        val squareColorTo = ContextCompat.getColor(requireActivity(), R.color.square_to)

        val squareColorAnimator = ValueAnimator
            .ofInt(squareColor, squareColorTo)
            .setDuration(400)
        squareColorAnimator.addUpdateListener { valueAnimator ->
            square.setBackgroundColor((valueAnimator.animatedValue as Int))
        }
        squareColorAnimator.setEvaluator(ArgbEvaluator())

        val squareSizeAnimator = ValueAnimator
            .ofInt(square.height, squareBigSize.toInt())
            .setDuration(400)
        squareSizeAnimator.addUpdateListener { animation ->
            val value = animation.getAnimatedValue() as Int
            square.layoutParams.width = value
            square.layoutParams.height = value
            square.requestLayout()
        }

        val rectangleSizeAnimator = ValueAnimator
            .ofInt(rectangle.height, rectangleBigSize.toInt())
            .setDuration(400)
        rectangleSizeAnimator.addUpdateListener { animation ->
            val value = animation.getAnimatedValue() as Int
            rectangle.layoutParams.height = value
            rectangle.requestLayout()
        }

        AnimatorSet().apply {
            play(squareSizeAnimator).with(rectangleSizeAnimator).with(squareColorAnimator)
            start()
        }
    }
}