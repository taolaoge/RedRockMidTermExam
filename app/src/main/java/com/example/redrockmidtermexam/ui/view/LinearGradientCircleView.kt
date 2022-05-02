package com.example.redrockmidtermexam.ui.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/1
 */
class LinearGradientCircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {
    private val mPaint = Paint()
    private val positionArray5 = floatArrayOf(0f, 0.3f, 0.5f, 0.7f, 0.9f)
    private val positionArray4 = floatArrayOf(0f, 0.4f, 0.6f, 0.9f)
    private val positionArray3 = floatArrayOf(0f, 0.6f, 0.9f)
    private val positionArray2 = floatArrayOf(0f, 0.6f)

    var colorArray = intArrayOf(
        Color.WHITE,Color.WHITE
    )

    init {
        initPaint()
    }

    private fun initPaint() {
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(105F, 120F, 100F, mPaint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        when (colorArray.size) {
            2 -> mPaint.shader = LinearGradient(
                0F, 0F, 0F, 220F, colorArray, positionArray2, Shader.TileMode.REPEAT
            )
            3 -> mPaint.shader = LinearGradient(
                0F, 0F, 0F, 240F, colorArray, positionArray3, Shader.TileMode.REPEAT
            )
            4 -> mPaint.shader = LinearGradient(
                0F, 0F, 0F, 240F, colorArray, positionArray4, Shader.TileMode.REPEAT
            )
            5 -> mPaint.shader = LinearGradient(
                0F, 0F, 0f, 240F, colorArray, positionArray5, Shader.TileMode.REPEAT
            )
        }
    }
}
