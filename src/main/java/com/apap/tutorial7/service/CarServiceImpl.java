package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.repository.CarDb;

/**
 * CarServiceImpl
 * @author Zaki Raihan
 *
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDb carDb;
	
	@Override
	public CarModel addCar (CarModel car) {
		return carDb.save(car);
	}
	
	@Override
	public Optional<CarModel> getCarDetailById(Long id) {
		return carDb.findById(id);
	}
	
	@Override
	public void updateCar(Long carId, CarModel newCar) {
		CarModel oldCar = this.getCarDetailById(carId).get();
		oldCar.setBrand(newCar.getBrand());
		oldCar.setType(newCar.getType());
		oldCar.setPrice(newCar.getPrice());
		oldCar.setAmount(newCar.getAmount());
		
	}
	
	@Override
	public void deleteCarById(Long carId) {
		carDb.delete(this.getCarDetailById(carId).get());
	}
	
	@Override
	public List<CarModel> getAllCar(){
		return carDb.findAll();
	}
	
	@Override
	public List<CarModel> getByBrand(String brand){
		return carDb.findByBrand(brand);
	}

}
