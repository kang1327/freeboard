package com.raon.raonqna.kms.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raon.raonqna.kms.service.freeboard.FreeboardInfoService;
import com.raon.raonqna.kms.service.freeboard.FreeboardListService;
import com.raon.raonqna.kms.service.freeboard.FreeboardWriteService;


@Controller
public class FreeboardController {
	
	
	@Autowired
	private FreeboardListService freeboardListService;
	
	@Autowired
	private FreeboardWriteService freeboardWriteService;
	
	@Autowired
	private FreeboardInfoService freeboardInfoService;
	
	private int returnIntValue(String stringToInt) {
		return Integer.parseInt(stringToInt);
	}
	
	@GetMapping("/freeboard")
	public String freeboard(@RequestParam(value="stringToInt",defaultValue = "1")String pageNum) {
	String page  = freeboardListService.freeboardList(returnIntValue(pageNum));
	return page;

	}
	
	@PostMapping("/freeboardWriteRequest")
	public String freeboardWriteRequest(@RequestParam Map<String, String> paraMap) {
		
		String content =paraMap.get("content");
		String title = paraMap.get("title");
		String writer =paraMap.get("writer");
		
		freeboardWriteService.write(title, content, writer);
		
		return "redirect:/freeboard";
	}
	
	
	
	@GetMapping("/freeBoardInfo")
	public String getPost(@RequestParam(value="freeId") String freeId) {
		String page = freeboardInfoService.getFreeboardPost(freeId);
		
		return page;
	}
}
