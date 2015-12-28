package com.redoddity.faml;


import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Utils {
	private static final Log log = LogFactory.getLog(Utils.class);

	public static boolean equals(Object bean1, Object bean2) {
		if (bean1 == bean2)
			return true;
		if ((bean1 != null && bean2 == null) || (bean1 == null && bean2 != null)) {
			return false;
		}		
		if (bean1.getClass() != bean2.getClass()) {
			return false;
		}		
		try {
			BeanInfo bean1Info = Introspector.getBeanInfo(bean1.getClass(),
					Object.class);
			for (PropertyDescriptor p : bean1Info.getPropertyDescriptors()) {
				Method reader = p.getReadMethod();
				if (reader != null) {
					Object value1 = reader.invoke(bean1);
					Object value2 = reader.invoke(bean2);
					Boolean result=null;//handle primitive types
					if((result=handlePrimitives(value1,value2))!=null){
						return result;
					}
					if ((value1 != null && !value1.equals(value2))
							|| (value2 != null && !value2.equals(value1))) {
						return false;
					}
				}
			}
		} catch (IllegalAccessException iae) {
			log.error(iae.getMessage(), iae);
		} catch (IntrospectionException ie) {
			log.error(ie.getMessage(), ie);
		} catch (IllegalArgumentException iarge) {
			log.error(iarge.getMessage(), iarge);
		} catch (InvocationTargetException ite) {
			log.error(ite.getMessage(), ite);
		}
		return true;
	}

	private static Boolean handlePrimitives(Object o1, Object o2) {
		if (o1 instanceof int[]){			
			return Arrays.equals((int[])o1,     (int[])o2);
		}else if(o1 instanceof byte[]){
			return Arrays.equals((byte[])o1,    (byte[])o2);							
		}else if(o1 instanceof boolean[]){
			return Arrays.equals((boolean[])o1, (boolean[])o2);							
		}else if(o1 instanceof char[]){
			return Arrays.equals((char[])o1,    (char[])o2);			
		}else if(o1 instanceof float[]){
			return Arrays.equals((float[])o1,   (float[])o2);							
		}else if(o1 instanceof double[]){
			return Arrays.equals((double[])o1,  (double[])o2);							
		}else if(o1 instanceof long[]){
			return Arrays.equals((long[])o1,    (long[])o2);							
		}else if(o1 instanceof short[]){
			return Arrays.equals((short[])o1,   (short[])o2);							
		}
		return null;				
	}
}
