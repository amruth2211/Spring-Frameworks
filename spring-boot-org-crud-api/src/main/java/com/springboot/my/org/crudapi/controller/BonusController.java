package com.springboot.my.org.crudapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.models.Bonus;
import com.springboot.my.org.crudapi.services.BonusService;

@RestController
@RequestMapping("/bonus")
public class BonusController {
	
	@Autowired
	BonusService bonusService;
	
	@GetMapping("/bonusbydept/{dept}")
	public List<Bonus> showWorker(@PathVariable String dept) {
		return bonusService.getBonusByDept(dept);
	}
	
	
	@GetMapping("/bonusbyid/{id}")
	public List<Bonus> showWorkersWithBonus(@PathVariable int id) {
		return bonusService.getWorkerWithBonus(id);
	}
	
	@PostMapping("/create/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@PathVariable int id,@RequestBody Bonus bonus) {
		return bonusService.createBonus(id,bonus);	
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable int id) {
		return bonusService.deleteBonus(id);
	}
	
}