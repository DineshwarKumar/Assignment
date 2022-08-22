package com.training.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.training.exception.BusNotFoundException;
import com.training.exception.IdNotFoundException;
import com.training.model.Bus;
import com.training.util.DbQuery;

@Repository
public class BusRepositoryImpl implements IBusRepository {

	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public BusRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Bus> findAll() {
		List<Bus> buses=jdbcTemplate.query(DbQuery.selectQuery, new RowMapper<Bus>() {

			@Override
			public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bus bus=new Bus();
				bus.setSource(rs.getString("source"));
				bus.setDestination(rs.getString("destination"));
				bus.setBusId(rs.getInt("bus_id"));
				bus.setType(rs.getString("type"));
				bus.setFare(rs.getDouble("fare"));
					
				return bus;
			}
		});
		return buses;
	}

	@Override
	public List<Bus> findByType(String type) {
		List<Bus> buses=jdbcTemplate.query(DbQuery.selectByType, new RowMapper<Bus>() {

			@Override
			public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bus bus=new Bus();
				bus.setSource(rs.getString("source"));
				bus.setDestination(rs.getString("destination"));
				bus.setBusId(rs.getInt("bus_id"));
				bus.setType(rs.getString("type"));
				bus.setFare(rs.getDouble("fare"));
					
				return bus;
			}
		},type);
		return buses;
	}
	
	@Override
	public Bus findById(int busId) {
		Bus buses=jdbcTemplate.queryForObject(DbQuery.selectById, new RowMapper<Bus>() {

			@Override
			public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bus bus=new Bus();
				bus.setSource(rs.getString("source"));
				bus.setDestination(rs.getString("destination"));
				bus.setBusId(rs.getInt("bus_id"));
				bus.setType(rs.getString("type"));
				bus.setFare(rs.getDouble("fare"));
					
				return bus;
			}
		},busId);
		return buses;
	}
	
	
	

	@Override
	public List<Bus> findBySourceDestination(String source,String destination) throws BusNotFoundException {
		List<Bus> buses=jdbcTemplate.query(DbQuery.selectBySourceDestination, new RowMapper<Bus>() {

			@Override
			public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bus bus=new Bus();
				bus.setSource(rs.getString("source"));
				bus.setDestination(rs.getString("destination"));
				bus.setBusId(rs.getInt("bus_id"));
				bus.setType(rs.getString("type"));
				bus.setFare(rs.getDouble("fare"));
					
				return bus;
			}
		},source,destination);
		return buses;
		
		
	}

	@Override
	public void addBus(Bus bus) {
		Object[] busArray= {
				bus.getSource(),bus.getDestination(),bus.getBusId(),bus.getType(),bus.getFare()
		};
		jdbcTemplate.update(DbQuery.addBus,busArray);		
	}

	@Override
	public void updateBus(int fare,int busId) {
		jdbcTemplate.update( DbQuery.updateQuery,fare,busId);
		
	}

	@Override
	public void deleteBus(int busId) {
		jdbcTemplate.update( DbQuery.deleteBus,busId);
	}

	

}
