package io.harini.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.harini.models.reviews;
import io.harini.service.ReviewService;

@RestController
@RequestMapping("/v1/api/reviews")
@CrossOrigin(origins = "http://localhost:3000/")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
	public ResponseEntity<reviews> createReview(@RequestBody Map<String, String> payload){
		return new ResponseEntity<reviews>(reviewService.createAllReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
	}
	

}
