package cn.itcast.aop3;

public class ProxyUserDaoImpl implements UserDao {
    //������϶�
	private UserDao userDao;
	
	public ProxyUserDaoImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	public void add() {	 
		long start = System.currentTimeMillis();
		userDao.add();
		long end = System.currentTimeMillis();
		System.out.println("addִ��ʱ��Ϊ"+(end-start));
	}
	public void update() {
		long start = System.currentTimeMillis();
		userDao.update();
		long end = System.currentTimeMillis();
		System.out.println("updateִ��ʱ��Ϊ"+(end-start));
	}

	@Override
	public void remove() {
		long start = System.currentTimeMillis();
		userDao.remove();
		long end = System.currentTimeMillis();
		System.out.println("removeִ��ʱ��Ϊ"+(end-start));
	}

	@Override
	public void show() {
		long start = System.currentTimeMillis();
		userDao.show();
		long end = System.currentTimeMillis();
		System.out.println("showִ��ʱ��Ϊ"+(end-start));
	}

}
