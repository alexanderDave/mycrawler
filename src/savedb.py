# -*- coding: UTF-8 -*- 

import requests
import time,os,re,json,time
import MySQLdb
import base64

# 文件存储路径 :稍后增加一个文件路径
work_path = '/Volumes/D/Projects/pyProj/myProj/mimg/result'
test_path = '/Volumes/D/Projects/pyProj/myProj/mimg/test'




if __name__ == "__main__":
    # 将图片按照文件的地址存储到数据库中去
	# insert query :insert into testcase (casename,url,params,method,dates,auth) values ('demo','/user.local','demo','get','2019-10-10','dw')
    # insert_sql = "insert into `clamepics` (`picname`,`pic`) values ('{0}','{1}');".format()
    # test query
    # test = "insert into `clamepics` (`picname`,`pic`) values ('{0}','{1}');".format('demo','test1')

    conn = MySQLdb.connect('localhost','root','2020@xhj','clamedb',charset='utf8')
    cursor = conn.cursor()
    # 获取照片组
    imgs_list = os.listdir(work_path)
    for files in imgs_list:
    	name = files.replace(' ','')
    	imgs = os.listdir('/Volumes/D/Projects/pyProj/myProj/mimg/result/{0}/'.format(files))
    	for img in imgs:
    		# 大量的io操作了
    		with open('/Volumes/D/Projects/pyProj/myProj/mimg/result/{0}/{1}'.format(files,img),'rb') as f:
    			contents = base64.b64encode(f.read()) # base64编码测试 
    			cv2str = str(contents, encoding = "utf-8") # 很重要，mysql读取的时候会自动解码
    			try:
    				exe_sql = 'insert into `clamedb`.`clamepics` (`picname`,`pic`) values ("{0}","{1}");'.format(name,cv2str)
    				print("\n当前正在执行的sql是：{0};".format(name))
    				cursor.execute(exe_sql)
    				conn.commit()
    			except Exception as e:
    				print(e)
    				conn.rollback()	

    
    conn.close()

