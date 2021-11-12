package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository) {
		return (args) -> {
			//保存一些Customer
			customerRepository.save(new Customer("Jack", "Bauer"));
			customerRepository.save(new Customer("Chloe", "0`Brain"));
			customerRepository.save(new Customer("Kim", "Bauer"));
			customerRepository.save(new Customer("David", "Palmer"));
			customerRepository.save(new Customer("Michelle", "Kessler"));


			//查询所有的数据
			log.info("查询所有的客户");
			log.info("-----------");
			for (Customer customer : customerRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			//获取单个客户通过id
			Customer customer = customerRepository.findById(1L);
			log.info("获取单个客户通过 findById(1L)");
			log.info("----------------------------");
			log.info(customer.toString());
			log.info("");

			//获取客户通过姓
			log.info("获取客户通过姓 findByLastName('Bauer'):");
			log.info("------------------------------------");
			customerRepository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});

			//获得客户通过名字和id
			log.info("获得客户通过名字和id:findByIdAndLastName('1L','Bauer')");
			log.info("-------------------");
			customerRepository.findByIdAndLastName(1L,"Bauer").forEach(bauer -> {
			    log.info(bauer.toString());
			});

//			//获得最顶端的id
//			log.info("获得最顶端的id:");
//			log.info("-------------");
//			Customer customer1 = customerRepository.findTopById();
//			log.info(customer1.toString());
		};
	}
}
