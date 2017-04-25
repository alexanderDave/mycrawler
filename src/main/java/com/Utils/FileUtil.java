package com.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

import org.apache.log4j.Logger;

public class FileUtil {
	
	public static Logger log = Logger.getLogger(FileUtil.class);
	
	private static final String GBK = "GBK";
	private static final String UTF8 = "UTF-8";
	private static final String GB2312 = "GB2312";
	
	private static final String writenpath = "E:\\test_" + System.currentTimeMillis()+ ".txt";
	
	/**
	 * @author davedaiw
	 * @param inputstream
	 * @return String
	 */
	public static String getEncode(InputStream in){
		byte[] bytes = new byte[3];
		try {
			in.read(bytes);
			
			if (bytes[0] == -17 && bytes[1] == -69 && bytes[2] == -65) 
				return GBK;
			else
				return UTF8;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				
		return null;
	}
	
	/**
	 * @author davedaiw
	 * @param inputstream
	 * @return String
	 */
	public static String getString(InputStream ins){
		BufferedReader br = new BufferedReader(new InputStreamReader(ins));
		StringBuilder sb = new StringBuilder();
		
		String line = null;
		try {
			while ((line = br.readLine())!= null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				ins.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sb.toString();
	}
	
	public static void readFile(){
		
	}
	
	/**
	 * @author davedaiw
	 * @param ins
	 */
	public static void writeFile(InputStream ins){
		if (null != ins){
			Writer writer = null;
			Reader reader = null;
			int tmp =0;
			char[] bytes = new char[1024];
			try {
				reader = new InputStreamReader(ins, getEncode(ins));
				writer = new OutputStreamWriter(new FileOutputStream(new File(writenpath)), getEncode(ins));
				while ((tmp = reader.read(bytes)) != -1) {
					writer.write(bytes, 0, tmp);
					
				}
				ins.close();
				reader.close();
				writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * @author davedaiw
	 * @param ins
	 * @param path
	 */
	public static void writeFile(InputStream ins, String path){
		if (null != ins){
			Writer writer = null;
			Reader reader = null;
			int tmp =0;
			char[] bytes = new char[1024];
			try {
				reader = new InputStreamReader(ins, getEncode(ins));
				writer = new OutputStreamWriter(new FileOutputStream(new File(path)), getEncode(ins));
				
				while ((tmp = reader.read(bytes)) != -1) {
					writer.write(bytes, 0, tmp);
					
				}
				ins.close();
				reader.close();
				writer.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
	}
	
	public static String getProperties(String path, String key){
		Properties properties = new Properties();
		try {
			properties.load(FileUtil.class.getResourceAsStream(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
}
