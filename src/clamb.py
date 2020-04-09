# -*- coding: UTF-8 -*- 

import requests
import time,os,re,json,time
from lxml import etree


# base_url = 'https://www.taotushe.top/index.php?s=photo&c=show&id=550' #目标网站的地址

def get_imge_list(hd,url):
	resp = requests.get(url,headers = hd)
	mhtml = etree.HTML(resp.text)
	# 保存文件的路径的格式化
	save_name = mhtml.xpath("/html/body/div[2]/div/div/div/div/div/div/div/div[1]/div[1]/div/h1/text()")
	if [] != save_name:
		name = save_name[0][0:5]+str(int(time.time()))
		# 先获取img的href
		img1 = mhtml.xpath("/html/body/div[2]/div/div/div/div/div/div/div/div[1]/div[3]/p/img/@src")
		save_list(save_name[0][0:5],name,img1)
		# 再获取a的href
		img2 = mhtml.xpath('/html/body/div[2]/div/div/div/div/div/div/div/div[1]/div[3]/p/a/@href')
		save_list(save_name[0][0:5],name,img2)
	else:
		print(resp.text)

	print('{0}-----done'.format(url))
	return True

def save_list(imgname,name,list1):
	print(name)
	file_path = '/Volumes/D/Projects/pyProj/myProj/mimg/{0}/'.format(name)
	# 创建目录
	if not os.path.exists(file_path):
		os.makedirs(file_path)

	if len(list1) != 0:
		print('需要处理的list是{0}'.format(str(list1)))
		for x in list1:
			print('\t正在获取{0}的{1}照片'.format(name,x))
			try:
				resp = requests.get(x,timeout = 30)
			except Exception as e:
				print('err:\t获取失败{0}的{1}照片'.format(name,x))
				time.sleep(5)
				continue
			with open(file_path+'{0}_{1}.jpg'.format(imgname,str(int(time.time()))),'wb') as f:
				f.write(resp.content)
# 加一个return试一试
	return True






if __name__ == '__main__':

	# 目标url
	aim_url = []
	# from 1 - 600,get all url to clamb
	for page_id in range(69,100):
		page_url = 'https://www.taotushe.top/index.php?s=photo&c=show&id={0}'.format(page_id)
		aim_url.append(page_url)
	print(str(aim_url))

	for page in aim_url:
		hd = {
		'Cookie':'_ga=GA1.2.763175322.1585984889; f814212a5b521d45bd53097f6a4a5fdb_ci_session=ip7chfpieoahvqcec8adua2cmvdjm36b; _gid=GA1.2.267973748.1586149224',
		'Host':'www.taotushe.top',
		'Referer':page,
		'User-Agent':'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36',
		'X-Requested-With':'XMLHttpRequest',
		'Cookie':'',
		}
		print("here goes ===================={0}".format(page))
		get_imge_list(hd,page)
		time.sleep(10)



	# test goes here
	# test_url = 'https://www.taotushe.top/index.php?s=photo&c=show&id=15'
	# img_url = 'https://img1.taotushe.top/uploadfile/gallery/814ce798b2.jpg'
	# get_imge_list(test_url)
	# save_img(img_url)
