package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			System.out.println("尝试建立连接");
			Socket socket = new Socket("localhost", 666);
			System.out.println("连接成功");
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			boolean shouldContinue = true;
			Scanner sc = new Scanner(System.in);
			String clientMessage;
			String serverMessage = null;
			
			InputHandler inputHandler=new InputHandler(input);
			inputHandler.start();
			
			while (shouldContinue) {
				clientMessage = sc.nextLine();
				System.out.println("client:" + clientMessage);

				output.write(clientMessage + "\r");
				output.flush();
				
//				serverMessage = input.readLine();
//				System.out.println("server:" + serverMessage);
				
				if ("bye".equals(clientMessage)) {
					shouldContinue = false;
				}
			}
			inputHandler.shouldContinue=false;
			sc.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
