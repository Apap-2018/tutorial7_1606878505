package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.DealerModel;

/**
 * DealerService
 * @author Zaki Raihan
 *
 */
public interface DealerService {
	
	List<DealerModel> getAllDealer();
	
	Optional<DealerModel> getDealerDetailById(Long id);
	
	DealerModel addDealer(DealerModel dealer);

	void updateDealer(Long dealerId, DealerModel newDealer);

	void deleteDealerById(Long dealerId);

	void deleteDealer(DealerModel dealer);
}
