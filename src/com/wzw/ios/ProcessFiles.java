package com.wzw.ios;

import java.io.File;

public class ProcessFiles {
    interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;
    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void processDirectoryTree(File root) {
        for (File file : Directory.walk(root)) {
            strategy.process(file);
        }
    }

    public static void main(String[] args) {
        String path = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com";
        new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println("file:" + file.getAbsoluteFile());
            }
        }, "").processDirectoryTree(new File(path));
    }
}
