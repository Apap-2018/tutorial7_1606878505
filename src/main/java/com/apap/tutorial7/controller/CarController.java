package com.apap.tutorial7.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.service.CarService;
import com.apap.tutorial7.service.DealerService;

/**
 * CarController
 * @author Zaki Raihan
 *
 */
@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	private DealerService dealerService;
	
	@Autowired
	private CarService carService;
	
	@PostMapping()
	private CarModel addCarSubmit(@RequestBody CarModel car) {
		return carService.addCar(car);
	}
	
	@GetMapping(value = "/{carId}")
	private CarModel viewCar(@PathVariable ("carId") long carId, Model model ) {
		return carService.getCarDetailById(carId).get();
	}
	
	@GetMapping()
	private List<CarModel> viewAllCar(Model model ) {
		return carService.getAllCar();
	}

	@DeleteMapping(value = "/{carId}")
	private String deleteCar(@PathVariable ("carId") long carId, Model model ) {
		carService.deleteCarById(carId);
		return "Car Has Been Deleted";
	}
	
	@PutMapping(value = "/{id}")
	private String updateCarSubmit(
			@PathVariable (value = "id") long id,
			@RequestParam("brand") Optional<String> brand,
			@RequestParam("type") Optional<String> type,
			@RequestParam("price") Optional<Long> price,
			@RequestParam("amount") Optional<Integer> amount,
			@RequestParam("dealerId") Optional<Long> dealerId) {
		CarModel car = (CarModel) carService.getCarDetailById(id).get();
		if (car.equals(null)) {
			return "Couldn't find your car";
		}
		if (brand.isPresent()) {
			car.setBrand(brand.get());
		}
		if (type.isPresent()) {
			car.setType(type.get());
		}
		if (price.isPresent()) {
			car.setPrice(price.get());
		}
		if (amount.isPresent()) {
			car.setAmount(amount.get());
		}
		if (dealerId.isPresent()) {
			DealerModel dealerModel = dealerService.getDealerDetailById(dealerId.get()).get();
			car.setDealer(dealerModel);
		}
		carService.updateCar(id, car);
		return "Car Update Success";
		
	}
}
