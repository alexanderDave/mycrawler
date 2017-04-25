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
		mailMan.setSubject("播放页死链接查询结果输出：");
		mailMan.setMcontent("-----------------------------系统邮件：请勿回复");
		//mailMan.setAttachfile("");
		
		
		MailUtil.sendMail(mailMan);
	}

}
