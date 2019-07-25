package com.footbal.league.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.football.league.constants.StandingLeagueResponse;
import com.football.league.controller.StandingsLeagueController;
import com.football.league.service.StandlingLeagueService;

@RunWith(MockitoJUnitRunner.class)
public class FootballLeagueStandingTest {
	
	@Mock
	private StandlingLeagueService standingservice;
	
	@InjectMocks
	private StandingsLeagueController controller;
	
	@Mock
	StandingLeagueResponse standingmodel;
	@Test
	public void ServiceLeagueTest()
	{
		List<StandingLeagueResponse> list=new ArrayList<StandingLeagueResponse>();
		list.add(standingmodel);
		
		Mockito.when(standingservice.getStandingLeagueData("abc")).thenReturn(list);
		controller.getleaguestandings("def");
		
	}

}
