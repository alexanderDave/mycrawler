package checkUrls;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLStreamHandler;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;

import com.Dao.Listview;
import com.Dao.MailMan;
import com.Net.MailUtil;
import com.Net.NetUtil;
import com.Utils.FileUtil;
import com.Utils.HtmlPaser;
import com.Utils.MD5;

/**
 * @author davedaiw
 *
 */
public class testUrl {
	
	private static Logger logger = Logger.getLogger(testUrl.class);
	public static String murl = "http://list.pptv.com";
	
	public static void main(String[] args) {
		
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
	
	
interface FlyBehavior{
	public void fly();
}
	
	
interface QuackBehavor{
	public void quack();
}

class Quacker implements QuackBehavor{

	public void quack() {
		// TODO Auto-generated method stub
		
	}
}

class Duck{
	QuackBehavor quackBehavor;
	
	public void performQuack(){
		quackBehavor.quack();
	}
}
	
class musualDuck extends Duck{
	public musualDuck(){
		quackBehavor = new Quacker();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
