package com.android.util.plugin.mifolder.window;

import android.util.Log;

public class Utils {
	public static boolean isSet(int flags, int flag) {
		return (flags & flag) == flag;
	}
	
	public static void d(Object msg) {
		Log.e("Util", msg.toString());
	}
}