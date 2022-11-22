package com.devsuperior.desafio_aula_8;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;
import com.devsuperior.services.ShipmentService;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class DesafioAula8Application implements CommandLineRunner {
	
	private OrderService orderService;

	public DesafioAula8Application(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(DesafioAula8Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Codigo: ");
		int code = sc.nextInt();
		System.out.print("Valor basico: ");
		double basic = sc.nextDouble();
		System.out.print("Desconto: ");
		double discount = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);
				
		System.out.println(orderService.total(order));
		
		sc.close();
	}

}
