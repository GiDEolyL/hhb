package reflection;

public class Dog {
	public String name;
	public int age;
	private String sex;
	public Dog() {
	
	}
	public Dog(String name,int age) {
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	public void run(){
		System.out.println("��������");
	}
	public void swim(){
		System.out.println("��������");
	}
	public void fly(){
		System.out.println("��������");
	}
	private void addAge(){
		this.age=age+1;
		System.out.println("��������");
	}
	
}
