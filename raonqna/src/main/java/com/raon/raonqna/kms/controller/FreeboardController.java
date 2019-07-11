package com.raon.raonqna.kms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.raon.raonqna.kms.service.freeboard.FreeboardListService;


@Controller
public class FreeboardController {
	
	
	@Autowired
	private FreeboardListService freeboardListService;
	
	private int returnIntValue(String stringToInt) {
		return Integer.parseInt(stringToInt);
	}
	
	@GetMapping("/freeboard")
	public String freeboard(@RequestParam(value="stringToInt",defaultValue = "1")String pageNum) {
	String page  = freeboardListService.freeboardList(returnIntValue(pageNum));
	return page;

	}
}
