package studentmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DoStudent {
	public static void main(String[] args) throws IOException {
		getMessage();
	}

public static void getMessage() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入学生信息。格式为：姓名,20,30,55");
		ComBySum cbs=new ComBySum();
		TreeSet<Student> ts=new TreeSet<>(cbs);
		for(int i=0;i<5;i++){
			String line=scan.nextLine();
			String[] arr;
			int garde1;
			int garde2;
			int garde3;
			int sum;
			String name;
			try{
				arr=line.split("\\,");
				name=String.valueOf(arr[0]);
				garde1=Integer.parseInt(arr[1]);
				garde2=Integer.parseInt(arr[2]);
				garde3=Integer.parseInt(arr[3]);
				sum=garde1+garde2+garde3;
				ts.add(new Student(name,garde1,garde2,garde3,sum));
			}catch(NumberFormatException e){
				System.out.println("录入格式错误，请重新录入");
			}
		}
		File file =new File("F:\\text io\\stud.txt");
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw= new BufferedWriter(fw);
		for(Student s:ts){
			bw.write(s.toString());
			bw.flush();
			bw.newLine();
		}
		bw.close();
	}


}
