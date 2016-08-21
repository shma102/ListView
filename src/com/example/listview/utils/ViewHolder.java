package com.example.listview.utils;

import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {

	private SparseArray<View> views;
	private View mConvertView;
	private int mposition;

	public ViewHolder(Context ct, int position, ViewGroup parent, int layoutId) {

		mposition = position;
		views = new SparseArray<View>();
		mConvertView = LayoutInflater.from(ct).inflate(layoutId, parent, false);
		mConvertView.setTag(this);
	}

	public static ViewHolder get(Context ct, int position, View convertView,
			ViewGroup parent, int layoutId) {

		if (convertView == null) {
			return new ViewHolder(ct, position, parent, layoutId);
		} else {
			ViewHolder holder = (ViewHolder) convertView.getTag();
			holder.mposition = position;
			return holder;
		}

	}

	/*
	 * 根据viewId查找view
	 */
	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int viewId) {
		View view = views.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			views.put(viewId, view);
		}
		return (T) view;

	};

	public View getConvertView() {
		return mConvertView;
	}

	public void setText(int viewId, String text) {
		TextView tView = getView(viewId);
		tView.setText(text);
	}

	public void setImageView(int viewId, String url) {
		// 加载图片
		ImageLoader.getInstance()
				.displayImage(url, (ImageView) getView(viewId));
	}
}
