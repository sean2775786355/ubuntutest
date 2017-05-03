package com.example.model;

import java.io.DataOutputStream;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.model.LoadFile.loadFile;
import static com.example.model.PrintResponse.printResponse;

/**
 * Created by sean on 17-4-29.
 */
public class VoiceRecognition {




    public static String method2() throws Exception {
        String token=GetTaken.getToken();
        File pcmFile = new File(JavaBean.getTestFileName());
        HttpURLConnection conn = (HttpURLConnection) new URL(JavaBean.getServerURL()
                + "?cuid=" + JavaBean.getCuid() + "&token=" + token).openConnection();

        // add request header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "audio/pcm; rate=8000");

        conn.setDoInput(true);
        conn.setDoOutput(true);

        // send request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.write(loadFile(pcmFile));
        wr.flush();
        wr.close();



        return printResponse(conn).toString();
    }



}
