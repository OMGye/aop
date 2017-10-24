package cn.itcast.aop3;

public class Test {
   public static void main(String[] args) {
	UserDao userDao = new UserDaoImpl();
	JDKProxyUserDaoImpl jdkProxyUserDaoImpl = new JDKProxyUserDaoImpl();
	UserDao proxyuserDao = (UserDao)jdkProxyUserDaoImpl.getProxy(userDao);
	proxyuserDao.add();
	ProductDao productDao = new ProductDaoImpl();
	JDKProxyUserDaoImpl jdkProxyUserDaoImpl2 = new JDKProxyUserDaoImpl();
	ProductDao proxyproductDao = (ProductDao)jdkProxyUserDaoImpl2.getProxy(productDao);
	proxyproductDao.buy();
}
}
