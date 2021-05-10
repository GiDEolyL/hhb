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
			System.out.println("server������");
			ServerSocket serverSocket = new ServerSocket(666);
			System.out.println("server�����ɹ����ȴ�client����");
			while(true){
				Socket socket = serverSocket.accept();
				System.out.println("���յ���client����");
				SocketHandler sh=new SocketHandler(socket);
				sh.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
