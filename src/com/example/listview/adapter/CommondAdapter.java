package com.example.listview.adapter;

import java.util.List;

import com.example.listview.R;
import com.example.listview.utils.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommondAdapter<T> extends BaseAdapter {

	private List<T> ts;
	private Context context;

	public CommondAdapter(Context context, List<T> ts) {
		this.context = context;
		this.ts = ts;

	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return ts.size();
	}

	@Override
	public T getItem(int position) {
		// TODO 自动生成的方法存根
		return ts.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = ViewHolder.get(context, position, convertView,
				parent, R.layout.item_listview);

		convert(viewHolder, ts.get(position));

		return viewHolder.getConvertView();

	}

	public abstract void convert(ViewHolder holder, T t);

}
