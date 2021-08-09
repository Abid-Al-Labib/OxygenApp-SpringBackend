package com.oxygen.oxygenApp;

import com.oxygen.oxygenApp.entities.Booth;
import com.oxygen.oxygenApp.entities.Distributor;
import com.oxygen.oxygenApp.entities.Order;
import com.oxygen.oxygenApp.repository.BoothRepository;
import com.oxygen.oxygenApp.repository.DistributorRepository;
import com.oxygen.oxygenApp.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OxygenAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxygenAppApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BoothRepository br, DistributorRepository dr, OrderRepository or)
	{
		return args -> {

			Booth booth1 = new Booth(
					"Calgary",
					"UOFC",
					"Abid",
					"5523433232",
					0,
					0,
					"Consumer");

			Booth booth2 = new Booth(
					"Calgary",
					"Oxygen FACTORY",
					"Jack",
					"1111111111",
					0,
					0,
					"Factory");

//			Booth booth3 = new Booth(
//					"Bogra",
//					"Bogra uni",
//					"Asif",
//					"12338481456",
//					0,
//					0,
//					"Consumer");

			br.save(booth1);
			br.save(booth2);
//			br.save(booth3);

			Distributor distributor = new Distributor(
					"IEB",
					0,
					500,
					0,
					500);


			dr.save(distributor);







		};
	}

	public void populateDatabase(BoothRepository br, DistributorRepository dr, OrderRepository or)
	{

		Booth booth1 = new Booth(
				"Rajshahi",
				"RUET",
				"Alam",
				"01715046082",
				0,
				0,
				"CONSUMER");

		Booth booth2 = new Booth(
				"Chittagong",
				"CHUET",
				"Yeasin",
				"01711537711",
				0,
				0,
				"FACTORY");

		br.save(booth1);
		br.save(booth2);

		List<Booth> b = br.findBoothsByType("FACTORY");
		System.out.println(b.get(0).getId());

		Distributor distributor = new Distributor(
				"IEB",
				0,
				500,
				0,
				500);

		dr.save(distributor);



//		Order order1 = new Order(
//				"SEND",
//				"Large",
//				distributor.getName(),
//				booth1.getName(),
//				20,
//				new Date(),
//				distributor.getId()
//		);
//
//		Order order2 = new Order(
//				"RECEIVE",
//				"Small",
//				distributor.getName(),
//				booth1.getName(),
//				10,
//				new Date(),
//				distributor.getId()
//		);
//
//		Order order3 = new Order(
//				"SEND",
//				"Small",
//				distributor.getName(),
//				booth1.getName(),
//				50,
//				new Date(),
//				distributor.getId()
//		);

//		distributor.addOrder(order1);
//
//		dr.save(distributor);
//
//		distributor.addOrder(order2);

		dr.save(distributor);

		Distributor d;

		var val = dr.findById(distributor.getId());

		if(val.isPresent())
		{
			System.out.println(val.get());
		}

	}


}
