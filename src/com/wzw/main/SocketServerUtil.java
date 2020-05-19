package com.wzw.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServerUtil {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务器等待连接");

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        while(true) {
            Socket socket = serverSocket.accept();
            Runnable runnable = () -> {
                InputStream is = null;
                try {
                    is = socket.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] bytes = new byte[1024];
                int len = 0;
                StringBuilder sb = new StringBuilder();
                while(true) {
                    try {
                        if (!((len = is.read(bytes)) != -1)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sb.append(new String(bytes, 0, len));
                }
                System.out.println("我是服务器，我收到的消息是："+sb.toString());
                OutputStream os = null;
                try {
                    os = socket.getOutputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    os.write("嗨，我是服务器，我收到你发的消息了！".getBytes("utf-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            executorService.submit(runnable);
        }







    }
}
