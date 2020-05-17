package com.android.favqs.views

import android.graphics.*
import com.squareup.picasso.Transformation

class CircleTransformation : Transformation {

    var x = 0
    var y = 0

    private val key: String
        get() {
            return "circle(x=$x,y=$y)"
        }

    override fun transform(source: Bitmap): Bitmap? {
        val size = source.width.coerceAtMost(source.height)
        x = (source.width - size) / 2
        y = (source.height - size) / 2
        val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)
        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        val shader =
            BitmapShader(squaredBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.shader = shader
        paint.isAntiAlias = true
        val r = size / 2f
        canvas.drawCircle(r, r, r, paint)
        squaredBitmap.recycle()
        source.recycle()
        return bitmap
    }

    override fun key(): String? {
        return key
    }
}