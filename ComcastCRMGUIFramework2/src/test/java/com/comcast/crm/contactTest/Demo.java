package com.comcast.crm.contactTest;

import org.testng.annotations.Test;

public class Demo {

	int a ;
	
	public static void main(String[] args) {
		
		System.out.println("Main Starts");
			
		Demo d = new Demo();
		d.simple();
	}
	
	public void simple() {
		
		int b=20;
		a = Demo.test();
		System.out.println(a);
		System.out.println(b);
	}
	
	public static int test() {
		System.out.println("hi");
		return 5;
	}
}
