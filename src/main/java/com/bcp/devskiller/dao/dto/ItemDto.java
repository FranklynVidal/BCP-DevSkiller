package com.bcp.devskiller.dao.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDto {
	
	public interface ItemView{
		public static interface ItemGet{}
	}
	
	@JsonView(ItemView.ItemGet.class)
	private String title;

}
