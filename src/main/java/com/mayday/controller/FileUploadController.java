package com.mayday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * 文件上传控制层
 */
@Controller
public class FileUploadController {

    @RequestMapping(value="/file")
    public String file(){
        return "file";
    }

    //文件上传具体方法
    @RequestMapping(value="/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file")MultipartFile file){
        if(!file.isEmpty()){  //如果文件不为空
            try {

                BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                System.out.println("file=="+file.getOriginalFilename());

                //把文件上传到数据库中怎么实现呢 ？


                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("上传失败");
            }catch (IOException i){
                i.printStackTrace();
                System.out.println("上传失败");
            }
            return "上传成功";

        }else {
            return "文件是空的";
        }



    }

    @RequestMapping(value="/mutifile")
    public String mutifile(){
        return "mutifile";
    }

    /**
     * 多文件具体上传时间，主要是使用了MultipartHttpServletRequest和MultipartFile
     * @return
     */
    @RequestMapping(value="/batch/upload", method= RequestMethod.POST)
    @ResponseBody
    public String moreFileUpload(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file=null;
        BufferedOutputStream out=null;

            for(int i=0;i<files.size();i++){
                file=files.get(i);
                if(!file.isEmpty()){
                    try {
                        byte aByte[]=file.getBytes();
                        out=new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                        out.write(aByte);
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        out=null;
                        return"You failed to upload " + i + " => " + e.getMessage();
                    }

                }else {
                    return"You failed to upload " + i + " because the file was empty.";
                }


            }



        return "the file upload successful !";

    }


}
