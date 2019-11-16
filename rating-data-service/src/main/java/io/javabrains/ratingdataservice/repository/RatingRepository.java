package io.javabrains.ratingdataservice.repository;

import io.javabrains.ratingdataservice.models.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

}
