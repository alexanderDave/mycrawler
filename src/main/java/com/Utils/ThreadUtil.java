package com.Utils;

import org.apache.log4j.Logger;

public class ThreadUtil implements Runnable {
	
	private static Logger logger = Logger.getLogger(Thread.class);
	
	private String url = null;
	
	public ThreadUtil() {
		
	}
	
	public ThreadUtil(String url) {
		this.url = url;
	}
	
	public void run() {
		String a = url;
		
	}
	
	
	
	
}
