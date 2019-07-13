package com.itheima.gjp.domain;

public class Sort {
	private int sid;
	private String  sname;
	private String  parent;
	private String  sdesc;
	public Sort() {}
	//添加必要方法，Alt+shift+s---->Generate Constructor using Fileds-->即可得如下Sort()方法
	public Sort(int sid, String sname, String parent, String sdesc) {
//		super();
		this.sid = sid;
		this.sname = sname;
		this.parent = parent;
		this.sdesc = sdesc;
	}
	
	//添加必要方法，Alt+shift+s---->Generate Getter and Setter-->即可得如下get**()和set**()方法
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getSdesc() {
		return sdesc;
	}
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	//添加必要方法，Alt+shift+s---->Generate toString()-->即可得如下toString()方法
	@Override
	public String toString() {
		return "Sort [sid=" + sid + ", sname=" + sname + ", parent=" + parent + ", sdesc=" + sdesc + "]";
	}
	
	
}
