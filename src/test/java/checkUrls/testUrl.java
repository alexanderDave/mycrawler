package checkUrls;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLStreamHandler;

import org.apache.http.client.ClientProtocolException;

import com.Dao.Listview;
import com.Dao.MailMan;
import com.Net.MailUtil;
import com.Net.NetUtil;
import com.Utils.FileUtil;
import com.Utils.MD5;

/**
 * @author davedaiw
 *
 */
public class testUrl {
	
	public static String murl = "http://list.pptv.com";
	
	public static void main(String[] args) {
		
		//save to local
		//FileUtil.writeFile(NetUtil.getRespBody(NetUtil.getConnection(murl)));
		
//		��ȡ������ַ������url������
		InputStream in = NetUtil.getRespBody(NetUtil.getConnection(murl));
		
		
		
//		
		
//		
		
//		��������Ϣ����
		
		String wrongInfo = "";
		
//		���ʹ����ʼ�
		MailMan mailMan = new MailMan();
		mailMan.setHost(FileUtil.getProperties("/mailInfo.properties", "host"));
		mailMan.setUname(FileUtil.getProperties("/mailInfo.properties", "name"));
		mailMan.setUpswd(FileUtil.getProperties("/mailInfo.properties", "pwd"));
		mailMan.setSender(FileUtil.getProperties("/mailInfo.properties", "name"));
		mailMan.setRecever(FileUtil.getProperties("/mailInfo.properties", "receiver"));
		mailMan.setSubject("����ҳ�����Ӳ�ѯ��������");
		mailMan.setMcontent(wrongInfo);
		//mailMan.setAttachfile("");  	//������ʽ
		MailUtil.sendMail(mailMan);
		
		
		
		
		
	}
}
