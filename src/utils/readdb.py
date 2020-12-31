# -*- coding: UTF-8 -*- 

import requests
import time,os,re,json,time,io
from lxml import etree
from PIL import Image
import cv2
import numpy as np
import MySQLdb
import base64


test_paths   = '/Volumes/D/Projects/pyProj/myProj/mimg/test/testpic'
testpic_path = '/Volumes/D/Projects/pyProj/myProj/mimg/test/testpic/testpic1.jpg'
save_path    = '/Volumes/D/Projects/pyProj/myProj/mimg/test/testpic/load1.jpg'

def save_db(path,name):
    conn = MySQLdb.connect('localhost','root','2020@xhj','clamedb',charset='utf8')
    cursor = conn.cursor()
    with open(path,'rb') as f:
        contents = base64.b64encode(f.read())
        cv2str = str(contents, encoding = "utf-8")
        try:
            exe_sql = 'insert into `clamedb`.`clamepics` (`picname`,`pic`) values ("{0}","{1}");'.format(name,cv2str)
            print("\n当前正在执行的sql是：{0};".format(name))
            cursor.execute(exe_sql)
            conn.commit()
        except Exception as e:
            print(e)
            conn.rollback() 
    conn.close()

def get_img_stream(mid):
    conn = MySQLdb.connect('localhost','root','2020@xhj','clamedb',charset='utf8')
    cursor = conn.cursor()
    try:
        # select picname from clamepics where picname='testpic';
        exe_sql = "select `pic` from `clamedb`.`clamepics` where `id`={0};".format(str(mid))
        print("\n当前正在执行的sql是：{0}".format(exe_sql))
        cursor.execute(exe_sql)
        result = cursor.fetchone()[0]
        # print(type(result))
        
        info = base64.b64decode(result)
        # print(info)
        # print(type(info))
        # result = str(cursor.fetchone()[0]).split('"')[0]
        with open(save_path,'wb') as f:
            f.write(info)
        # print(result)
        # print(type(result))
        # info = base64.b64decode(result)
        # print(type(info))
        # imgs = Image.open(io.BytesIO(info))
        # print(imgs)

        conn.commit()
    except Exception as e:
        print(e)
        conn.rollback()

    conn.close()

# id 1160

if __name__ == "__main__":
    # save pic 2 db
    # save_db(testpic_path,'testpic2')

    # load pic local
    # with open(testpic_path,'rb') as f:
    #     result = f.read()
    # encodes = base64.b64encode(result)
    # inf = base64.b64decode(encodes)
    # print(result)
    # imgs = Image.open(io.BytesIO(inf))
    # print(imgs)

    # load pic by db
    get_img_stream(123)


