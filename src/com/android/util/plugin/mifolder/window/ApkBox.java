package com.android.util.plugin.mifolder.window;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

public class ApkBox extends FrameLayout{
	
	private GridView mGridView;
	private ApkAdapter mAdapter;
	
	private TextView mClose;
	
	public ApkBox(Context context) {
		super(context);
		init();
	}
	
	private void init() {
		
		setBackgroundColor(Color.GRAY);
		
		mGridView = new GridView(getContext());
		mGridView.setNumColumns(4);
		
		mClose = new TextView(getContext());
		mClose.setText("CLOSE");
		mClose.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, Gravity.BOTTOM|Gravity.RIGHT));
		mClose.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onCloseClick();
			}
		});
		
		mAdapter = new ApkAdapter(getContext());
		mGridView.setAdapter(mAdapter);
		
		addView(mGridView);
		addView(mClose);
		
	}
	
	protected void onCloseClick() {
		
	}

	public void setData(ArrayList<ApkBean> apks) {
		mAdapter.setData(apks);
	}
	
	public void setData(ApkBean... array) {
		mAdapter.setData(array);
	}
	
	public static class ApkAdapter extends BaseAdapter<ApkBean, TextView> {

		public ApkAdapter(Context context) {
			super(context);
		}

		@Override
		public void onDispatchData(int position, ApkBean data, TextView itemView) {
			itemView.setText(data.getTitle());
			itemView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					add(ApkBean.genDefaultApk(getContext()));
				}
			});
			itemView.setCompoundDrawablesWithIntrinsicBounds(null, data.getIcon(), null, null);
		}

		@Override
		public TextView newView(LayoutInflater inflater, int position,
				View convertView, ViewGroup parent) {
			TextView textView = new TextView(getContext());
			float size = DensityUtil.dp2px(getContext(), 80);
			AbsListView.LayoutParams alp = new AbsListView.LayoutParams(100, 80);
			textView.setLayoutParams(alp);
			return textView;
		}
		
	}
}
