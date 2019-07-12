package com.raon.raonqna.kms.service.freeboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raon.raonqna.kms.Model.Freeboard;
import com.raon.raonqna.kms.repository.FreeboardRepository;

@Service
public class FreeboardWriteService {
	
	@Autowired
	FreeboardRepository freeboardRepository;
	
	public void write(String title, String content, String writer) {
		Freeboard freeboard = new Freeboard();
		freeboard.setTitle(title);
		freeboard.setContent(content);
		freeboard.setWriter(writer);
		freeboardRepository.save(freeboard);
	}

}
