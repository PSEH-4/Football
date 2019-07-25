package com.football.league.FootbalLeague;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class footballController {

	
	@RequestMapping(value = "/checkfootball", method = RequestMethod.GET)
	public ResponseEntity<String> getcheck()
	{
		return new ResponseEntity<String>("UP",HttpStatus.OK);
	}
}
