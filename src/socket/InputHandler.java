package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import org.junit.Test;


public class InputHandler extends Thread {
    BufferedReader bufferedReader;
	public boolean shouldContinue=true;
	public InputHandler(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	public void run() {
		while (shouldContinue) {
			try {
				String msg = bufferedReader.readLine();
				System.out.println("收到消息" + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}