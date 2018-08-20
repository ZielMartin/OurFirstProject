package de.mavid.data.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ReflectionAdapter {

	private Class<?> from, to;
	private List<String> methods;

	public ReflectionAdapter(Class<?> from, Class<?> to) {
		this.from = from;
		this.to = to;
		
		this.methods = getSameMethods(from, to);

	}

	public List<String> getSameMethods(Class<?> from, Class<?> to) {
		List<String> list = new ArrayList<>();
		Method f[] = from.getMethods();
		Method t[] = to.getMethods();

		List<String> getter = new ArrayList<>();
		List<String> setter = new ArrayList<>();

		for (Method m : f) {
			String methodName = m.getName();
			if (methodName.substring(0, 3).equals("set")) {
				setter.add(methodName.substring(3));
			} else if (methodName.substring(0, 3).equals("get")) {
				getter.add(methodName.substring(3));
			}
		}

		List<String> getter2 = new ArrayList<>();
		List<String> setter2 = new ArrayList<>();

		for (Method m : t) {
			String methodName = m.getName();
			if (methodName.substring(0, 3).equals("set")) {
				setter2.add(methodName.substring(3));
			} else if (methodName.substring(0, 3).equals("get")) {
				getter2.add(methodName.substring(3));
			}
		}

		for (String methodName : getter) {
			if (setter.contains(methodName) && getter2.contains(methodName) && setter2.contains(methodName)) {
				list.add(methodName);
			}
		}
		return list;
	}

	public <T> T get(Object from) {
		T to = null;
		try {
			to = (T) getClass().getClassLoader().loadClass(this.to.getName()).newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String method : this.methods) {
			try {
				Method getter = this.from.getMethod("get" + method, null);
				Method setter = this.to.getMethod("set" + method, null);
				
				setter.invoke(to, getter.invoke(from, null));
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return to;
	}
}
