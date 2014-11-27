package com.android.util.plugin.mifolder;

import com.android.util.plugin.Processor;
import com.android.util.plugin.mifolder.window.FlowWindow;
import com.android.util.plugin.mifolder.window.Folder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class DumpProcessor implements Processor {

	@Override
	public void onReceive(Context context, Intent intent,
			BroadcastReceiver receiver) {
		Log.i("plugin", String.format(
				"DumpProcessor.onReceive: intent=%s receiver=%s", intent,
				receiver));
	}

	@Override
	public void onUpdate(Context context, Intent intent) {
		Log.i("plugin", String.format("DumpProcessor.onUpdate: %s", intent));
	}

	@Override
	public void onPostUpdate(Context context, Intent arg1) {
		FlowWindow.showControllable(context, new Folder(context));
	}

}
