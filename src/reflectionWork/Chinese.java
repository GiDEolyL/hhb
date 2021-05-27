package reflectionWork;

public class Chinese extends Person implements Fightable {

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		System.out.println("中国人打架");
	}

	public void pingpang(){
		System.out.println("中国人打乒乓球");
	}
}
