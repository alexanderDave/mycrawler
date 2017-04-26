package com.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Listview {
	
	public static List<String> urls = new ArrayList<String>();//
	public static List<String> visitedurls = new ArrayList<String>();//已经被访问过的url
	public static List<String> templist = new ArrayList<String>();//
	//private static Set<String> mset = new HashSet<String>();
	public static Map<String, List<String>> webUrls = new HashMap<String, List<String>>();//做地图用
	
	public void add(String murls){
		if (!visitedurls.contains(murls))
			urls.add(murls);
	}
	
	public void add(String murls, List<String> urls){
		webUrls.put(murls, urls);
	}
	
	public boolean hasKey(String url){
		return webUrls.containsKey(url);
	}
	
	public boolean hasValue(String url){
		//TODO correct the return value
		return true;
	}
	
	public static void clearlist(){
		templist.clear();
	}
	
}
