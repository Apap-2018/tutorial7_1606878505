package com.apap.tutorial7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.service.CarService;
import com.apap.tutorial7.service.DealerService;

@RestController
@RequestMapping("/model")
public class ModelController {
	@Autowired
	private DealerService dealerService;
	
	@Autowired
	private CarService carService;
	
	@GetMapping()
	private List<CarModel> modelCar(@RequestParam("factory") String factory, Model model) {
		return carService.getByBrand(factory);
	}
}
