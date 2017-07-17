package com.Dao;

public class UrlDao {
	
	
	private String murl = null;
	private String pagename = null;
	private int smd5 = 0;
	
	public int getSmd5() {
		return smd5;
	}
	public void setSmd5(int smd5) {
		this.smd5 = smd5;
	}
	public String getMurl() {
		return murl;
	}
	public void setMurl(String murl) {
		this.murl = murl;
	}
	public String getPagename() {
		return pagename;
	}
	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	
	public UrlDao(){}
	
	public UrlDao(String murl,String paString,int smd5){
		this.murl = murl;
		this.pagename = paString;
		this.smd5 = smd5;
	}

}
