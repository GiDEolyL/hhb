package reflectionWork;

import java.lang.reflect.InvocationTargetException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		String Person="reflectionWork.Person";
		String Chinese="reflectionWork.Chinese";
		String Japanese="reflectionWork.Japanese";
		String Wrong="reflectionWork.jjj";
		Methods m=new Methods();
		
//		m.reflectPerson(Person, "keke1",21 );
//		m.reflectPerson(Chinese, "keke2",22 );
//		m.reflectPerson(Japanese, "keke3",23 );
//		m.reflectPerson(Wrong, "keke4",24 );
		
		MyObjectFactory my=new MyObjectFactory();
		my.getObject(Person);
		
	}

}
