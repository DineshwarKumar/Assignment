package com.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.exception.BusNotFoundException;
import com.training.exception.IdNotFoundException;
import com.training.model.Bus;

@Service
public interface IBusService {
	
	void addBus(Bus bus);
	void updateBus(int fare, int busId);
	void deleteBus(int busId);
	
	public List<Bus> getAll();
	public List<Bus> getByType(String type) throws BusNotFoundException;
	public Bus getById(int busId) throws IdNotFoundException;
	public List<Bus> getBySourceDestination(String source,String destination) throws BusNotFoundException;

}
