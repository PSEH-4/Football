package com.football.league.service;

import java.util.List;

import com.football.league.constants.StandingLeagueResponse;

public interface ServiceLeague {

	public abstract List<StandingLeagueResponse> getStandingLeagueData(String countryname);
}
