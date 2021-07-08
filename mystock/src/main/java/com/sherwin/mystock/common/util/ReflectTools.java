package com.sherwin.mystock.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTools {
	public static String getCurrentMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

	public static Method getMethod(String methodName, Class interfaceType) {
		Method[] methods = interfaceType.getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methodName.equals(methods[i].getName())) {
				return methods[i];
			}
		}
		return null;
	}
	/**
	 * 	获取字段值
	 * @param field
	 * @param object
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getFieldValue(Field field, Object object) throws IllegalArgumentException, IllegalAccessException {
		field.setAccessible(true);
		Object value = field.get(object);
		field.setAccessible(false);
		return value;
	}
}
