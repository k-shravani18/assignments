package com.sports.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerDetails {
    @Autowired

    Sports cricket;

    @Autowired
    Sports football;

    @Autowired
    Sports kabadi;

    List<String> printDetails(String choice){
        System.out.println("sports details");
        if(choice.equalsIgnoreCase("cricket"))
            return cricket.showPlayers();
        if(choice.equalsIgnoreCase("football"))
            return football.showPlayers();
        if(choice.equalsIgnoreCase("kabadi"))
            return kabadi.showPlayers();
        return null;
    }
}
