package com.guoy.file.rename;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author QAQ
 */
public class ReName {
    public static void main(String[] args) throws IOException {

        //D盘下的file文件夹的目录
        String filepath = "D:/迅雷下载/651-720";
        //File类型可以是文件也可以是文件夹
        File file = new File(filepath);
        //将该目录下的所有文件放置在一个File类型的数组中
        File[] fileList = file.listFiles();
        //新建一个文件集合
        List<File> wjList = new ArrayList<File>();
        if (fileList != null) {
            for (File aFileList : fileList) {
                //判断是否为文件
                if (aFileList.isFile()) {
                    wjList.add(aFileList);
                }
            }

            for (File oldFile : fileList) {

                if (!oldFile.exists()) {
                    oldFile.createNewFile();
                }

                String oldFileName = oldFile.getName();

                int lastIndexOfdian = oldFileName.lastIndexOf(".");
                String houzhuiming = oldFileName.substring(lastIndexOfdian);
                System.out.println(houzhuiming);

                int lastIndexOfqian = oldFileName.lastIndexOf("第");
/*
                if(lastIndexOfqian ==-1){
                    lastIndexOfqian = oldFileName.lastIndexOf("[");
                }*/
                if(lastIndexOfqian ==-1){
                    lastIndexOfqian = oldFileName.lastIndexOf("-");
                }

                int lastIndexOfhou = oldFileName.lastIndexOf("集");
/*                if (lastIndexOfhou == -1) {
                    lastIndexOfhou = oldFileName.lastIndexOf("话");
                }
                if (lastIndexOfhou == -1) {
                    lastIndexOfhou = oldFileName.lastIndexOf("]");
                }*/
                if (lastIndexOfhou == -1) {
                    lastIndexOfhou = lastIndexOfdian;
                }




                String jishu = oldFileName.substring(lastIndexOfqian + 1, lastIndexOfhou);

                System.out.println("修改前文件名称是：" + oldFileName);
                String rootPath = oldFile.getParent();

                System.out.println("根路径是：" + rootPath);


                File newFile = new File(rootPath + File.separator + "火影忍者 " + jishu + houzhuiming);


                System.out.println("修改后文件名称是：火影忍者 " + jishu + houzhuiming);

                if (oldFile.renameTo(newFile)) {
                    System.out.println("修改成功!");
                } else {
                    System.out.println("修改失败");
                }
            }
        }
    }
}
