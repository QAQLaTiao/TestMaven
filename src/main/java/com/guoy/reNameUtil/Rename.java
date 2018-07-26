package com.guoy.reNameUtil;

import java.io.File;

public class Rename {

    /**
     * 批量重命名
     *
     * @param path
     */
    public static void multiRename(String path) {
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        /** 如果不是文件夹，就返回* */
        if (!isDirectory) {
            System.out.println(path + "不是一个文件夹！");
            return;
        }
        String[] files = file.list();
        File f = null;
        String filename = "";
        String oldFileName = "";
        String newFileName = "";
        /** 循环遍历所有文件* */
        for (String fileName : files) {
            oldFileName = fileName;
            newFileName = oldFileName.split("]")[1];
            f = new File(path + "\\" + oldFileName);
            f.renameTo(new File(path + "\\" + newFileName));
        }
        System.out.println("批量重命名成功！");
    }

    public static void main(String[] args) {
        Rename.multiRename("D:\\aa");
    }
}