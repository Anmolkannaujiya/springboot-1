package com.Anmol.demo;

import com.Anmol.demo.dependencyinjection.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//		Student student = context.getBean(Student.class);
//
//		//USING BEAN
//		student.setAge((24));
//		student.setName("Anmol");
//
//		System.out.println(student.getName());
//		System.out.println(student.getAge());

		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();
	}

}
