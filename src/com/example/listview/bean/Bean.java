package com.example.listview.bean;

public class Bean {

	private String title;
	private String desc;
	private String time;
	private String img_url;

	public Bean() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	@Override
	public String toString() {
		return "Bean [title=" + title + ", desc=" + desc + ", time=" + time
				+ ", img_url=" + img_url + "]";
	}

	public Bean(String title, String desc, String time, String img_url) {
		super();
		this.title = title;
		this.desc = desc;
		this.time = time;
		this.img_url = img_url;
	}

}
