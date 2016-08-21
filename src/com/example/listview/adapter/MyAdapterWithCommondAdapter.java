package com.example.listview.adapter;

import java.util.List;

import com.example.listview.R;
import com.example.listview.bean.Bean;
import com.example.listview.utils.ViewHolder;

import android.content.Context;

public class MyAdapterWithCommondAdapter extends CommondAdapter<Bean> {

	public MyAdapterWithCommondAdapter(Context context, List<Bean> ts) {
		super(context, ts);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void convert(ViewHolder viewHolder, Bean b) {
		// TODO 自动生成的方法存根
		viewHolder.setText(R.id.id_item_title, b.getTitle());
		viewHolder.setText(R.id.id_item_desc, b.getDesc());
		viewHolder.setText(R.id.id_item_time, b.getTime());
		viewHolder.setImageView(R.id.id_item_photo, b.getImg_url());

	}

}
