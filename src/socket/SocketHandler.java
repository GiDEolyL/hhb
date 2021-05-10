package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

public class SocketHandler extends Thread {
	Socket socket;
	BufferedReader input;
	BufferedWriter output;
	public SocketHandler(Socket socket) {
		this.socket=socket;
		try {
			input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		boolean shouldContinue=true;
		while(shouldContinue){
			try {
				String msg = input.readLine();
				System.out.println("clinet:"+msg);
				if("bye".equals(msg)){
					break;
				} 
				
				Random random=new Random();
				int lucknum=random.nextInt(100);
				System.out.println("lucknum:"+lucknum);
				output.write(lucknum +"\r");
				output.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
