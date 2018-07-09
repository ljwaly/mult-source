package com.jw.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jw.domain.movie.Movie;
import com.jw.jpa.dao.MovieRepository;



@RestController
@RequestMapping("/movie")
public class MovieController extends BaseController {

	@Autowired
	private MovieRepository movieRepository;
	
	@RequestMapping("/test")
	public Map<String, Object> test(){
		Map<String, Object>  map = new HashMap<String, Object>();
		
		Movie m = new Movie();
//		m.setMovieId("1");
		m.setDuration(180L);
		m.setName("zhanlang");
		Movie save = movieRepository.save(m);
		map.put("result", save);
		
		return map;
	}
	
	@RequestMapping("/getAll")
	public Map<String, Object> getAllMovie(){
		Map<String, Object>  map = new HashMap<String, Object>();
		
	
		List<Movie> findAll = movieRepository.findAll();
		map.put("result", findAll);
		
		return map;
	}
	
	
	
}
