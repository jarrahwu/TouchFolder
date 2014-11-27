package com.android.util.plugin.mifolder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ActivityMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startService(new Intent(this, TestService.class));
		finish();
	}
}
