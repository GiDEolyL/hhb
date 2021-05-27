package socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

/**
 * ����Ƿ�������дʻ�
 * 
 * @author Administrator
 *
 */
public class CheckMessage {
	String pathname = "F:\\eclipsework\\io\\src\\socket\\checkWords.txt";
	File file = new File(pathname);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static Long loadTime;

	/**
	 * ���ļ��Ӷ�ȡ���дʻ�
	 */
	public String readFromText() {
		String dic = "";// ���е����ֵ�
		// �ж��ļ��Ƿ��Ѿ���ȡ
		boolean load = isRead(loadTime);
		System.out.println("load:" + load);
		System.out.println("loadTime:" + loadTime);
		if (load == false) {
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					// System.out.println("readFromText���LINE:" + line);
					dic += line + ",";
				}
				// �ļ���ȡ���ʱ��
				loadTime = Calendar.getInstance().getTimeInMillis();
				System.out.println("��ȡ��ʿ��ʱ��:" + loadTime);
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("����Ҫ����");
		}

		return dic;
	}

	/**
	 * �ж��Ƿ���Ҫ��ȡ�ļ�
	 */
	public boolean isRead(Long loadTime) {
		// �ļ��Ƿ��Ѿ����ر�־
		boolean loaded = false;
		/**
		 * ���ж��ļ��Ƿ��Ѿ�����(ͨ������޸�ʱ��)
		 */
		// ��ȡ�ļ�����޸�ʱ��
		Long lastModifiedTime = file.lastModified();
		
		System.out.println("isRead::loadTime:"+loadTime);
		System.out.println("isRead::lastModifiedTime:"+lastModifiedTime);
		if(loadTime==null){
			return loaded;
		}else if (loadTime>=lastModifiedTime) {
			loaded = true;
		}
		return loaded;
	}

	/**
	 * �����дʻ�ĳ�***
	 * 
	 * @param msg
	 * @return
	 */
	public String changeWords(String msg) {
		// String pathname="F:\\eclipsework\\io\\src\\socket\\checkWords.txt";
		// File file=new File(pathname);
		// FileReader fr;
		// String words = null;

		String words = this.readFromText();
		System.out.println("changeWords���words:" + words);
		String[] strs = words.split(",");
		System.out.println("str:" + strs.length);
		System.out.println("(words.contains(msg):" + words.contains(msg));
		if ("".equals(msg)) {
			return msg;
		} else {
			if (words != null) {
				for (String str : strs) {
					if (str.equals(msg.toUpperCase()) || str.equals(msg.toLowerCase())) {
						System.out.println("�����дʻ�:" + msg);
						msg = msg.replaceAll(msg, "***");
					}
				}
			} else {
				System.out.println("�������дʻ�");
			}

		}

		// String line;
		// fr = new FileReader(file);
		// BufferedReader br=new BufferedReader(fr);
		// while((line=br.readLine()) !=null){
		// System.out.println("���дʻ�ʿ�:"+line);
		// if(msg.equals(line)){
		// System.out.println("�������дʻ�:"+msg);
		// msg=msg.replaceAll(msg, "***");
		// System.out.println("�滻���msg"+msg);
		// }
		// }
		//

		return msg;

	}
}
