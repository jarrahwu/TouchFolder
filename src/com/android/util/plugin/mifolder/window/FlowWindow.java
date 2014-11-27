package com.android.util.plugin.mifolder.window;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PixelFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

@SuppressLint("ClickableViewAccessibility")
public class FlowWindow {

	protected static final int INVALID_POINTER_ID = 12;

	private Context mContext;
	private LayoutInflater mLayoutInflater;
	private FrameLayout mFrame;
	private WindowManager mWindowManager;

	public static void showControllable(Context context, View v) {
		if (v instanceof Controllable) {
			FlowWindow window = new FlowWindow(context);
			window.show(v);
			
			Folder folder = (Folder) v;
			folder.getIcon().setWindowTouch(window.mFrame);
			
		} else {
			throw new RuntimeException("the view you show is not controllable");
		}
	}

	public FlowWindow(Context context) {
		mContext = context;
		mLayoutInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mWindowManager = (WindowManager) mContext
				.getSystemService(Context.WINDOW_SERVICE);

		mFrame = new FrameLayout(mContext);
//		mFrame.setBackgroundColor(Color.GREEN);
	}

	// public void proxyTouchEvent(MotionEvent event) {
	//
	// }

	private WindowManager.LayoutParams getDefaultLayoutParams() {

//		int width = (int) (getScreenSize()[0] * 0.5f);
//		int height = (int) (getScreenSize()[1] * 0.5f);
		int width = -2;
		int height = -2;

		WindowManager.LayoutParams lp = new WindowManager.LayoutParams(width,
				height, WindowManager.LayoutParams.TYPE_PHONE,
				WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
						| WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
				PixelFormat.TRANSLUCENT);

		lp.gravity = Gravity.TOP;

		return lp;
	}

	public void show(View flowView) {
		d("show window by flowView");
		mFrame.addView(flowView);
		mWindowManager.addView(mFrame, getDefaultLayoutParams());
	}

	public void show(int layout) {
		d("show window by layout");
		View v = mLayoutInflater.inflate(layout, null, false);
		show(v);
	}

	public void dismiss() {
		if (null != mFrame)
			mWindowManager.removeView(mFrame);
	}

	public static void d(Object o) {
		Log.e("FlowWindow", o.toString());
	}

	/**
	 * 0 - width ; 1-height
	 * 
	 * @param wm
	 * @return
	 */
	public int[] getScreenSize() {
		DisplayMetrics dm = new DisplayMetrics();
		mWindowManager.getDefaultDisplay().getMetrics(dm);
		return new int[] { dm.widthPixels, dm.heightPixels };
	}
}
