package com.xihu.huidefeng.ui.utils

import android.content.Context
import android.graphics.Point
import android.util.TypedValue
import android.view.WindowManager

/**
 * 单位转换工具类
 */
class DensityUtils private constructor() {
	init {
		throw UnsupportedOperationException("cannot be instantiated")
	}

	companion object {

		fun dp2px(context: Context, dpVal: Float): Int {
			return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
					dpVal, context.resources.displayMetrics).toInt()
		}

		fun sp2px(context: Context, spVal: Float): Int {
			return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
					spVal, context.resources.displayMetrics).toInt()
		}

		fun px2dp(context: Context, pxVal: Float): Float {
			val scale = context.resources.displayMetrics.density
			return pxVal / scale
		}

		fun px2sp(context: Context, pxVal: Float): Float {
			return pxVal / context.resources.displayMetrics.scaledDensity
		}

		fun getWindowSize(context: Context, result: IntArray) {
			val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
			val point = Point()
			wm.defaultDisplay.getRealSize(point)
			result[0] = point.x
			result[1] = point.y
		}
	}
}