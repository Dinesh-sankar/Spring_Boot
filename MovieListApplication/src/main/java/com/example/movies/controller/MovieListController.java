package com.example.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.movies.model.Movie;
import com.example.movies.repository.MovieListRepository;

@Controller
@RequestMapping("/")
public class MovieListController {

	@Autowired
	private MovieListRepository movieListRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/movies/{actor}")						//Any get request with value of /movies will come here
	public String getMovieByActor(@PathVariable("actor") String name, Model model) {		//Assigning the values in name 
		
		/* List<Movie> movieList = new ArrayList<Movie>();		
		Movie movie = new Movie();
		//HardCoding the value of Movie
		movie.setActor("Tom");
		movie.setDescription("Mission possible");
		movie.setName("MI3");
		movieList.add(movie); */
		
		List<Movie> movieList = movieListRepository.findByActor(name);		//Returning the movies by actor and storing it into the movielist
		model.addAttribute("movies", movieList);	
		return "movieList";													//Returns the view page from template
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/movies", consumes="application/json")
	public ResponseEntity<Object> addMovie(@RequestBody Movie movie) {
		movieListRepository.save(movie);
		return ResponseEntity.ok().build();
	}
	
}
