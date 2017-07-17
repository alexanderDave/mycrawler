package com.Utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlPaser {
	public static Logger logger = Logger.getLogger(HtmlPaser.class);
	
	
	public static List<String> getAllurls(String page){
		
		List<String> urls = new ArrayList<String>();
		
		Document doc = Jsoup.parse(page);
		Elements node = doc.getElementsByTag("a");
		for (Element element : node) {
			String url = element.attr("href");
			if (isUrl(url)) 
				urls.add(url);
		}
		return urls;
	}
	
	
	
	public static boolean isUrl(String urls){
		//TODO correct the return value
		if (!urls.isEmpty() && urls != "") {
			//remove about page & javascript;
			if (!urls.contains("javascript") || !urls.contains("about")){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPlayerUrls(String urls){
		//TODO correct the return value
		
		
		return true;
	}
	
	public static boolean isListPage(String urls){
		if (urls.contains("list"))
			return true;
		return false;
	}
	
	
	
}
