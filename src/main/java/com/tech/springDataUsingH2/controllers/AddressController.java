package com.tech.springDataUsingH2.controllers;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.springDataUsingH2.domain.Address;
import com.tech.springDataUsingH2.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@ApiOperation(value = "Find all addresses")
	@RequestMapping(value="/findAllAddress", method=RequestMethod.GET)
	public List<Address> findAll(){
		return addressService.findAll();
	}
	
	
}
