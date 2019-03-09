package ╦сие;

import java.lang.reflect.Field;

public class Swap {
	public static void main(String[] args) {
		Integer a = 10;
		Integer b = 20;
		System.out.println("a="+a+";b="+b);
		swap(a,b);
		System.out.println("a="+a+";b="+b);
	}
	public static void swap(Integer a,Integer b){
		int temp = a.intValue();
		try {
			Field value = Integer.class.getDeclaredField("value");
			value.setAccessible(true);
			value.set(a, b);
			value.set(b, new Integer(temp));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
