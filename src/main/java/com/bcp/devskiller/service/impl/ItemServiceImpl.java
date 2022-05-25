package com.bcp.devskiller.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.devskiller.dao.model.Item;
import com.bcp.devskiller.dao.repositories.ItemRepository;
import com.bcp.devskiller.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<String> getTitles(Double rating) {
		List<Item> items = itemRepository.findItemsWithAverageRatingLowerThan(rating);
		List<String> titles = new ArrayList<String>();

		if (items.size() > 0) {
			for (Item item : items) {
				titles.add(item.getTitle());
			}
		}

		return titles;
	}

	@Override
	public List<Item> findItemsWithAverageRatingLowerThanJPQL(Double rating) {
		return itemRepository.findItemsWithAverageRatingLowerThanJPQL(rating);
	}

	@Override
	public List<Item> findItemsWithAverageRatingLowerThanNQ(Double rating) {
		return itemRepository.findItemsWithAverageRatingLowerThanJPQL(rating);
	}

	@Override
	public List<Item> findAll() {

		return itemRepository.findAll();
	}

}
