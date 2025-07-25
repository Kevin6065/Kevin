package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.Carconfig;
import com.model.Toyota;

public class JavaMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Carconfig.class);
		
		
		
		Toyota toyota= (Toyota)ctx.getBean("toyota");
		toyota.move();
		System.out.println(toyota);
	}

}
