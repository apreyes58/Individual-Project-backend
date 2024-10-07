package com.example.individualproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {
    @Autowired
    private Top5ActorRepo top5;

    public List<Actor> topFive()
    {
        List<Object[]> objects = top5.getTopFiveActors();
        List<Actor> bestActors = new ArrayList<>();

        for (Object[] actor: objects)
        {
            String id = String.valueOf(actor[0]);
            String first_name = String.valueOf(actor[1]);
            String last_name =  String.valueOf(actor[2]);

            bestActors.add(new Actor(id, first_name, last_name));
        }
        return bestActors;
    }
}