package com.SpringBootCURDApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootCURDApplication.entity.Bus;
import com.SpringBootCURDApplication.service.BusService;

@RestController
public class BusController {

	@Autowired
	private BusService bs;

	@GetMapping("/allBus")
	public List<Bus> getAllBus() {
		return bs.getAllBus();
	}

	@PostMapping("/saveBus")
	public String SaveBusData(@RequestBody Bus bus) {
		return bs.SaveBusData(bus);
	}
	
	@PutMapping("/updatebus/{id}")
	public void updateBusData(@PathVariable int id,@RequestBody Bus bus) {
		bus.setId(id);
		bs.updateBusData(bus);
	}
	
	@DeleteMapping("/deleteBus/{id}")
	public void DeleteBusById(@PathVariable("id") int id)
	{
		bs.DeleteBusById(id);
	}
}
