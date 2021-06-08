package reflectionWork;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Methods {
	/**
	 * 3�ֲ�ͬ�ķ������Person��Class����
	 * 
	 * @param person
	 */
	public void getPersonClass(Person person) {
		// ͨ��object��getClass����
		Class p = person.getClass();

		// ͨ�����·��
		String className = "reflectionWork.Person";
		try {
			Class p1 = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// ͨ��֪���������
		Class p2 = Person.class;
	}

	/**
	 * �ò�ͬ��������Person�����ʵ��
	 */
	public void getPersonNewIntance() {
		Class p = Person.class;
		try {
			// 1 ͨ���յĹ��캯��
			Object o1 = p.newInstance();
			// 2 ͨ���������캯��
			Constructor<Person> c = p.getConstructor(new Class[] { String.class, int.class });
			Object o2 = c.newInstance(new Object[] { "�ƺӺ����ٲ�", 5 });
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

	/**
	 * ����set��get������д���Ե�ֵ����Ҫ���޸�accessAttribute)
	 */
	public void getSetValues() {
		Class p = Person.class;
		try {
			Object o = p.newInstance();
			Field field = p.getDeclaredField("name");
			field.setAccessible(true);
			field.set(o, "����");
			Field field1 = p.getDeclaredField("age");
			field1.setAccessible(true);
			field1.set(o, 25);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡChinese�������Զ��巽��
	 */
	public void getChineseDeclaredMethods() {
		Class c = Chinese.class;
		Method[] methods = c.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println("Chinese�������Զ��巽��:" + m.getName());
		}
	}

	/**
	 * ��ȡChinese�����й�������
	 */
	public void getChineseMethods() {
		Class c = Chinese.class;
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			System.out.println("Chinese�����й�������:" + m.getName());
		}
	}

	/**
	 * ��ȡChinese�ĸ�����Ϣ
	 */
	public void getChineseSuper() {
		Class c = Chinese.class;
		Class sc = c.getSuperclass();
		System.out.println("Chinese�����й�������:" + sc.getName());

	}

	/**
	 * ��ȡChinese�Ľӿ���Ϣ
	 */
	public void getChineseInterface() {
		Class c = Chinese.class;
		Class[] interfaces = c.getInterfaces();
		for (Class i : interfaces) {
			System.out.println("Chinese�Ľӿ���Ϣ:" + i.getName());
		}
	}

	public void reflectPerson(String className, String name, int age)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> c = Class.forName(className);
		Object o = c.newInstance();
		// �ж����Ƿ�ʵ����fightable�ӿڣ����ʵ�������������Fight������
		Class[] interfaces = c.getInterfaces();
		for (Class i : interfaces) {
			System.out.println("Chinese�Ľӿ���Ϣ:" + i.getName());
			if ("reflectionWork.Fightable".equals(i.getName())) {
				Method m = c.getMethod("fight", new Class[] {});
				m.invoke(o, new Object[] {});
			}
		}
		// �ж��Ƿ���pingpang()���������������á�
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			// System.out.println("Chinese�ķ�����Ϣ:"+m.getName());
			if ("pingpang".equals(m.getName())) {
				Method m1 = c.getMethod("pingpang", new Class[] {});
				m1.invoke(o, new Object[] {});
			}
		}
		// �ж��Ƿ���pingpang()���������������á�
		for (Method m : methods) {
			if ("eatsusi".equals(m.getName())) {
				Method m1 = c.getMethod("eatsusi", new Class[] {});
				m1.invoke(o, new Object[] {});
			}
		}
	}
}
