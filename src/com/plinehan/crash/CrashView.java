package com.plinehan.crash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.util.Log;
import android.view.View;

public class CrashView extends View {
	public CrashView(Context context) {
		super(context);
	}

	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(500, 500);
	}

	@SuppressLint("DrawAllocation")
	public void onDraw(Canvas canvas) {
		Log.e("CrashView", "onDraw");

		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.background);

		BitmapShader shader = new BitmapShader(bitmap, TileMode.REPEAT,
				TileMode.REPEAT);
		bitmap = null;
		System.gc();

		Paint paint = new Paint();
		paint.setShader(shader);
		shader = null;
		System.gc();

		Rect rect = new Rect(0, 0, getWidth(), getHeight());
		canvas.drawRect(rect, paint);

		paint = null;
		byte[] bytes = new byte[64 * 1024 * 1024];
		System.gc();
		Log.e("CrashView", "" + bytes.length);
	}
}
