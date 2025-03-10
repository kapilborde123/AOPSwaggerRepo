package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Driver;
import com.cts.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	
 
	
    @PostMapping
	public ResponseEntity<Driver> addDriver(@RequestBody  Driver driver) {
		
		
		return ResponseEntity.ok(driverService.addDriver(driver));
	}

    @GetMapping	
	public ResponseEntity<List<Driver>> getAllDrivers() {
		
		return ResponseEntity.ok( driverService.getAllDrivers());
	}

	@PutMapping("/")
	public ResponseEntity<Driver> updateDriver(@PathVariable  int id,@RequestBody Driver updatesDriver) {
		  
		  return  ResponseEntity.ok(driverService.updateDriver(id, updatesDriver));
	
		
	}
	 @GetMapping("/search")
	    public Optional<Driver> findDriverByTeleAndEngine(@RequestParam String telephonenumber, @RequestParam String engineSize) {
	        return driverService.findDriverByTeleAndEngine(telephonenumber, engineSize);
	    }

	@GetMapping("/{city}")
	public ResponseEntity<List<Driver>> findDriversByCity(@PathVariable String city) {
		
		return ResponseEntity.ok(driverService.findDriversByCity(city));
	}

	@DeleteMapping("/{id}")
	public  ResponseEntity<String> deleteDriver(@PathVariable int id) {
		return ResponseEntity.ok(driverService.deleteDriver(id));
		
		
	}

}
