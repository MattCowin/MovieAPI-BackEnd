package com.revature.apiconnection;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.client.RestTemplate;

public class GetNowPlayingAPI {
		
	RestTemplate restTemplate = new RestTemplate();
	String resourceUrl = "https://api.themoviedb.org/3/movie/now_playing?api_key=0c0310c62d5381ede7d4780860ab79f6&language=en-US&page=1";
}
