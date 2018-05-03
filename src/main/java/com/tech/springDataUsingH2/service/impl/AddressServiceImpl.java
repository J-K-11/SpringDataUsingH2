package com.tech.springDataUsingH2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.springDataUsingH2.domain.Address;
import com.tech.springDataUsingH2.repository.AddressRepository;
import com.tech.springDataUsingH2.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired 
	private AddressRepository addressRepository;

	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

}
