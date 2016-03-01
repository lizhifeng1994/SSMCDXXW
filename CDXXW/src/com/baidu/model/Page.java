package com.baidu.model;

public class Page {
//	当前页面
	private int pageNow;
//	指定每一页显示的条数
	private int pageSize;
//	一共有多少页
	private int pageCount;
//	一共有多少记录
	private int  rowCount;
	
	private int sqlPageSize;
//	开始时间
	private String start_time;
//	结束时间
	private String end_time;
	
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	@Override
	public String toString() {
		return "Page [pageNow=" + pageNow + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", rowCount=" + rowCount
				+ ", start_time=" + start_time + ", end_time=" + end_time + "]";
	}
	public Page(int pageNow, int pageSize, int pageCount, int rowCount,
			String start_time, String end_time) {
		super();
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.rowCount = rowCount;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSqlPageSize() {
		return sqlPageSize;
	}
	public void setSqlPageSize(int sqlPageSize) {
		this.sqlPageSize = sqlPageSize;
	}
	
}
