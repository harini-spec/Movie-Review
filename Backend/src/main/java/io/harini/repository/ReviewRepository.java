package io.harini.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.harini.models.reviews;

@Repository
public interface ReviewRepository extends MongoRepository<reviews, ObjectId>{

}
