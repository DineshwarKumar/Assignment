package com.training.repository;

import java.util.List;

import com.training.exception.BusNotFoundException;
import com.training.exception.IdNotFoundException;
import com.training.model.Bus;

public interface IBusRepository {
	
	void addBus(Bus bus);
	void updateBus(int fare,int busId);
	void deleteBus(int busId);
	
	public List<Bus> findAll();
	public List<Bus> findByType(String type) throws BusNotFoundException;
	public Bus findById(int busId) throws IdNotFoundException;
	public List<Bus> findBySourceDestination(String source,String destination) throws BusNotFoundException;
	
}
