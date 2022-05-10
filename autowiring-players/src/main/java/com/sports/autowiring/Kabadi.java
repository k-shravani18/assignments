package com.sports.autowiring;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component("kabadi")
public class Kabadi implements Sports {
    public List<String> showPlayers() {

        List<String> playerList= Arrays.asList("sruthi","padma","","veda","kiran","sudha");
        return playerList;
    }

}
