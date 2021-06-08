package reflectionWork;

import java.lang.reflect.Field;

public class MyObjectFactory {
	public Object getObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Class c=Class.forName(className);
		Object o=c.newInstance();
		Field[] fields=c.getDeclaredFields();
		System.out.println("4646486486:"+fields.length);
		for(Field field:fields){
			//System.out.println("hasudhui:"+field.getName());
			Field f=c.getDeclaredField(field.getName());
			f.setAccessible(true);
			if("name".equals(field.getName())){
				f.set(o, "name initial value");
				System.out.println("1£º"+f.get(o));
			}else if("age".equals(field.getName())){
				f.set(o, 1);
				System.out.println("2£º"+f.get(o));
			}
		}
		Field[] fff=o.getClass().getDeclaredFields();
		for(Field ss:fff){
			System.out.println("3£º"+ss.get(o));
		}
		return  o;
	}
	
}
