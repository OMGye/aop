package cn.itcast.aop3;

public class ProxyUserDaoImpl implements UserDao {
    //降低耦合度
	private UserDao userDao;
	
	public ProxyUserDaoImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	public void add() {	 
		long start = System.currentTimeMillis();
		userDao.add();
		long end = System.currentTimeMillis();
		System.out.println("add执行时间为"+(end-start));
	}
	public void update() {
		long start = System.currentTimeMillis();
		userDao.update();
		long end = System.currentTimeMillis();
		System.out.println("update执行时间为"+(end-start));
	}

	@Override
	public void remove() {
		long start = System.currentTimeMillis();
		userDao.remove();
		long end = System.currentTimeMillis();
		System.out.println("remove执行时间为"+(end-start));
	}

	@Override
	public void show() {
		long start = System.currentTimeMillis();
		userDao.show();
		long end = System.currentTimeMillis();
		System.out.println("show执行时间为"+(end-start));
	}

}
