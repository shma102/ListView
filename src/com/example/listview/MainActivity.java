package com.example.listview;

import java.util.ArrayList;
import java.util.List;

import com.example.listview.adapter.MyAdapterWithCommondAdapter;
import com.example.listview.bean.Bean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private ListView listView;
	private List<Bean> list_dates;

	private MyAdapterWithCommondAdapter mawc;

	String[] urls = new String[] {
			"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3586155655,363743836&fm=116&gp=0.jpg",
			"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3586155655,363743836&fm=116&gp=0.jpg",
			"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3586155655,363743836&fm=116&gp=0.jpg",
			"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3586155655,363743836&fm=116&gp=0.jpg",
			"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3586155655,363743836&fm=116&gp=0.jpg" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initDates();
		initView();

	}

	private void initDates() {
		// TODO 自动生成的方法存根
		list_dates = new ArrayList<Bean>();

		Bean bean;
		for (int i = 0; i < urls.length; i++) {
			bean = new Bean("Android打造全能适配器 " + (i + 1), "Android这就是非常好用的适配器",
					"2016-04-12", urls[i]);
			list_dates.add(bean);
		}
	}

	private void initView() {
		// TODO 自动生成的方法存根

		listView = (ListView) findViewById(R.id.id_listview);
		mawc = new MyAdapterWithCommondAdapter(this, list_dates);
		
		listView.setAdapter(mawc);
		mawc.notifyDataSetChanged();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
