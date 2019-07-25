package com.football.league.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class StandingLeagueService {
	
	@InjectMocks
	private StandlingLeagueService serviceImpl;
	
	@Mock
	private ServiceLeague serviceleague;
	
	@Mock 
	private RestTemplate restTemplate;
	@Test
	public void test_getStandingEvents()
	{
		ResponseEntity<Object> response=null;
		response=new ResponseEntity<Object>(HttpStatus.OK);
		
		Mockito.when(restTemplate.getForEntity(Mockito.anyString(),ArgumentMatchers.any(Class.class))).thenReturn(response);
		serviceImpl.getStandingLeagueData("India");
	}

}
