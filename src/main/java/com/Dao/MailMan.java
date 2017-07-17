package com.Dao;

public class MailMan {
	
	//smtp server host
	private String host = null;
	private String uname = null;
	private String upswd = null;
	//fa jian ren 
	private String sender = null;
	//shou jian ren 
	private String recever = null;
	private String subject = null;
	//zhengwen
	private String mcontent = null;
	//fu jian
	private String attachfile = null;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpswd() {
		return upswd;
	}
	public void setUpswd(String upswd) {
		this.upswd = upswd;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecever() {
		return recever;
	}
	public void setRecever(String recever) {
		this.recever = recever;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public String getAttachfile() {
		return attachfile;
	}
	public void setAttachfile(String attachfile) {
		this.attachfile = attachfile;
	}
	
	public MailMan() {}
	
	public MailMan(String host,String uname,String upswd,String sender,String recever,String subject,String mcontent,String attachfile){
		this.host = host;
		this.uname = uname;
		this.upswd = upswd;
		this.sender = sender;
		this.recever = recever;
		this.subject = subject;
		this.mcontent = mcontent;
		this.attachfile = attachfile;
	}
	
	

}
