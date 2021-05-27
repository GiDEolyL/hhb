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
 * 检查是否存在敏感词汇
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
	 * 从文件从读取敏感词汇
	 */
	public String readFromText() {
		String dic = "";// 敏感单词字典
		// 判断文件是否已经读取
		boolean load = isRead(loadTime);
		System.out.println("load:" + load);
		System.out.println("loadTime:" + loadTime);
		if (load == false) {
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					// System.out.println("readFromText里的LINE:" + line);
					dic += line + ",";
				}
				// 文件读取完的时间
				loadTime = Calendar.getInstance().getTimeInMillis();
				System.out.println("读取完词库的时间:" + loadTime);
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("不需要加载");
		}

		return dic;
	}

	/**
	 * 判断是否需要读取文件
	 */
	public boolean isRead(Long loadTime) {
		// 文件是否已经加载标志
		boolean loaded = false;
		/**
		 * 先判断文件是否已经加载(通过最后修改时间)
		 */
		// 获取文件最后修改时间
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
	 * 把敏感词汇改成***
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
		System.out.println("changeWords里的words:" + words);
		String[] strs = words.split(",");
		System.out.println("str:" + strs.length);
		System.out.println("(words.contains(msg):" + words.contains(msg));
		if ("".equals(msg)) {
			return msg;
		} else {
			if (words != null) {
				for (String str : strs) {
					if (str.equals(msg.toUpperCase()) || str.equals(msg.toLowerCase())) {
						System.out.println("是敏感词汇:" + msg);
						msg = msg.replaceAll(msg, "***");
					}
				}
			} else {
				System.out.println("不是敏感词汇");
			}

		}

		// String line;
		// fr = new FileReader(file);
		// BufferedReader br=new BufferedReader(fr);
		// while((line=br.readLine()) !=null){
		// System.out.println("敏感词汇词库:"+line);
		// if(msg.equals(line)){
		// System.out.println("存在敏感词汇:"+msg);
		// msg=msg.replaceAll(msg, "***");
		// System.out.println("替换后的msg"+msg);
		// }
		// }
		//

		return msg;

	}
}
