package com.android.util.plugin.mifolder.window;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class WindowTouchListener implements OnTouchListener {

	private static final int THRESHOLD = 5; //区分点击跟触摸的阈值
	
	private TouchTrack mTouchTrack;
	private View mFrame;
	private WindowManager mWindowManager;
	
	
	/**
	 * 
	 * @param touch
	 *            window view 的触摸监听器, touch 的 layoutParams 必须是
	 *            windowManager的layoutParams
	 * @param windowManager
	 */
	public WindowTouchListener(View touch, WindowManager windowManager) {
		mFrame = touch;
		mWindowManager = windowManager;
		mTouchTrack = new TouchTrack();
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouch(View v, MotionEvent ev) {

		WindowManager.LayoutParams wlp = (LayoutParams) mFrame
				.getLayoutParams();
		final int action = MotionEventCompat.getActionMasked(ev);
		
		switch (action) {

		case MotionEvent.ACTION_DOWN: {
			Utils.d("ACTION_DOWN");

			final float x = ev.getRawX();
			final float y = ev.getRawY();

			// Remember where we started
			mTouchTrack.setLast(x, y);
			mTouchTrack.setStart(x, y);
			
			break;
		}

		case MotionEvent.ACTION_MOVE: {
			Utils.d("ACTION_MOVE");

			final float x = ev.getRawX();
			final float y = ev.getRawY();

			// Calculate the distance moved
			final float dx = x - mTouchTrack.lastPoint.x;
			final float dy = y - mTouchTrack.lastPoint.y;
			
			mTouchTrack.positionPoint.x += dx;
			mTouchTrack.positionPoint.y += dy;

			wlp.x = (int) mTouchTrack.positionPoint.x;
			wlp.y = (int) mTouchTrack.positionPoint.y;
			mWindowManager.updateViewLayout(mFrame, wlp);

			mTouchTrack.lastPoint.x = x;
			mTouchTrack.lastPoint.y = y;

			break;
		}

		case MotionEvent.ACTION_UP: {
			Utils.d("ACTION_UP");
			
			float dx = ev.getRawX() - mTouchTrack.startPoint.x;
			float dy = ev.getRawY() - mTouchTrack.startPoint.y;
			if (filterClickEvent(dx, dy)) {
				onClick();
			}
			break;
		}

		case MotionEvent.ACTION_CANCEL: {
			break;
		}

		}
		return true;
	}

	private boolean filterClickEvent(float dx, float dy) {
		boolean isClick;
		isClick = Math.abs(dx) <= THRESHOLD && Math.abs(dy) <= THRESHOLD;
		return isClick;
	}

	public void onClick() {
		Utils.d("onClick");
	}
}
