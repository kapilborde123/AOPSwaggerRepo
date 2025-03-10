package com.cts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.entity.Driver;
@Repository
public interface DriverRepository  extends JpaRepository<Driver, Integer>{
	

    Optional<Driver> findByTelephonenumberAndEngineSizeGreaterThanEqual(String telephonenumber, String engineSize);
    
    List<Driver> findByCity(String city);
	
	

}
