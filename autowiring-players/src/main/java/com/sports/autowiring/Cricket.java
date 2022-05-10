package com.sports.autowiring;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component("cricket")
public class Cricket implements Sports {


    @Override
    public List<String> showPlayers() {
        List<String> playerList=Arrays.asList("Dhoni","virat","rahul","rohit","shreyas");
        return  playerList;
    }

}
