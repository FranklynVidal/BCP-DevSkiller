package com.bcp.devskiller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.devskiller.dao.dto.ItemDto.ItemView;
import com.bcp.devskiller.dao.model.Item;
import com.bcp.devskiller.service.ItemService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;

	// APPLICATION_JSON_UTF8_VALUE: Deprecated
	@GetMapping(path = "/titles", produces = MediaType.APPLICATION_JSON_VALUE)
	List<String> getTitles(@RequestParam Double rating) {
		return itemService.getTitles(rating);
	}

	@GetMapping(path = "/ratings", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Item> findItemsWithAverageRatingLowerThan(@RequestParam Double rating) {
		return itemService.findItemsWithAverageRatingLowerThanJPQL(rating);
	}

	@JsonView(ItemView.ItemGet.class)
	@GetMapping(path = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Item> getAll() {
		return itemService.findAll();
	}

}
