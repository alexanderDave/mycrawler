package com.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Listview {
	
	public List<String> urls = new ArrayList<String>();
	public List<String> templist = new ArrayList<String>();
	//private static Set<String> mset = new HashSet<String>();
	public Map<String, List<String>> webUrls = new HashMap<String, List<String>>();
	
	public void add(String murls){
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
	
	public void clearlist(){
		templist.clear();
	}
	
}
