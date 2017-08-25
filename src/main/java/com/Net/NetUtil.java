package com.Net;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public class NetUtil {

	public static Logger logger = Logger.getLogger(NetUtil.class);
	
	/**
	 * @author davedaiw
	 * @param urls
	 * @see get net connections
	 */
	public static HttpResponse getConnection(String urls){
		logger.debug("NetUtil:getConnection");
		
		HttpResponse httpResponse = null;
		HttpClient client = new DefaultHttpClient();
		
		HttpGet httpGet = new HttpGet(urls);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		try {
			httpResponse = client.execute(httpGet);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return httpResponse;
	}
	
	/**
	 * @author davedaiw
	 * @param HttpResponse
	 * @return statuCode
	 * @see get responesecode for a judgement
	 */
	public static int getRespCode(HttpResponse reponse){
		logger.debug("NetUtil.getRespCode");
		int statuCode = 200;
		if (null != reponse)
			statuCode = reponse.getStatusLine().getStatusCode();
		return statuCode;
	}
	
	/**
	 * @author davedaiw
	 * @param HttpResponse
	 * @return InputStream
	 * @see get responeseBody for a judgement
	 */
	public static InputStream getRespBody(HttpResponse reponse){
		logger.debug("NetUtil.getRespBody");
		InputStream in = null;
		if (null != reponse) {
			HttpEntity entity = reponse.getEntity();
			try {
				in = entity.getContent();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return in;
	}
	
	/**
	 * @author davedaiw
	 * @param map
	 * @param name
	 * @return
	 */
	public static String wrongWeblist(HashMap<String, List<String>> map,String name){
		StringBuilder sb = new StringBuilder();
		
		List<String> list = map.get(name);
		for (String string : list) {
			int responseCode = getRespCode(getConnection(string));
			if (! (responseCode == 200)) {
				sb.append("From url:"+ name +" to page "+ string +" went wrong!@responese code "+ responseCode +" ;"+"\r\n");
			}
		}
		
		return sb.toString();
	}
	
	
	
}
