package com.qdlg.model;

/**
 * 与分页相关的类
 * @author 10184
 *2017年10月29日
 */
public class Page {
	
	private int pages;            //总页数
	private int currentPage;      //当前页数
	private int begInIndex;       //开始索引
	private int endIndex;         //结束索引
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getBegInIndex() {
		return begInIndex;
	}
	public void setBegInIndex(int begInIndex) {
		this.begInIndex = begInIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
}
