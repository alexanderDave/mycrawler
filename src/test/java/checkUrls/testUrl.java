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
//		��ȡ������ַ������url������
		InputStream in = NetUtil.getRespBody(NetUtil.getConnection(murl));
		Listview.templist = HtmlPaser.getAllurls(FileUtil.getString(in)); 
		
		FileUtil.writeFile(Listview.templist);
		*/
//		
		
//		
		
//		��������Ϣ����
		
//		String wrongInfo = "";
//		
////		���ʹ����ʼ�
//		MailMan mailMan = new MailMan();
//		mailMan.setHost(FileUtil.getProperties("/mailInfo.properties", "host"));
//		mailMan.setUname(FileUtil.getProperties("/mailInfo.properties", "name"));
//		mailMan.setUpswd(FileUtil.getProperties("/mailInfo.properties", "pwd"));
//		mailMan.setSender(FileUtil.getProperties("/mailInfo.properties", "name"));
//		mailMan.setRecever(FileUtil.getProperties("/mailInfo.properties", "receiver"));
//		mailMan.setSubject("����ҳ�����Ӳ�ѯ��������");
//		mailMan.setMcontent(wrongInfo);
//		//mailMan.setAttachfile("");  	//������ʽ
//		MailUtil.sendMail(mailMan);
//		
		
		
		
		
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
