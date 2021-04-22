package org.learn.ffmpeg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class movieConvert {

/*
    源地址
    E:\learn\CET6\1\mv\64\
    目标地址
    E:\learn\CET6\mv\
    E:\learn\CET6\1\mv (2)\64
    命令实现
    ffmpeg.exe -i E:\learn\CET6\1\mv (2)\64\video.m4s -i E:\learn\CET6\1\mv (2)\64\audio.m4s -vcodec copy -acodec copy E:\learn\CET6\mv\2.mp4
 */
    public static void main(String[] args) throws IOException {
        for(int i = 3;i <= 65;i++){
            conversionMV("E:/learn/CET6/1/mv("+i+")/64/video.m4s","E:/learn/CET6/1/mv("+i+")/64/audio.m4s","E:/learn/CET6/mv/"+i+".mp4");
            System.out.println("第"+i+"个视频合并完成");
        }
    }

    private static void conversionMV(String videopath,String audiopath,String mvpath) throws IOException {
        Process exec = Runtime.getRuntime().exec("ffmpeg.exe -i "+videopath+" -i "+audiopath+" -vcodec copy -acodec copy "+mvpath);
        InputStream errorStream = exec.getErrorStream();
        InputStreamReader ir = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(ir);
        String tem = "";
        while ((tem = br.readLine()) != null){
        }
        if (br != null){
            br.close();
        }
        if (ir != null){
            ir.close();
        }
        if (errorStream != null){
            errorStream.close();
        }
    }
}
