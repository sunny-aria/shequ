package com.kd.shequ;

import java.util.Arrays;

/**
 * 维权
 *
 * @author sunny
 * @create 2018/6/8 10:01
 **/
public class Weiquan {
    private static  void gen(){
        int danyuan ,floor ,ii=1;
        System.out.println("维权业主:");
        for(int i=1;i<=8;i++){
            //2,3号楼4个单元，6号楼2个单元，其他都是5个单元
            if(i==2||i==3){
                danyuan=4;
            }else if(i==6){
                danyuan=2;
            }else {
                danyuan=5;
            }
            //各号楼楼层
            if(i<4){
                floor=9;
            }else if(i==4){
                floor=18;
            }else{
                floor=28;
            }
            for(int j=1;j<=danyuan;j++){
                for(int k=1;k<=floor;k++){
                    System.out.println((ii++)+"、 "+i+"-"+j+"-"+k+"01");
                    System.out.println((ii++)+"、 "+i+"-"+j+"-"+k+"02");
                }
            }
        }
    }

    public static void main(String[] args) {
        Arrays.stream(TitleEnum.values()).forEach(o-> { if(o.getKey().equals("274"))System.out.println(o.getName());});
    }
}
