package com.android.util.plugin.mifolder.window;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

public class ApkBean {
	
	private String title;
	private Drawable icon;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Drawable getIcon() {
		return icon;
	}

	public void setIcon(Drawable icon) {
		this.icon = icon;
	}
	
	public static ApkBean genDefaultApk(Context context) {
		ApkBean apkBean = new ApkBean();
		apkBean.setTitle("Apk");
		ColorDrawable cd = new ColorDrawable(Color.BLUE);
		apkBean.setIcon(cd);
		return apkBean;
	}
}
