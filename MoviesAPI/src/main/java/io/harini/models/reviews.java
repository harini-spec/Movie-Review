package io.harini.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "review")
@NoArgsConstructor
@AllArgsConstructor
public class reviews {
	
	@Id
	private ObjectId id;
	private String review;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public reviews(String review) {
		super();
		this.review = review;
	}
	
}
