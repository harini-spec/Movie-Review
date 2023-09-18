package io.harini.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.harini.models.Movie;
import io.harini.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> getAllMovies(){
		System.out.println(movieRepository.findAll());
		return movieRepository.findAll();
	}
	
	public Optional<Movie> getMovieById(ObjectId id){
		return movieRepository.findById(id);
	}
	
	public Optional<Movie> getMovieByImdbId(String imdbId){
		return movieRepository.findMovieByImdbId(imdbId);
	}

}
