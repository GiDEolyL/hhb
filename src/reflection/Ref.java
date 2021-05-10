package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ref {
	public static void main(String[] args) throws ClassNotFoundException {
		Dog d = new Dog();
		// getName(d);
		// threeWay();
		// getClassInfo(d);
		//getNewIntance();
		//change();
		double a=11;
		double b=0;
		Long l=3l;
		String s="gasdygad";
		
		System.out.println(a/b);
	}

	public static void getName(Dog d) {
		Class c = d.getClass();
		System.out.println("�������" + c.getName());
		System.out.println("��������" + c.getMethods()[1]);
	}

	public static void threeWay() throws ClassNotFoundException {
		String className = "reflection.Dog";
		Class c = Class.forName(className);
		System.out.println("�ڶ��з���:Class.forName|" + c.getName());
		Class c1 = Dog.class;
		System.out.println("�����з���:����.class|" + c1.getName());
	}

	public static void getClassInfo(Object obj) {
		Class c = obj.getClass();
		// ��ȡ�Լ��͸����public����
		System.out.println("��ȡ�Լ��͸����public����:");
		for (Method m : c.getMethods()) {
			System.out.println(m.getName());
		}
		// ��ȡ�Լ������з���
		System.out.println("��ȡ�Լ������з���:");
		for (Method m : c.getDeclaredMethods()) {
			System.out.println(m.getName());
		}
	}

	// ͨ���ഴ������
	public static void getNewIntance() {
		Class c = Dog.class;
		try {
			// ͨ����Ŀչ��캯��
			Object obj = c.newInstance();
			System.out.println("ͨ���ഴ������:" + obj);
			// ͨ���������캯��
			Constructor con = c.getConstructor(new Class[] { String.class, int.class });
			Object obj1 = con.newInstance(new Object[] { "С��", 8 });
			Dog d = (Dog) obj1;
			System.out.println("ͨ���������캯��:" + d.name);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	// ���ó�Ա����
	public static void invoke() {
		Class c = Dog.class;
		try {
			Object obj = c.newInstance();
			Method m = c.getMethod("run", new Class[] {});
			m.invoke(obj, new Object[] {});
			System.out.println("���ó�Ա����:");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
	//������Ա����
	public static void change(){
		Class c=Dog.class;
		try {
			Object o=c.newInstance();
			Field[] fields=c.getDeclaredFields();
			for(Field f:fields){
				System.out.println(f.getName());
			}
			Field f=c.getDeclaredField("sex");
			f.setAccessible(true);
			f.set(o, "male");
			Field f1=c.getDeclaredField("name");
			f1.set(o, "�ǺǺǺ�");
			System.out.println(f.get(o));
			System.out.println(f1.get(o));
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
