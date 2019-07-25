package com.football.league.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.football.league.constants.Country;
import com.football.league.constants.FootballLeagueConstants;
import com.football.league.constants.League;
import com.football.league.constants.StandingLeagueResponse;
import com.football.league.exception.FootballException;

@Service
public class StandlingLeagueService implements ServiceLeague{

	@Override
	public List<StandingLeagueResponse> getStandingLeagueData(String countryname) {
		// TODO Auto-generated method stub
		RestTemplate resttemplate=new RestTemplate();

		// get the country id
		String getcountryurl="https://apifootball.com/api/?action=get_countries&APIkey="+FootballLeagueConstants.APIKEY;
		ResponseEntity<Country[]> responsecountryList=resttemplate.getForEntity(getcountryurl,Country[].class);
		 // iterate the object array
		String country_Id="";
		String League_Id="";
		
		for(Country country:responsecountryList.getBody())
		{
			if(countryname.equalsIgnoreCase(country.getCountry_name()))
			{
				country_Id=country.getCountry_id();
			}
			
		}
		
		if(StringUtils.isEmpty(country_Id))
		{
			throw new FootballException("Country does not exist in League");
		}
		
		String leagueUrl="https://apifootball.com/api/?action=get_leagues&country_id=+"+country_Id+"&APIkey="+FootballLeagueConstants.APIKEY;
		ResponseEntity<League[]> responseLeagueList=resttemplate.getForEntity(leagueUrl, League[].class);
		for(League league:responseLeagueList.getBody())
		{
			League_Id=league.getLeague_id();
		}
		
		// get standings
		
		String standingUrl="https://apifootball.com/api/?action=get_standings&league_id="+League_Id+"&APIkey="+FootballLeagueConstants.APIKEY;
		
		ResponseEntity<Object[]> standingresponse=resttemplate.getForEntity(standingUrl,Object[].class);
		System.out.println(standingresponse.getBody());
		 JSONArray jsonArray = new JSONArray(standingresponse.getBody());

			List<StandingLeagueResponse> list=new ArrayList<StandingLeagueResponse>();
			StandingLeagueResponse leagueResponse=null;
         for(int i=0;i<jsonArray.length();i++)
         {
             JSONObject jsonObject1 = jsonArray.getJSONObject(i);
             String leagueposition = jsonObject1.optString("overall_league_position");
             String teamname= jsonObject1.optString("team_name");
             String leaguename=jsonObject1.optString("league_name");
            String leagueid= jsonObject1.optString("league_id");
            String countrynameval= jsonObject1.optString("country_name");
            leagueResponse=new StandingLeagueResponse();
            leagueResponse.setCountry_id(country_Id);
            leagueResponse.setCountry_name(countrynameval);
            leagueResponse.setLeague_name(leaguename);
            leagueResponse.setLegaue_id(leagueid);
            leagueResponse.setTeam_id(" ");
            leagueResponse.setTeam_name(teamname);
            leagueResponse.setOverall_league_position(leagueposition);
            list.add(leagueResponse);
    
         }
		
		return list;
	}

}
