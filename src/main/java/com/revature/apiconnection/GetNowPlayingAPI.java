package com.revature.apiconnection;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.http.converter.HttpMessageConverter;
import java.util.ArrayList;
import java.util.List;

import com.revature.Driver;
import com.revature.repository.NowPlayingList;

@Configuration

public class GetNowPlayingAPI {
	
	private static Logger logger = Logger.getLogger(Driver.class);
	RestTemplate restTemplate = new RestTemplate();
		
	  		public static void main(String[] args){
	  			 RestTemplate restTemplate = new RestTemplate();
	  			 String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=0c0310c62d5381ede7d4780860ab79f6&language=en-US&page=1";
	  			 List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
	  			logger.trace("Creating a list with the HttpMessageConverter, to put our JSON in");
	  			MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
	  			/*Switched to MappingJackson2HttpMessageCoverter from the MappingJacksonHttpMessageCoverter in the book because
	  			according to Stackoverflow the first one stopped with Spring3 and with Spring4 we have to use the one with 2
	  			in the name.
	  			https://www.javacodegeeks.com/wp-content/uploads/2017/01/Spring-Framework-Cookbook.pdf pg 115-118
	  			https://stackoverflow.com/questions/32356935/mappingjacksonhttpmessageconverter-not-found-with-spring4
	  			*/
	  			logger.trace("Attempting to create a method to convert the JSON");
	  			 messageConverters.add(map);
	  			 restTemplate.setMessageConverters(messageConverters);
	  			logger.trace("Gibby this isnt working");
	  			NowPlayingList resourceUrl = restTemplate.getForObject(url, NowPlayingList.class);

	  			logger.trace("Lets see if this works : "+ resourceUrl);
	  		}
}

//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/ParameterizedTypeReference.html