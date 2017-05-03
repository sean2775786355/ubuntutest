package com.example.model;

import org.json.JSONObject;

import javax.xml.bind.DatatypeConverter;
import java.io.DataOutputStream;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.model.LoadFile.loadFile;
import static com.example.model.PrintResponse.printResponse;
import static javax.servlet.SessionTrackingMode.URL;

/**
 * Created by sean on 17-4-29.
 */
public class TextToSpeech {


    public static String method1() throws Exception {

        File pcmFile = new File(JavaBean.getTestFileName());
        HttpURLConnection conn = (HttpURLConnection) new URL(JavaBean.getServerURL()).openConnection();

        // construct params
        JSONObject params = new JSONObject();
        params.put("format", "pcm");
        params.put("rate", 8000);
        params.put("channel", "1");
        params.put("token",GetTaken.getToken());
        params.put("cuid",JavaBean.getCuid());
        params.put("len", pcmFile.length());
        params.put("speech", DatatypeConverter.printBase64Binary(loadFile(pcmFile)));

        // add request header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        conn.setDoInput(true);
        conn.setDoOutput(true);

        // send request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(params.toString());
        wr.flush();
        wr.close();

       return  printResponse(conn);
    }
}
