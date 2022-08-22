package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.model.Bus;
import com.training.repository.IBusRepository;

@SpringBootApplication
public class SpringBussappJdbcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBussappJdbcApplication.class, args);
	}

	@Autowired
	IBusRepository busRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Bus bus=new Bus("Salem", "Mangalore", 9, "NonAC", 880);
		busRepository.addBus(bus);
		
		busRepository.deleteBus(10);
		
		busRepository.updateBus(2500, 5);
		

		busRepository.findAll().forEach(System.out::println);
		System.out.println();
		busRepository.findByType("Ac").forEach(System.out::println);
		System.out.println();
		System.out.println(busRepository.findById(2)); 
		System.out.println();
		busRepository.findBySourceDestination("Pune", "Bangalore").forEach(System.out::println);
		
		
	}

}
