package com.malaka.common.map;

import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
  
  
/** 
 * @author  E-mail:wengxj@5173.com 
 * @version 创建时间：2012-7-27 上午9:42:06 
 * 类说明 
 */  
public class NewBitMap {  
      
    static int[][] map = new int[4][4];  
      
     public NewBitMap()  
     {  
            //全部初始化为0  
            for(int k = 0 ; k < 4; k++)  
            {  
                for(int j = 0;j < 4;j++)  
                {  
                    map[k][j] = 0;  
                }  
            }  
      }  
       
        public void insert(String info)  
        {  
              int[] md5INT = new int[4];  
              md5INT = getMD5int(info);  
               //循环整型组  
                for(int jj = 0 ; jj < 4; jj++)  
                {  
                    //hashcode--是保存位置  
                    int index_hash = (md5INT[jj] / 32) %8;  
                    int index_int = md5INT[jj]  % 32;  
                    map[jj][index_hash] = (int) (map[jj][index_hash] | (1 << index_int)) ;  
                }  
        }  
          
        public boolean contains(String info)  
        {  
            int[] md5INT = new int[4];  
            md5INT = getMD5int(info);  
            //循环整型组  
            for(int jj = 0 ; jj < 4; jj++)  
            {  
                int index_hash =( md5INT[jj] / 32) %8;  
                int index_int = md5INT[jj]  % 32;  
                if((map[jj][index_hash] & (1 << index_int)) == 0)  
                {  
                    return false;  
                }  
            }  
            return true;  
        }  
          
        private  int[] getMD5int(String info)  
        {  
             //得到md5码的字节组  
            byte[] bs = getMD5_16(info).getBytes();  
           // System.out.println(bs.length);  
            int[] md5INT = new int[4];  
              
            int count = 0;  
            byte[] tempB ;  
            //按照4个byte的大小循环，4个byte就是一个整型 ,  
            for(int i = 0 ;i < bs.length ;i= i + 4)  
            {  
                tempB = new byte[8];  
                tempB[0] = bs[i];  
                tempB[1] = bs[i+1];  
                tempB[2] = bs[i+2];  
                tempB[3] = bs[i+3];  
                //转换为整型  
                md5INT[count] =  (Integer) bytesToInt(tempB);  
                count++;  
            }  
            return md5INT;  
        }  
          
          
        public static int bytesToInt(byte[] intByte) {  
            int fromByte = 0;  
            for (int i = 0; i < 2; i++)  
            {  
                int n = (intByte[i] < 0 ? (int)intByte[i] + 256 : (int)intByte[i]) << (8 * i);  
                fromByte += n;  
            }  
            return fromByte;  
        }  
          
        public static String getMD5_16(String plainText)  
         {  
             StringBuffer buf = new StringBuffer("");   
             try {  
                   MessageDigest md = MessageDigest.getInstance("MD5");     
                   md.update(plainText.getBytes());  
                   byte b[] = md.digest();  
  
                   int i;  
                     
                   for (int offset = 0; offset < b.length; offset++) {  
                    i = b[offset];  
                    if(i<0) i+= 256;  
                    if(i<16)  
                     buf.append("0");  
                    buf.append(Integer.toHexString(i));  
                   }  
                   /*System.out.println("result: " + buf.toString());//32位的加密 
                   System.out.println("result: " + buf.toString().substring(8,24));//16位的加密 
    */            } catch (NoSuchAlgorithmException e) {  
                   e.printStackTrace();  
                  }  
             return buf.toString().substring(8,24);  
         }  
          
          
        public static void main(String[] args) {  
                     String str1 = "http://www.woyo.com";  
                     String str2 = "http://www.woyo.com2";  
                     String str3 = "http://www.woyo.com3";  
                     String str4 = "http://www1.woyo.com3";
                     String str5 = "3";
                     NewBitMap map = new NewBitMap();  
                     map.insert(str1);  
                     map.insert(str2);  
                     map.insert(str3);  
                     map.insert(str4);
                     map.insert(str5);
                     System.out.println(""+map.contains(str3));  
                     System.out.println(""+map.contains(str2));  
                     System.out.println(""+map.contains(str4)); 
                     System.out.println(""+map.contains(str5)); 
        }  
       
}  