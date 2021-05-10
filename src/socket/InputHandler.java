package socket;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Test;


public class InputHandler extends Thread {
    BufferedReader bufferedReader;
	public boolean shouldContinue=true;
	public InputHandler(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
	@Test
	public void run() {
		while (shouldContinue) {
			try {
				String msg = bufferedReader.readLine();
				System.out.println("�յ���Ϣ" + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}