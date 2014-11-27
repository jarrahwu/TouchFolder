package com.android.util.plugin.mifolder.window;

import android.graphics.PointF;

/**
 * @author jarrah
 * save touch info for convenience
 */
public class TouchTrack {
	
	/**
	 * 上一次触摸的点 主要用来计算 移动的的距离
	 */
	public PointF lastPoint;
	
	
	/**
	 * 开始触摸的点 记录这个点用来区分 点击或者是拖动
	 */
	public PointF startPoint;
	
	
	/**
	 * view 移动最后所处的点
	 */
	public PointF positionPoint;
	
	public TouchTrack() {
		lastPoint = new PointF();
		startPoint = new PointF();
		positionPoint = new PointF();
	}
	
	public void setLast(float x, float y) {
		set(lastPoint, x, y);
	}
	
	public void setStart(float x, float y) {
		set(startPoint, x, y);
	}
	
	public void setPosition(float x, float y) {
		set(positionPoint, x, y);
	}
	
	private void set(PointF p, float x, float y) {
		p.x = x;
		p.y = y;
	}
}
