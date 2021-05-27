package socket;

import java.net.Socket;
import java.util.Vector;

public class ChatManager {
	public static  Vector<SocketHandler> vector = new Vector<>();

	public void add(SocketHandler sh) {
		vector.add(sh);
	}

	/**
	 * 服务器把接收到的消息发送给其他客户端
	 */
	public void push(SocketHandler sh, String msg) {
		for (int i = 0; i < vector.size(); i++) {
			SocketHandler shTemp = vector.get(i);
			if (!sh.equals(shTemp)) {
				shTemp.out(msg + "\r");
			}

		}
	}
}
