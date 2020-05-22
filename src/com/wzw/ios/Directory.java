package com.wzw.ios;

import com.wzw.util.PPrint;
import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Directory {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("dirs: ")
                    .append(PPrint.pformat(dirs))
                    .append("\n\nfiles: ")
                    .append(PPrint.pformat(files));
            return result.toString();
        }
    }

    /**
     * 获取所有文件
     * @param start 路径为字符串
     * @return
     */
    public static TreeInfo walk(String start) {
        return walk(new File(start));
    }

    /**
     * 获取所有文件
     * @param start 路径为File对象
     * @return
     */
    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start, String regex) {
        return walk(new File(start), regex);
    }
    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }
    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex)) {
                    result.files.add(item);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String path = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com";
        System.out.println(walk(path));
    }
}
