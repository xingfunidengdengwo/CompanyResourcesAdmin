package com.admin.util;

public class Page {

	private int page=-1;
	private int size=-1;
	private int start;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStart() {
		return (page-1)*size;
	}
	public void setStart(int start) {
		this.start = start;
	}



}