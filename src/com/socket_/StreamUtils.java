package com.socket_;

import java.io.*;

public class StreamUtils {
    /**
     * 将输入流转换成byte[]字节数组,即把文件内容读取到字节数组种
     * @param is
     * @return
     */
    public static byte[] streamToByByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();//创建输出流对象
        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1) {
            bos.write(b,0,len);
        }
        byte[] byteArray = bos.toByteArray();
        bos.close();
        return byteArray;
    }

   // 将inputStream 转换成string
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuffer builder = new StringBuffer();
        String line;
        while((line = reader.readLine()) != null) {
            builder.append(line + "\r\n");
        }
        return builder.toString();

    }



}
