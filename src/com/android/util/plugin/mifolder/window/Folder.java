package com.android.util.plugin.mifolder.window;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

public class Folder extends FrameLayout implements Controllable{
	
	private FolderIcon mIcon;
	
	private ApkBox mApkBox;
	
	public Folder(Context context) {
		super(context);
		init();
	}

	private void init() {
		mIcon = new FolderIcon(getContext());
		
		mApkBox = new ApkBox(getContext()) {
			@Override
			protected void onCloseClick() {
				mIcon.setVisibility(View.VISIBLE);
				mApkBox.setVisibility(View.GONE);
			}
		};
		mApkBox.setVisibility(View.GONE);
		mApkBox.setData(ApkBean.genDefaultApk(getContext()), ApkBean.genDefaultApk(getContext()), ApkBean.genDefaultApk(getContext()));
		
		mIcon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mIcon.setVisibility(View.GONE);
				mApkBox.setVisibility(View.VISIBLE);
			}
		});
		
		addView(mIcon);
		addView(mApkBox);
	}
	
	//-- controllable --//
	@Override
	public void addApk() {
		
	}

	@Override
	public void removeApk() {
		
	}
	//-- controllable --//

	public FolderIcon getIcon() {
		return mIcon;
	}
}
