package checkUrls;

import java.io.InputStream;
import java.util.List;

import com.Dao.Listview;
import com.Dao.MailMan;
import com.Net.MailUtil;
import com.Net.NetUtil;
import com.Utils.FileUtil;
import com.Utils.HtmlPaser;

public class testMailFun {

	public static void main(String[] args) {
//		MailMan mailMan = new MailMan();
//	
//		mailMan.setHost(FileUtil.getProperties("/mailInfo.properties", "host"));
//		mailMan.setUname(FileUtil.getProperties("/mailInfo.properties", "name"));
//		mailMan.setUpswd(FileUtil.getProperties("/mailInfo.properties", "pwd"));
//		mailMan.setSender(FileUtil.getProperties("/mailInfo.properties", "name"));
//		mailMan.setRecever(FileUtil.getProperties("/mailInfo.properties", "receiver"));
//		mailMan.setSubject("播放页死链接查询结果输出：");
//		mailMan.setMcontent("-----------------------------系统邮件：请勿回复");
//		//mailMan.setAttachfile("");
//		
//		
//		MailUtil.sendMail(mailMan);
		
		
		//test4 a static list;
		String smurl = "http://list.pptv.com";
		InputStream in = NetUtil.getRespBody(NetUtil.getConnection(smurl));
		Listview.templist = HtmlPaser.getAllurls(FileUtil.getString(in)); 
		
		//FileUtil.writeFile(Listview.templist);
		Listview.webUrls.put(smurl, Listview.templist);
		List<String> a = Listview.webUrls.get(smurl);
		System.out.println(a.size());
		Listview.clearlist();
		List<String> b = Listview.webUrls.get(smurl);
		System.out.println(b.size());
	}

}
