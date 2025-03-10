package com.cts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Column(nullable = false)
	private String firstName;

    @NotNull
    @Size(min = 10, max = 10, message = "Telephone number must be 10 digits")
    @Pattern(regexp = "\\d{10}", message = "Telephone number must contain only digits")
    @Column(length = 10, nullable = false, unique = true)
	private String telephonenumber;
    @NotNull
    @Column(nullable = false)
	private String address;
    @NotNull
    @Column(nullable = false)
	private String city;
	private String engineSize;
	@Min(value = 1000, message = "Quote amount must be at least 1000")
	private long quoteAmount;
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Driver(int id, @NotNull String firstName,
			@NotNull @Size(min = 10, max = 10, message = "Telephone number must be 10 digits") @Pattern(regexp = "\\d{10}", message = "Telephone number must contain only digits") String telephonenumber,
			@NotNull String address, @NotNull String city, String engineSize,
			@Min(value = 1000, message = "Quote amount must be at least 1000") long quoteAmount) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.telephonenumber = telephonenumber;
		this.address = address;
		this.city = city;
		this.engineSize = engineSize;
		this.quoteAmount = quoteAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getTelephonenumber() {
		return telephonenumber;
	}
	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEngineSize() {
		return engineSize;
	}
	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}
	public long getQuoteAmount() {
		return quoteAmount;
	}
	public void setQuoteAmount(long quoteAmount) {
		this.quoteAmount = quoteAmount;
	}
	@Override
	public String toString() {
		return "Driver [id=" + id + ", firstName=" + firstName + ", telephonenumber=" + telephonenumber + ", address="
				+ address + ", city=" + city + ", engineSize=" + engineSize + ", quoteAmount=" + quoteAmount + "]";
	}
	
	
	
	

}
