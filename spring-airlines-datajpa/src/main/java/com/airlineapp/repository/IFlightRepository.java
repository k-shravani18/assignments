package com.airlineapp.repository;

import com.airlineapp.exceptions.FlightNotFoundException;
import com.airlineapp.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IFlightRepository extends JpaRepository<Flight,Integer> {
    Flight findByFlightId(int flightId);
    List<Flight> findByFlightName(String flightName);
    List<Flight> findByTicketCost(double ticketCost);
    List<Flight> findByAirlineName(String airlineName);
    List<Flight> findByStopsType(String stopsType);
    List<Flight> findByDateOfJourney(LocalDate dateOfJourney);
    List<Flight> findByArrival(LocalDateTime arrival);
    List<Flight> findByDeparture(LocalDateTime departure);
    List<Flight> findByDuration(String duration);
    List<Flight> findByClassType(String classType);

    @Query("from Flight f where f.source=?1 and f.destination=?2")
    List<Flight> findBySourceAndDest(String source,String destination) throws FlightNotFoundException;
    @Query("from Flight f where f.airlineName=?1 and f.classType=?2")
    List<Flight> findByAirlineNAndClassType(String airlineName,String classType)throws FlightNotFoundException;
    @Query("from Flight f where f.airlineName=?1 and f.destination=?2")
    List<Flight> findByAirlineNAndDest(String airlineName,String destination)throws FlightNotFoundException;
    @Query("from Flight f where f.airlineName=?1 and f.dateOfJourney=?2")
    List<Flight> findByAirlineNAndDOfJourney(String airlineName, LocalDate dateOfJourney)throws FlightNotFoundException;
}
