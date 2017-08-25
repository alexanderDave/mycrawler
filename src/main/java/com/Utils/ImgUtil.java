package com.Utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.Net.NetUtil;

public class ImgUtil {
	
	private static Logger logger = Logger.getLogger(ImgUtil.class);
	
	public static String encodeImage(URL imagePath){
		//TODO ѹ��ͼƬ
		int[] demo = getImagebyte(imagePath);
		
		if (null != demo) {
			
			
		}
		
		return null;
	}
	
	
	
	public static String decodeImage(String imagePath){
		//TODO ��ѹͼƬ
		
		return null;
	}
	
	public static int[] getImagebyte(URL imagePath){
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//��ͼƬת����һ��string
		if (null != bufferedImage) {
			int width = bufferedImage.getWidth();
			int height = bufferedImage.getHeight();
			int[] tmp = new int[width * height];
			int[] imagebyte = new int[width * height + 2];
			bufferedImage.getRGB(0, 0, width, height, tmp, 0, width);
			
			for (int i = 0; i < tmp.length; i++) 
				imagebyte[i] = tmp[i];
			imagebyte[width * height] = width;
			imagebyte[width * height + 1] = height;
			
			return imagebyte;
		}
		
		return null;
	}
	
	//
	public static void main(String[] args) {
		
		System.out.println(NetUtil.getRespCode(NetUtil.getConnection("http://www.tumblr.com")));
		
		
	}
}
/*
 * as an example
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ImageWithArray {
 public static void main(String[] args) {
  // ��ȡͼƬ��BufferedImage
  BufferedImage bf = readImage("c:\\tmp\\6\\female.png");//����д��Ҫ��ȡ�ľ���·��+�ļ���
  // ��ͼƬת��Ϊ��ά����
  int[][] rgbArray1 = convertImageToArray(bf);
  // ���ͼƬ��ָ���ļ�
  writeImageFromArray("c:\\tmp\\2.png", "png", rgbArray1);//����д��Ҫ����ľ���·��+�ļ���
  System.out.println("ͼƬ������!");
 }
 public static BufferedImage readImage(String imageFile){
  File file = new File(imageFile);
  BufferedImage bf = null;
  try {
   bf = ImageIO.read(file);
  } catch (IOException e) {
   e.printStackTrace();
  }
  return bf;
 }
 public static int[][] convertImageToArray(BufferedImage bf) {
  // ��ȡͼƬ��Ⱥ͸߶�
  int width = bf.getWidth();
  int height = bf.getHeight();
  // ��ͼƬsRGB����д��һά����
  int[] data = new int[width*height];
  bf.getRGB(0, 0, width, height, data, 0, width);
  // ��һά����ת��ΪΪ��ά����
  int[][] rgbArray = new int[height][width];
  for(int i = 0; i < height; i++)
   for(int j = 0; j < width; j++)
    rgbArray[i][j] = data[i*width + j];
  return rgbArray;
 }
 public static void writeImageFromArray(String imageFile, String type, int[][] rgbArray){
  // ��ȡ�����Ⱥ͸߶�
  int width = rgbArray[0].length;
  int height = rgbArray.length;
  // ����ά����ת��Ϊһά����
  int[] data = new int[width*height];
  for(int i = 0; i < height; i++)
   for(int j = 0; j < width; j++)
    data[i*width + j] = rgbArray[i][j];
  // ������д��BufferedImage
  BufferedImage bf = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
  bf.setRGB(0, 0, width, height, data, 0, width);
  // ���ͼƬ
  try {
   File file= new File(imageFile);
   ImageIO.write((RenderedImage)bf, type, file);
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
}
 */
