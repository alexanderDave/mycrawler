package checkUrls;

import com.Dao.MailMan;
import com.Net.MailUtil;
import com.Net.NetUtil;
import com.Utils.FileUtil;

public class testMailFun {

	public static void main(String[] args) {
		MailMan mailMan = new MailMan();
	
		mailMan.setHost(FileUtil.getProperties("/mailInfo.properties", "host"));
		mailMan.setUname(FileUtil.getProperties("/mailInfo.properties", "name"));
		mailMan.setUpswd(FileUtil.getProperties("/mailInfo.properties", "pwd"));
		mailMan.setSender(FileUtil.getProperties("/mailInfo.properties", "name"));
		mailMan.setRecever(FileUtil.getProperties("/mailInfo.properties", "receiver"));
		mailMan.setSubject("����ҳ�����Ӳ�ѯ��������");
		mailMan.setMcontent("-----------------------------ϵͳ�ʼ�������ظ�");
		//mailMan.setAttachfile("");
		
		
		MailUtil.sendMail(mailMan);
	}

}
