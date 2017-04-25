package com.Net;

import java.io.IOException;
import java.io.InputStream;

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
	
}
