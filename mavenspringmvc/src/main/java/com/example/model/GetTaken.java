package com.example.model;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sean on 17-4-29.
 */
public class GetTaken {


    public static String getToken() throws Exception {
        String token = "";

        String getTokenURL = "https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials" +
                "&client_id=" + JavaBean.getApiKey() + "&client_secret=" +JavaBean.getSecretKey();
        HttpURLConnection conn = (HttpURLConnection) new URL(getTokenURL).openConnection();
       return   token= new JSONObject(PrintResponse.printResponse(conn)).getString("access_token");
//        System.out.println(conn.toString());
    }
}
