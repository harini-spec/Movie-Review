package io.harini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import io.harini.models.Movie;
import io.harini.models.reviews;
import io.harini.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public reviews createAllReview(String reviewBody, String imdbId) {
		reviews review = reviewRepository.save(new reviews(reviewBody));
		
		mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId)).apply(new Update().push("reviewIds").value(review)).first();
		
		return review;
	}

}
