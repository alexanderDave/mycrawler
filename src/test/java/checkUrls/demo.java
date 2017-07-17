package checkUrls;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class demo {

	private static final String GBK = "GBK";
	private static final String UTF8 = "UTF-8";
	private static final String GB2312 = "GB2312";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			String path="E:\\test_" + System.currentTimeMillis()+Math.random()+ ".qx";
			writeFile(StringToInputstream(getRidpath()), path);
//			System.out.println(getRidpath());
		}
	}

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
	
	public static InputStream StringToInputstream(String s){
		
		ByteArrayInputStream bai = new ByteArrayInputStream(s.getBytes());
		return bai;
	}
	
	public static String getRidpath(){
		StringBuilder s =new StringBuilder();
		char[] mchar = "0123456789".toCharArray();
		char[] newchar = {mchar[makenum()],mchar[makenum()],'.',mchar[makenum()],mchar[makenum()],mchar[makenum()],mchar[makenum()]};
		String lca = String.valueOf(newchar);
		s = s.append(lca).append(',').append(lca).append('-').append(lca).append(',').append(lca).append('-').append(lca).append(',').append(lca).append('-').append(lca).append(',').append(lca);
		return s.toString();
	}
	
	public static int makenum(){
		return ((int)(Math.random()*9));
	}
}
