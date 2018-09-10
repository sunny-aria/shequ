package com.kd.shequ.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 功能描述：
 *
 * @Auther:
 * @Date: 2018/9/7
 */
@Slf4j
@Controller
@RequestMapping("/file/")
public class FileController {
    private static String path ="d:/ftest/";
    private static int MAX_THREAD_SIZE =5;
    private static ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD_SIZE);

    @RequestMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }

    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("file")MultipartFile[] files){
        try{
            int size = files.length;
            for(int i=0;i<size;i++){
                MultipartFile file = files[i];
                if(file==null||file.getSize()==0){break;}
                String fileName = file.getOriginalFilename();
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                Long fileSize = file.getSize();
                log.info("name{}:{},size:{},suffixName:{}",i,fileName,fileSize,suffixName);
                File destFile = new File(path+fileName);

                if(destFile.exists()){
                    //断点续传
                    Long destFileSize = destFile.length();
                    if(destFileSize<file.getSize()){
                        RandomAccessFile randomAccessFile = new RandomAccessFile(destFile,"rw");
                        FileInputStream inputStream = (FileInputStream) file.getInputStream();
                        inputStream.skip(destFileSize);
                        randomAccessFile.seek(destFileSize);
                        byte[] b = new byte[1024*4];
                        while(inputStream.read(b) !=-1){
                            randomAccessFile.write(b);
                        }
                        inputStream.close();
                        randomAccessFile.close();
                    }
                }else{
                     File dir = new File(path);
                    if(!(dir.exists() && dir.isDirectory())) {
                        dir.mkdirs();
                    }
                    //每个文件的大小
                    long subFileSize = fileSize/MAX_THREAD_SIZE;
                    long lastSize = fileSize-subFileSize*MAX_THREAD_SIZE;
                    for(int j=0;j<MAX_THREAD_SIZE;j++){
                        FileInputStream inputStream = (FileInputStream) file.getInputStream();
                        long startIndex = j*subFileSize;
                        long eachFileSize = subFileSize;
                        if(j==4){
                            eachFileSize+=lastSize;
                        }
                        String subFileName = new StringBuffer(path).append(fileName).append("_").append(j).toString();
                        File subFile = new File(subFileName);
                        long subFileExistsSize = 0;
                        if(subFile.exists()){
                            subFileExistsSize = subFile.length();
                        }else{
                            subFile.createNewFile();
                        }

                        FileOutputStream fout = new FileOutputStream(subFile);
                        inputStream.skip(startIndex);
                        byte[] b = new byte[(int) eachFileSize];
                        fout.write(b,0,inputStream.read(b));
                        fout.close();
                        inputStream.close();
                    }
                    /** 拷贝临时文件到目标文件*/
                    copyFile(path+fileName,MAX_THREAD_SIZE);
                }

             }
        } catch (Exception e) {
           log.error("文件上传出现问题.错误信息：{}",e);
        }
        return "index";
    }

    private void copyFile(String destFileName,int fileCount) throws IOException {
        File dest = new File(destFileName);
        if(!dest.exists()){ dest.createNewFile();}
        try (FileOutputStream fos = new FileOutputStream(destFileName)) {
            for(int i=0;i<fileCount;i++){
                File file = new File(destFileName+"_"+i);
                FileInputStream fis = new FileInputStream(file) ;
                IOUtils.copy(fis,fos);
                fis.close();
                file.delete();
            }
        } catch (FileNotFoundException e) {
            log.error("文件上传出现问题.错误信息：{}",e);
        } catch (IOException e) {
            log.error("文件上传出现问题.错误信息：{}",e);
        }
    }
}
