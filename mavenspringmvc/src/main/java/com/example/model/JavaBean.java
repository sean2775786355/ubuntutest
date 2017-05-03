package com.example.model;

/**
 * Created by sean on 17-4-29.
 */
public class JavaBean {

    public static String getServerURL() {
        return serverURL;
    }

    private static final String serverURL = "http://vop.baidu.com/server_api";
    //绝对路径
    private static final String testFileName = "/home/sean/Documents/test.pcm";
    public static String getCuid() {
        return cuid;
    }

    public static String getApiKey() {
        return apiKey;
    }

    //put your own params here
    private static final String apiKey = "BX0VGbh5UcxtEALmIGS0AFBo";

    public static String getSecretKey() {
        return secretKey;
    }

    private static final String secretKey = "8834d8f4378d88857648396a71af7073";

    public static String getTestFileName() {
        return testFileName;
    }

    //mask
    private static final String cuid = "e4:f8:9c:ea:9b:e2";



}
