package com.airlineapp;

import com.airlineapp.exceptions.FlightNotFoundException;
import com.airlineapp.model.ClassType;
import com.airlineapp.model.DepartureTime;
import com.airlineapp.model.Flight;
import com.airlineapp.model.StopsType;
import com.airlineapp.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringAirlinesDatajpaApplication implements CommandLineRunner {
	@Autowired
	private IFlightService flightService;
	public static void main(String[] args) {
		SpringApplication.run(SpringAirlinesDatajpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flight flight = new Flight("ind80", 50, 3000, StopsType.NONSTOP.name(),
				"indigo", ClassType.BUSINESSCLASS.name(), "pune", "kochi",
				"2.00", LocalDate.of(2022, 05, 07),
				DepartureTime.EVENING.name(), LocalDateTime.of(2022, 05,
				07, 3, 30, 0), LocalDateTime.of(2022, 05, 07, 5, 30, 0));
		//flightService.addFlight(flight);
//		System.out.println(flightService.getByFlightId(7));
//		System.out.println(flightService.getByFlightName("In45rd"));
//		flightService.getByAirlineName("indigo").forEach(System.out::println);
//		flightService.getByStopsType(StopsType.NONSTOP.name()).forEach(System.out::println);
//		flightService.getByDateOfJourney(LocalDate.of(2022,05,07)).forEach(System.out::println);
//		System.out.println(flightService.getByArrival(LocalDateTime.of(2022,05,15 ,01,00,00)));
//		System.out.println(flightService.getByDeparture(LocalDateTime.of(2022,04,30 ,05,30,00)));
//		flightService.getByDuration("2.00").forEach(System.out::println);
//		flightService.getByClassType(ClassType.BUSINESSCLASS.name()).forEach(System.out::println);

		flightService.getBySourceAndDestination("pune","kochi").forEach(System.out::println);
//		flightService.getByAirlineNameAndClassType("indigo",ClassType.BUSINESSCLASS.name()).forEach(System.out::println);
//		flightService.getByAirlineNameAndDestination("VISTARA","kolkata").forEach(System.out::println);
//		flightService.getByAirlineNameAndDateOfJourney("AIRINDIA",LocalDate.of(2022,05,15)).forEach(System.out::println);

	}
}