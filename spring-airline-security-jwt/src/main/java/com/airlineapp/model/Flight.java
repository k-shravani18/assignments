package com.airlineapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Flight {
    @Column(length = 20)
    String flightName;//("AirBus A321Cr")
    @Id
    @GeneratedValue(generator = "flight_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "flight_gen",sequenceName = "flight_sequence",initialValue = 1,allocationSize = 1)
    private int flightId;
    private int capacity;//(80)
    private double ticketCost;
    private  String stopsType;//(stop,nonstop)//Enum
    private String airlineName; // enum
    private String classType;//(business class,economy,premium economy)
    private  String source;
    private String destination;
    private String duration;
    private LocalDate dateOfJourney;
    private String departureTime;// enum(morning, afternoon)
    private LocalDateTime arrival;
    private LocalDateTime departure;

}
