package com.bcp.devskiller.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bcp.devskiller.dao.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("select i from Item i join i.reviews r where r.rating < :rating")
	List<Item> findItemsWithAverageRatingLowerThan(@Param("rating") Double rating);

	@Query("select i from Item i join i.reviews r where r.rating < :rating")
	List<Item> findItemsWithAverageRatingLowerThanJPQL(@Param("rating") Double rating);

	@Query(value = "select * from tb_item i, tb_review r where i.id = r.id and r.rating < :rating", nativeQuery = true)
	List<Item> findItemsWithAverageRatingLowerThanNQ(@Param("rating") Double rating);

}
