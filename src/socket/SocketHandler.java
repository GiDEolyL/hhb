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
	 * ���ͽ��յ�������
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
	//������Ҫ���ϵشӿͻ��˶�ȡ���ݣ��Ѷ�ȡ�������ݷ������������еĿͻ��ˡ�
	public void run() {
		boolean shouldContinue=true;
		String msg=null;
		while(shouldContinue){
			try {
				//���ͽ��յ������ݸ������ͻ���
				while((msg=input.readLine())!=null){
					System.out.println("�������յ�clinet��Ϣ:"+msg);
					//�ȼ������дʻ��
					CheckMessage check=new CheckMessage();
					//check.readFromText();
					
					//��Ⲣ�������дʻ�
					String chenckedWord=check.changeWords(msg);
					
					ChatManager chatManager=new ChatManager();
					//System.out.println("�Ѽ��󷵻ص�Sting:"+chenckedWord);
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
