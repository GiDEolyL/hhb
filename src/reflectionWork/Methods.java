package reflectionWork;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Methods {
	/**
	 * 3种不同的方法获得Person的Class对象
	 * 
	 * @param person
	 */
	public void getPersonClass(Person person) {
		// 通过object的getClass方法
		Class p = person.getClass();

		// 通过类的路径
		String className = "reflectionWork.Person";
		try {
			Class p1 = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 通过知道类的名字
		Class p2 = Person.class;
	}

	/**
	 * 用不同方法创建Person对象的实例
	 */
	public void getPersonNewIntance() {
		Class p = Person.class;
		try {
			// 1 通过空的构造函数
			Object o1 = p.newInstance();
			// 2 通过其他构造函数
			Constructor<Person> c = p.getConstructor(new Class[] { String.class, int.class });
			Object o2 = c.newInstance(new Object[] { "黄河壶口瀑布", 5 });
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
	 * 调用set和get方法改写属性的值（需要先修改accessAttribute)
	 */
	public void getSetValues() {
		Class p = Person.class;
		try {
			Object o = p.newInstance();
			Field field = p.getDeclaredField("name");
			field.setAccessible(true);
			field.set(o, "大姐姐");
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
	 * 获取Chinese的所有自定义方法
	 */
	public void getChineseDeclaredMethods() {
		Class c = Chinese.class;
		Method[] methods = c.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println("Chinese的所有自定义方法:" + m.getName());
		}
	}

	/**
	 * 获取Chinese的所有公开方法
	 */
	public void getChineseMethods() {
		Class c = Chinese.class;
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			System.out.println("Chinese的所有公开方法:" + m.getName());
		}
	}

	/**
	 * 获取Chinese的父类信息
	 */
	public void getChineseSuper() {
		Class c = Chinese.class;
		Class sc = c.getSuperclass();
		System.out.println("Chinese的所有公开方法:" + sc.getName());

	}

	/**
	 * 获取Chinese的接口信息
	 */
	public void getChineseInterface() {
		Class c = Chinese.class;
		Class[] interfaces = c.getInterfaces();
		for (Class i : interfaces) {
			System.out.println("Chinese的接口信息:" + i.getName());
		}
	}

	public void reflectPerson(String className, String name, int age)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> c = Class.forName(className);
		Object o = c.newInstance();
		// 判断类是否实现了fightable接口，如果实现了则调用它的Fight方法。
		Class[] interfaces = c.getInterfaces();
		for (Class i : interfaces) {
			System.out.println("Chinese的接口信息:" + i.getName());
			if ("reflectionWork.Fightable".equals(i.getName())) {
				Method m = c.getMethod("fight", new Class[] {});
				m.invoke(o, new Object[] {});
			}
		}
		// 判断是否有pingpang()方法，如果有则调用。
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			// System.out.println("Chinese的方法信息:"+m.getName());
			if ("pingpang".equals(m.getName())) {
				Method m1 = c.getMethod("pingpang", new Class[] {});
				m1.invoke(o, new Object[] {});
			}
		}
		// 判断是否有pingpang()方法，如果有则调用。
		for (Method m : methods) {
			if ("eatsusi".equals(m.getName())) {
				Method m1 = c.getMethod("eatsusi", new Class[] {});
				m1.invoke(o, new Object[] {});
			}
		}
	}
}
