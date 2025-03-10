package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Driver;
import com.cts.exception.DriverIdAlreadyExistException;
import com.cts.exception.DriverIdNotFoundException;
import com.cts.repository.DriverRepository;
@Service
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	private DriverRepository driverRepository;

	@Override
	public Driver addDriver(Driver driver) {
		if(driverRepository.existsById(driver.getId())) {
			throw new DriverIdAlreadyExistException("Driver id already exist: " + driver.getId());
		}
		
		return driverRepository.save(driver);
	}

	@Override
	public List<Driver> getAllDrivers() {
		
		return driverRepository.findAll();
	}

	@Override
	public Driver updateDriver(int id, Driver updatesDriver) {
		 Optional<Driver> existingDriverOptional = driverRepository.findById(id);
		if(existingDriverOptional.isPresent()) {
			Driver existingDriver = existingDriverOptional.get();
			existingDriver.setFirstName(updatesDriver.getFirstName());
			existingDriver.setCity(updatesDriver.getCity());
			existingDriver.setAddress(updatesDriver.getAddress());
			existingDriver.setEngineSize(updatesDriver.getEngineSize());
			existingDriver.setQuoteAmount(updatesDriver.getQuoteAmount());
			existingDriver.setTelephonenumber(updatesDriver.getTelephonenumber());
			return driverRepository.save(existingDriver);
		}else {
			 throw new DriverIdNotFoundException("DriverIdNotFoundException: " + id);
		}
		
	}

	
	  @Override 
	  public Optional<Driver> findDriverByTeleAndEngine(String telephonenumber, String engineSize) {
	 return driverRepository.findByTelephonenumberAndEngineSizeGreaterThanEqual( telephonenumber, engineSize); }
	
	  
	@Override
	public List<Driver> findDriversByCity(String city) {
		
		return driverRepository.findByCity(city);
	}

	@Override
	public String deleteDriver(int id) {
		if(driverRepository.existsById(id)) {
			driverRepository.deleteById(id);
			return "driver id deleted";
		}else {
			throw new DriverIdNotFoundException("Driver id not found: " + id);
		}
		
		
	}

}
