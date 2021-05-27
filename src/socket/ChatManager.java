package socket;

import java.net.Socket;
import java.util.Vector;

public class ChatManager {
	public static  Vector<SocketHandler> vector = new Vector<>();

	public void add(SocketHandler sh) {
		vector.add(sh);
	}

	/**
	 * �������ѽ��յ�����Ϣ���͸������ͻ���
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
