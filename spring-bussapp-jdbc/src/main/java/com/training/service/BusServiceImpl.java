package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.exception.BusNotFoundException;
import com.training.model.Bus;
import com.training.repository.IBusRepository;

@Service
public class BusServiceImpl implements IBusService {
	
	private IBusRepository busRepository;
	
	@Autowired
	public BusServiceImpl(IBusRepository busRepository) {
		super();
		this.busRepository = busRepository;
	}

	@Override
	public List<Bus> getAll() {
		List<Bus> buses=busRepository.findAll();
		
		return buses;
	}

	@Override
	public List<Bus> getByType(String type) {
		List<Bus> buses=busRepository.findByType(type);
		if(buses.isEmpty())
			throw new BusNotFoundException();
		return buses;
	}

	@Override
	public Bus getById(int busId) {
		Bus bus=busRepository.findById(busId);
		return bus;
	}

	@Override
	public List<Bus> getBySourceDestination(String source,String destination) throws BusNotFoundException {

		List<Bus> buses=busRepository.findBySourceDestination(source,destination);
		return buses;
	}

	@Override
	public void addBus(Bus bus) {
		busRepository.addBus(bus);
	}

	@Override
	public void updateBus(int fare,int busId) {
		busRepository.updateBus(fare,busId);
	}

	@Override
	public void deleteBus(int busId) {
		busRepository.deleteBus(busId);		
	}

	

}
