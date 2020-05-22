package com.wzw.ios;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File file = new File("D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\collectionmap2");
        System.out.println(file.getName());
        String[] list = file.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(".*\\.java$");
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        for (String name : list) {
            System.out.println(name);
        }
    }
}
