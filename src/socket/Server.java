package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		try {
			System.out.println("server启动中");
			ServerSocket serverSocket = new ServerSocket(666);
			System.out.println("server启动成功，等待client连接");
			while(true){
				Socket socket = serverSocket.accept();
				System.out.println("接收到了client连接");
				SocketHandler sh=new SocketHandler(socket);
				sh.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
