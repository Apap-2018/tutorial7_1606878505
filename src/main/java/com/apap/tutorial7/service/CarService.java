package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.CarModel;

/**
 * CarService
 * @author Zaki Raihan
 *
 */
public interface CarService {
	CarModel addCar(CarModel car);
	
	Optional<CarModel> getCarDetailById(Long id);
	
	void updateCar(Long carId, CarModel newCar);

	void deleteCarById(Long carId);

	List<CarModel> getAllCar();

	List<CarModel> getByBrand(String brand);
}


