package com.bcp.devskiller.service;

import java.util.List;

import com.bcp.devskiller.dao.model.Item;

public interface ItemService {

	List<String> getTitles(Double rating);

	List<Item> findItemsWithAverageRatingLowerThanJPQL(Double rating);

	List<Item> findItemsWithAverageRatingLowerThanNQ(Double rating);

	List<Item> findAll();

}
