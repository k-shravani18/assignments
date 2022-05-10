package com.sports.autowiring;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component("football")
public class Football implements Sports {
    public List<String> showPlayers() {
        List<String> playerList= Arrays.asList("ram","john","sam","kiran","charan");
        return playerList;
    }
}
