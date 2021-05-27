package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class text4 {
	public static void main(String[] args) {
		String pathname="F:\\text io\\text.txt";
		createNewFile(pathname);
		writeToFile(pathname);
		readFromFile(pathname);
		String a="abc";
		String b="a";
		System.out.println(b.indexOf(a));
	}
	public static void createNewFile(String pathname){
		File file=new File(pathname);
		if(file.exists() == true){
			System.out.println("文件已经存在");
		}else{
			try {
				if(file.createNewFile()){
					System.out.println("文件创建成功");
				}else{
					System.out.println("文件创建失败");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void writeToFile(String pathname){
		File file =new File(pathname);
	    try {
			FileWriter fw= new FileWriter(file,true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.append("a\\n");
			bw.append("b\\n");
			bw.append("c\\n");
			bw.append("d\\n");
			bw.append("e\\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public static void readFromFile(String pathname){
    	try {
			RandomAccessFile raf=new RandomAccessFile(pathname,"r");
			String s=null;
			while((s=raf.readLine()) !=null){
				System.out.println(s);
			}
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
