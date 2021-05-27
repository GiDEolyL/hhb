package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Random;

import javax.net.ssl.SSLContext;

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
	
	/**
	 * 发送接收到的数据
	 */
	public void out(String out){
		try {
			output.write(out);
			output.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//服务器要不断地从客户端读取内容，把读取到的内容发给集合内所有的客户端。
	public void run() {
		boolean shouldContinue=true;
		String msg=null;
		while(shouldContinue){
			try {
				//发送接收到的内容给其他客户端
				while((msg=input.readLine())!=null){
					System.out.println("服务器收到clinet信息:"+msg);
					//先加载敏感词汇库
					CheckMessage check=new CheckMessage();
					//check.readFromText();
					
					//检测并隐藏敏感词汇
					String chenckedWord=check.changeWords(msg);
					
					ChatManager chatManager=new ChatManager();
					//System.out.println("已检查后返回的Sting:"+chenckedWord);
					chatManager.push(this, chenckedWord);
				}
				if("bye".equals(msg)){
		
					break;
				} 
				
//				Random random=new Random();
//				int lucknum=random.nextInt(100);
//				System.out.println("lucknum:"+lucknum);
//				output.write(lucknum +"\r");
//				output.flush();
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
