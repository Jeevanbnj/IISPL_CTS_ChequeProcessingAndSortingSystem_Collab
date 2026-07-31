package com.iispl.connectionpool;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPool {
	
	private static ComboPooledDataSource dataSource;
	static {
		try {
			
			//connection 
			//dataSouce Configuration
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource() {
		return dataSource;
	}
	
}
