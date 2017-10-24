package cn.itcast.aop3;

public class UserDaoImpl implements UserDao{

	@Override
	public void add() {
		System.out.println("add.......");
		
	}

	@Override
	public void update() {
		System.out.println("update..........");
		
	}

	@Override
	public void remove() {
		System.out.println("remove.......");
		
	}

	@Override
	public void show() {
	System.out.println("show........");
		
	}

}
