package com.example.controller;
import com.example.model.DealString;
import com.example.model.TextToSpeechDeal;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URLEncoder;

/**
 * Created by sean on 17-4-29.
 */
// 注解标注此类为springmvc的controller，url映射为"/home"
@Controller
@RequestMapping("/home")
public class HomeControlle {
    //映射一个action
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model) {
        //返回一个index.jsp这个视图
        model.addAttribute("id","123");
        return "main";
    }


    @RequestMapping(value="/index1",method=RequestMethod.POST)
    public String index1(String talk,Model model) throws Exception{


         model.addAttribute("talk",talk);
        talk= URLEncoder.encode(talk,"utf-8");
        String getTokenURL="redirect:http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=2&text="+talk;

       // HttpURLConnection connection = (HttpURLConnection) new URL(getTokenURL).openConnection()

//        JSONObject json=new JSONObject(t.getString().toString());
//       model.addAttribute("result","result");
//        json.get("result");
         //语音到文字识别
      /*  JSONObject param1=new JSONObject(DealString.getString1());
        param1.getString("result");
        System.out.print(param1.getString("result"));
         return "ok";*/
           return "";
    }
   //语音转文字操做

    @RequestMapping(value ="voice",method =RequestMethod.POST)
    public String voice(){


        return "voice";
    }
  //文字到语音操作
    @RequestMapping(value ="character",method =RequestMethod.POST)
    public String character(){


        return "character";
    }

    //语音处理
    @RequestMapping(value = "voicedeal",method = RequestMethod.POST)
    public String voicedeal(String file,Model model){
         String str=null;
         System.out.println(file);
         try{
             JSONObject param1=new JSONObject(DealString.getString1());
              str=param1.getString("result");
             System.out.print(param1.getString("result"));
         }catch (Exception e)
         {
             e.printStackTrace();
         }
       String[] strarray= str.split("\"");
        for (String s:strarray) {
            System.out.println(s);
        }
        String str1=strarray[1];
        System.out.println(str1);
        model.addAttribute("result",str);
        model.addAttribute("str1",str1);
        return "success";

    }

    //文字到语音处理
    @RequestMapping(value="characterdeal",method = RequestMethod.POST)
    public String characterdeal(String text){

        TextToSpeechDeal.texttospeechDeal(text);
        return "success";

    }





}
