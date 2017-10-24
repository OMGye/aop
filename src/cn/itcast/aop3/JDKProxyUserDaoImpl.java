package cn.itcast.aop3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class JDKProxyUserDaoImpl implements InvocationHandler{
    //注入执行对象
	private Object userDao;
	//代理对象回调invoke方法
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = System.currentTimeMillis();
		Object retValue = method.invoke(userDao, args);
		long end = System.currentTimeMillis();
		System.out.println(method.getName()+"执行时间为"+(end-start));
		return retValue;
	}
	//得到代理对象
	public Object getProxy(Object userDao){
		this.userDao = userDao;
		/*Proxy提供的得到代理对象的方法，
		 * 并在虚拟机里面动态的生成了字节码对象，
		 * 这个方法第一个参数是类加载器对象
		 * 第二个是字节码对象数组
		 * 第三个是InvocationHandler对象
		 * 因为proxy动态生成的字节码文件里面只有有参构造方法，并且注入这个对象以便用于方法的回掉
		 */
	   Object obj = Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(),this);	
		return obj;
		
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<String> list = new ArrayList<String>();
		Class clazz = list.getClass();
		list.add("123");
		Method method = clazz.getMethod("get",int.class);
		Object c = list;
		System.out.println(method.invoke(c, 0));
	}

}
