package com.android.util.plugin.mifolder.window;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.android.util.plugin.mifolder.R;

public class FolderIcon extends ImageView{

	public FolderIcon(Context context) {
		super(context);
		setImageResource(R.drawable.ic_launcher);
	}
	
	
	@SuppressLint("ClickableViewAccessibility")
	public void setWindowTouch(View windowFrame) {
		WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		setOnTouchListener(new WindowTouchListener(windowFrame, windowManager ) {
			@Override
			public void onClick() {
				super.onClick();
				FolderIcon.this.performClick();
			}
		});
	}
	

}
