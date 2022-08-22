package com.training.util;

public class DbQuery {
	
	public static final String selectQuery="select * from bussapp";
	public static final String selectBySourceDestination="select * from bussapp where source= ? and destination=? ";
	public static final String selectByType="select * from bussapp where type=?";
	public static final String selectById="select * from bussapp where bus_id=?";
	
	public static final String addBus="insert into bussapp (source,destination,bus_id,type,fare) values (?,?,?,?,?)";
	public static final String updateQuery= "update bussapp set fare=? where bus_id=? ";
	public static final String deleteBus="delete from bussapp where bus_id = ?";
	
	
	
	
	

}
