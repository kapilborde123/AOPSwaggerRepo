package com.cts.service;

import java.util.List;
import java.util.Optional;

import com.cts.entity.Driver;

public interface DriverService {
	
	Driver addDriver(Driver driver);
	List<Driver> getAllDrivers();
	Driver updateDriver(int id, Driver driver);
	Optional<Driver> findDriverByTeleAndEngine(String telephonenumber, String engineSize);
	List<Driver> findDriversByCity(String city);
	String deleteDriver(int id);

}
