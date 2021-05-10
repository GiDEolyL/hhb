package studentmanager;

import java.util.Comparator;

public class ComBySum implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int num=o2.getSum()-o1.getSum();
		return num;
	}
	
}