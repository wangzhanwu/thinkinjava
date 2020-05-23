package com.wzw.ios;

import com.wzw.util.TextFile;

import java.util.Map;
import java.util.TreeMap;

public class WordStatistics {
    /**
     * 统计文件内容中字符的出现次数
     * @param fileName
     * @param regex
     * @return
     */
    public static Map<Character, Integer> statistics(String fileName, String regex) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        String content = TextFile.read(fileName).replaceAll(regex, "");
        char[] array = content.toCharArray();
        for (char c : array) {
            Integer count = map.get(c);
            map.put(c, count == null ? 1 : count + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\util\\TextFile.java";
        Map<Character, Integer> map = statistics(filePath, "[^a-zA-z]");
        System.out.println(map);
    }
}
