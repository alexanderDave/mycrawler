package checkUrls;

import org.apache.log4j.Logger;

import com.Net.NetUtil;

/**
 * @author davedaiw
 *
 */
public class testUrl {
	
	private static Logger logger = Logger.getLogger(testUrl.class);
	public static String murl = "http://list.pptv.com";
	
	public static void main(String[] args) {
		
		System.out.println(NetUtil.getRespCode(NetUtil.getConnection(murl)));
		
		
		
		//save to local
		//FileUtil.writeFile(NetUtil.getRespBody(NetUtil.getConnection(murl)));
		/**
//		获取输入网址的所有url并保存
		InputStream in = NetUtil.getRespBody(NetUtil.getConnection(murl));
		Listview.templist = HtmlPaser.getAllurls(FileUtil.getString(in)); 
		
		FileUtil.writeFile(Listview.templist);
		*/
//		
		
//		
		
//		将报错信息修饰
		
//		String wrongInfo = "";
//		
////		发送错误邮件
//		MailMan mailMan = new MailMan();
//		mailMan.setHost(FileUtil.getProperties("/mailInfo.properties", "host"));
//		mailMan.setUname(FileUtil.getProperties("/mailInfo.properties", "name"));
//		mailMan.setUpswd(FileUtil.getProperties("/mailInfo.properties", "pwd"));
//		mailMan.setSender(FileUtil.getProperties("/mailInfo.properties", "name"));
//		mailMan.setRecever(FileUtil.getProperties("/mailInfo.properties", "receiver"));
//		mailMan.setSubject("播放页死链接查询结果输出：");
//		mailMan.setMcontent(wrongInfo);
//		//mailMan.setAttachfile("");  	//附件形式
//		MailUtil.sendMail(mailMan);
//		
		
		
		
		
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
