package com.football.league.FootbalLeague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.*")
@SpringBootApplication

public class FootbalLeagueApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootbalLeagueApplication.class, args);
	}

}
