package io.harini.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.harini.models.Movie;
import io.harini.service.MovieService;

@RestController
@RequestMapping("/v1/api/movies")
@CrossOrigin(origins = "http://localhost:3000/")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/hello")
	public String home(){
		return "hello world";
	}
	
	@GetMapping
	public ResponseEntity<List<Movie>> allMovies(){
		return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
	}
	
//	@GetMapping("{id}")
//	public ResponseEntity<Optional<Movie>> movieById(@PathVariable ObjectId id){
//		return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(id),HttpStatus.OK);
//	}
	
	@GetMapping("{imdbId}")
	public ResponseEntity<Optional<Movie>> movieByImdb(@PathVariable String imdbId){
		return new ResponseEntity<Optional<Movie>>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
	}

}
