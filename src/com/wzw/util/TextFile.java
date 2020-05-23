package com.wzw.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 文件读写工具
 * @author WZW
 */
public class TextFile extends ArrayList<String> {
    /**
     * 读取文件内容，将所有内容拼接成字符串返回
     * @param fileName 文件名称（带完整路径）
     * @return
     */
    public static String read(String fileName) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            //创建需要清理的对象之后，立即进入一个try-finally语句块
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    result.append(s);
                    result.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            //吞食则有害  所以应该将不能处理的异常抛出
            throw new RuntimeException(e);
        }
        return result.toString();
    }

    /**
     * 将内容写入指定的文件
     * @param fileName 文件名称
     * @param text 准备写入的内容
     */
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                out.println(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 构造器 造创建对象的时候就将文件读入该对象
     * @param fileName 文件名称
     * @param splitter 内容分隔符
     */
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) remove(0);
    }

    /**
     * 默认分隔符为换行符： \n
     * @param fileName
     */
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    /**
     * 将容器内的内容写出到指定的文件
     * @param fileName 内容写入文件名称
     */
    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                for (String item : this) {
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\util\\TextFile.java";
        String filePath2 = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\TestFile2.txt";
//        String s = read(filePath);
//        System.out.println(s);
//        write(filePath2, s);

        TextFile text = new TextFile(filePath);
        text.write(filePath2);

        TreeSet<String> words = new TreeSet<>(new TextFile(filePath, "\\W+"));
        System.out.println(words);

    }

}
