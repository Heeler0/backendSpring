package com.example.votingapi.controllers;

import com.example.votingapi.database.Votes;
import com.example.votingapi.database.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class VoteController {

    @Autowired
    VotesRepository votesRepository;

    @RequestMapping(value = "/vote", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String process(@RequestBody Map<String, String> animalType) {
        try {
            Votes vote = new Votes(animalType.get("animal"));
            votesRepository.save(vote);

        } catch (Exception e) {
            return "Could not place the vote";
        }
        return "Success";
    }

}
