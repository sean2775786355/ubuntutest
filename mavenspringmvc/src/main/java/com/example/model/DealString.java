package com.example.model;


import org.json.JSONObject;

/**
 * Created by sean on 17-4-29.
 */
public class DealString {

    public static String getString1()
    {
      String str=null;
      try{
          GetTaken.getToken();
          //语音到文字
          str=VoiceRecognition.method2();
//          JSONObject json=new JSONObject(TextToSpeech.method1());
//          str=json.getJSONArray("result").toString();

//          JSONObject json=new JSONObject(TextToSpeech.method1());
//          System.out.println(json.get("result"));
      }catch (Exception e){

          e.printStackTrace();
      }
      return str;
    }

}

