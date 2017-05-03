package com.example.model;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import static javax.servlet.SessionTrackingMode.URL;

/**
 * Created by sean on 17-4-30.
 */
public class TextToSpeechDeal {

    public static void texttospeechDeal(String INFO) {
        try {
            INFO = URLEncoder.encode(INFO, "utf-8");
            String url = "http://tsn.baidu.com/text2audio?tex=" + INFO + "&lan=zh&cuid=e4:f8:9c:ea:9b:e2&ctp=1&ctp=1&tok=24.673d13062c92ec0b54d77fe939e657d7.2592000.1496107740.282335-9571375";


            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.connect();

            InputStream inputStream = conn.getInputStream();
            byte[] getData = readInputStream(inputStream);
            byte[] bts = new byte[1024];
            int length = 0;
            OutputStream os = new FileOutputStream(new File("/home/sean/Documents/test12.wav"));
            for(byte d: getData)
            {
                os.write(d);
            }
            os.flush();
            os.close();
            inputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }





    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }


}
