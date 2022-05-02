package com.example.redrockmidtermexam.ui.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * description ： TODO:类的作用
 * author :Li Jian
 * email : 1678921845@qq.com
 * date : 2022/5/2
 */
class LinearGradientRectView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {
    lateinit var mRectF : RectF
    private val mPaint = Paint()
    private val positionArray5 = floatArrayOf(0f, 0.3f, 0.5f, 0.7f, 0.9f)
    private val positionArray4 = floatArrayOf(0f, 0.4f, 0.6f, 0.9f)
    private val positionArray3 = floatArrayOf(0f, 0.3f, 0.7f)
    private val positionArray2 = floatArrayOf(0f, 0.6f)

    var colorArray = intArrayOf(
        Color.BLUE, Color.RED
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
        canvas?.drawRect(mRectF,mPaint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mRectF = RectF(0F,0F,w.toFloat(),h.toFloat())
        when (colorArray.size) {
            2 -> mPaint.shader = LinearGradient(
                0F, 0F, 0F, mRectF.bottom, colorArray, positionArray2, Shader.TileMode.REPEAT
            )
            3 -> mPaint.shader = LinearGradient(
                0F, 0F, 0F, mRectF.bottom, colorArray, positionArray3, Shader.TileMode.REPEAT
            )
            4 -> mPaint.shader = LinearGradient(
                0F, 0F, 0F, mRectF.bottom, colorArray, positionArray4, Shader.TileMode.REPEAT
            )
            5 -> mPaint.shader = LinearGradient(
                0F, 0F, 0f, mRectF.bottom, colorArray, positionArray5, Shader.TileMode.REPEAT
            )
        }
    }
}
