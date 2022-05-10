package com.airlineapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Flight {
    String flightName;//("AirBus A321Cr")
    @Id
    @GeneratedValue(generator = "flight_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "flight_gen",sequenceName = "flight_sequence",initialValue = 1,allocationSize = 1)
    int flightId;
    int capacity;//(80)
    double ticketCost;
    String stopsType;//(stop,nonstop)//Enum
    String airlineName; // enum
   String classType;//(business class,economy,premium economy)
    String source;
    String destination;
    String duration;
    LocalDate dateOfJourney;
    String departureTime;// enum(morning, afternoon)
    LocalDateTime arrival;
    LocalDateTime departure;

    public Flight(String flightName, int capacity, double ticketCost, String stopsType, String airlineName, String classType, String source, String destination, String duration, LocalDate dateOfJourney, String departureTime, LocalDateTime arrival, LocalDateTime departure) {
        this.flightName = flightName;
        this.capacity = capacity;
        this.ticketCost = ticketCost;
        this.stopsType = stopsType;
        this.airlineName = airlineName;
        this.classType = classType;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.dateOfJourney = dateOfJourney;
        this.departureTime = departureTime;
        this.arrival = arrival;
        this.departure = departure;
    }
}
