package com.springboot.my.org.crudapi.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.models.Title;
import com.springboot.my.org.crudapi.services.TitleService;
@RestController
@RequestMapping("/title")
public class TitleController {
	@Autowired
	TitleService titleService;
	@GetMapping("/titlebyid/{id}")
	public List<Title> getWorkerTitle(@PathVariable int id)  {

			return titleService.getWorkerTitle(id);
	}
	
	@GetMapping("/titlebydept/{dept}")
	public List<Title>  getAllWorkerTitleInDept(@PathVariable String dept) {
			return titleService. getAllWorkerTitleInDept(dept);

	}
	

	@PostMapping("create/{id}/promote/{title}")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@PathVariable int id, @PathVariable String title) {
		return titleService.createTitle(id, title);	
	}

	@DeleteMapping("delete/{id}")
	public boolean deleteTitle(@PathVariable int id) {
			return titleService.deleteTitle(id);
}
}