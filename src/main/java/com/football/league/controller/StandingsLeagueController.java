package com.football.league.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.football.league.constants.StandingLeagueResponse;
import com.football.league.exception.FootballException;
import com.football.league.service.ServiceLeague;





@RestController
public class StandingsLeagueController {

	@Autowired
	private ServiceLeague serviceleague;

	
	@RequestMapping(value = "/getleaguestandings/countryName/{countryname}", method = RequestMethod.GET)
	public ResponseEntity<List<StandingLeagueResponse>> getleaguestandings(@PathVariable String countryname) throws FootballException
	{
		
		List<StandingLeagueResponse> responselist=serviceleague.getStandingLeagueData(countryname);
		
		return new ResponseEntity<List<StandingLeagueResponse>>(responselist,HttpStatus.OK);
		}	
	
	
	}

