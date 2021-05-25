package com.test1.test003;

import org.apache.commons.io.FileUtils;
import sun.reflect.misc.FieldUtil;

import java.awt.color.ICC_ColorSpace;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;


public class InstanceCounter extends Thread {

    private String url;
    private String name;

    public InstanceCounter(String url,String name){
        this.url=url;
        this.name=name;

    }

    @Override
    public void run() {
        WebDownLoader webDownLoader=new WebDownLoader();
        webDownLoader.downLoader(url,name);
        System.out.println("下载了文件名:"+name);
    }

    public static void main(String[] arguments) {

        InstanceCounter instanceCounter1=new InstanceCounter("http://dl2.iteye.com/upload/attachment/0104/8872/ac1845b2-4954-3d82-935e-a2848e263f50.png","1.png");
        InstanceCounter instanceCounter2=new InstanceCounter("http://dl2.iteye.com/upload/attachment/0104/8874/1f2ba5b6-50a7-38bb-8d1c-06d5e311aa59.png","2.png");
        InstanceCounter instanceCounter3=new InstanceCounter("http://dl2.iteye.com/upload/attachment/0104/8876/694f8b5c-70ac-3fec-8e89-bde24aa42424.png","3.png");

       /* instanceCounter1.run();
        instanceCounter2.run();
        instanceCounter3.run();*/
    }

    
}

class WebDownLoader{
    //下载方法
    public void downLoader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}
