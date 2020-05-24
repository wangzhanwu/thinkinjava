package com.wzw.ios;

import java.io.*;
import java.util.Enumeration;
import java.util.Objects;
import java.util.zip.*;

public class ZipCompress {
    private static String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\ios.zip";
    private static String filePath2 = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios";

    public static void main(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream(filePath);
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);

        zos.setComment("a test of java zipping");
        for (File file : Objects.requireNonNull(new File(filePath2).listFiles())) {
            System.out.println("Writing file " + file.getName());
            BufferedReader bf = new BufferedReader(new FileReader(file));
            zos.putNextEntry(new ZipEntry(file.getAbsolutePath()));
            int c;
            while ((c=bf.read())!=-1) {
                out.write(c);
            }
            bf.close();
            out.flush();
        }
        out.close();

        System.out.println("Finish compress file");
        System.out.println("CheckSum: " + csum.getChecksum().getValue());
        FileInputStream fi = new FileInputStream(filePath);
        CheckedInputStream ci = new CheckedInputStream(fi, new Adler32());
        ZipInputStream zis = new ZipInputStream(ci);
        BufferedInputStream in = new BufferedInputStream(zis);
        ZipEntry ze;
        while ((ze=zis.getNextEntry()) != null) {
            System.out.println("Reading file: " + ze);
            int x;
            while((x=in.read()) != -1) {
                System.out.write(x);
            }
        }

        System.out.println("Checksum: " + ci.getChecksum().getValue());
        in.close();
        System.out.println("------------------------");
        ZipFile zf = new ZipFile(filePath);
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze1 = (ZipEntry) e.nextElement();
            System.out.println(ze1);
        }
    }
}
