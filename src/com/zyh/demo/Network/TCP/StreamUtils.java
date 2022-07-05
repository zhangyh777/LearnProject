package com.zyh.demo.Network.TCP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author:zyh
 * Version:1.0
 */
public class StreamUtils{
    //将读取到的字节存为字节数组
    //
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int n = 0;
        while((n=is.read(b))!=-1){
            baos.write(b,0,n);
        }
        byte[] arr = baos.toByteArray();
        baos.close();
        return arr;
    }
}
