package com.pana.markdown.controller;

import com.pana.markdown.response.ResponseContent;
import com.pana.markdown.response.ResponseEnum;
import org.pegdown.PegDownProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/**
 * @author chenyang
 * @email chenyan@cheyipai.com
 * @date 2017/8/23 14:22
 */
@RequestMapping("/index")
@Controller
public class IndexController {

    @RequestMapping("/md")
    @ResponseBody
    public ResponseContent getMDFile(@RequestParam("file_name") String fileName){
        try{
            File file = new File("d:\\test.md");
            FileReader fileReader = new FileReader(file);
            char[] cbuf = new char[1024];
            StringBuffer sb = new StringBuffer();
            String s = "";
            while(fileReader.read(cbuf) != -1){
                sb.append(new String(cbuf));
            }
            PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
            s = pdp.markdownToHtml(sb.toString());
            HashMap<String,Object> data = new HashMap<String, Object>();
            data.put("md",s);
            return ResponseContent.createResult(ResponseEnum.SUCCESS,data);
        }catch (Exception ex){
            return ResponseContent.createResult(ResponseEnum.SYSTEM_ERROR);
        }
    }


}
