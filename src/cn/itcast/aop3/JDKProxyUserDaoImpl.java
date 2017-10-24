package cn.itcast.aop3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class JDKProxyUserDaoImpl implements InvocationHandler{
    //ע��ִ�ж���
	private Object userDao;
	//�������ص�invoke����
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = System.currentTimeMillis();
		Object retValue = method.invoke(userDao, args);
		long end = System.currentTimeMillis();
		System.out.println(method.getName()+"ִ��ʱ��Ϊ"+(end-start));
		return retValue;
	}
	//�õ��������
	public Object getProxy(Object userDao){
		this.userDao = userDao;
		/*Proxy�ṩ�ĵõ��������ķ�����
		 * ������������涯̬���������ֽ������
		 * ���������һ�������������������
		 * �ڶ������ֽ����������
		 * ��������InvocationHandler����
		 * ��Ϊproxy��̬���ɵ��ֽ����ļ�����ֻ���вι��췽��������ע����������Ա����ڷ����Ļص�
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
