package com.test1.test004;

import com.test1.test003.InstanceCounter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;


public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url,String name){
        this.url=url;
        this.name=name;

    }

    @Override
    public Boolean call() {
        WebDownLoader webDownLoader=new WebDownLoader();
        webDownLoader.downLoader(url,name);
        System.out.println("下载了文件名:"+name);
        return true;
    }

    public static void main(String[] arguments) throws ExecutionException, InterruptedException {

        TestCallable t1=new TestCallable("http://dl2.iteye.com/upload/attachment/0104/8872/ac1845b2-4954-3d82-935e-a2848e263f50.png","1.png");
        TestCallable t2=new TestCallable("http://dl2.iteye.com/upload/attachment/0104/8874/1f2ba5b6-50a7-38bb-8d1c-06d5e311aa59.png","2.png");
        TestCallable t3=new TestCallable("http://dl2.iteye.com/upload/attachment/0104/8876/694f8b5c-70ac-3fec-8e89-bde24aa42424.png","3.png");

        ExecutorService service= Executors.newFixedThreadPool(3);
        Future<Boolean> r1=service.submit(t1);
        Future<Boolean> r2=service.submit(t2);
        Future<Boolean> r3=service.submit(t3);

        boolean rs1=r1.get();
        boolean rs2=r2.get();
        boolean rs3=r3.get();

        service.shutdownNow();

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
