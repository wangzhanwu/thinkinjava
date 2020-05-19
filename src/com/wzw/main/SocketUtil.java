package com.wzw.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketUtil {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream os = socket.getOutputStream();
        os.write("今天天气不错哦！".getBytes("utf-8"));
        os.flush();
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while((len = is.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len));
        }
        System.out.println(sb.toString());
        is.close();
        os.close();
        socket.close();
    }
}
